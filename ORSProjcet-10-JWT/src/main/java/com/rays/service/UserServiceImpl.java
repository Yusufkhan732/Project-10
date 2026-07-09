package com.rays.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;
import com.rays.email.EmailBuilder;
import com.rays.email.EmailMessage;
import com.rays.email.EmailServiceInt;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDAOInt> implements UserServiceInt {

	@Autowired
	private UserDAOInt userdao;

	@Autowired
	private EmailServiceInt emailservice;

	@Transactional(readOnly = true)
	public UserDTO findByLoginId(String login, UserContext userContext) {
		return baseDao.findByUniqueKey("loginId", login, userContext);
	}

	@Override
	public UserDTO register(UserDTO dto, UserContext userContext) {

		Long id = add(dto, userContext);
		dto.setId(id);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", dto.getLoginId());
		map.put("password", dto.getPassword());
		map.put("firstName", dto.getFirstName());

		EmailMessage msg = new EmailMessage();
		msg.setTo(dto.getLoginId());
		msg.setSubject("Registration is successful for ORS Project");
		msg.setMessage(EmailBuilder.getUserRegistrationMessage(map));
		msg.setMessageType(EmailMessage.HTML_MSG);

		emailservice.sendMail(msg);
		return dto;
	}

	@Override
	public UserDTO authenticate(String loginId, String password) {
		UserDTO dto = findByLoginId(loginId, null);

		if (dto != null) {
			UserContext userContext = new UserContext(dto);
			if (password.equals(dto.getPassword())) {
				dto.setLastLogin(new Timestamp((new Date()).getTime()));
				dto.setUnsucessfullLoginAttempt(0);
				update(dto, userContext);
				return dto;
			} else {
				dto.setUnsucessfullLoginAttempt(1 + dto.getUnsucessfullLoginAttempt());
				update(dto, userContext);
			}

		}
		return null;
	}

	@Override
	public boolean forgetPassword(String loginId) {

		UserDTO dto = findByLoginId(loginId, null);

		if (dto == null) {
			return false;
		}

		// Data map banayenge
		HashMap<String, String> map = new HashMap<>();

		map.put("firstName", dto.getFirstName());
		map.put("lastName", dto.getLastName());
		map.put("login", dto.getLoginId());
		map.put("password", dto.getPassword());

		// HTML message generate
		String message = EmailBuilder.getForgetPasswordMessage(map);

		// Email object create
		EmailMessage email = new EmailMessage();

		email.setTo(dto.getLoginId());
		email.setSubject("ORS Password Recovery");
		email.setMessage(message);
		email.setMessageType(EmailMessage.HTML_MSG);

		// Send mail
		emailservice.sendMail(email);

		return true;
	}

	/**
	 * Changes the password for a user and sends a notification email.
	 * 
	 * @param loginId     Login ID of the user
	 * @param oldPassword Current password of the user
	 * @param newPassword New password to set
	 * @param userContext Context information of the user making the change
	 * @return Updated UserDTO if successful, otherwise null
	 */
	@Override
	public UserDTO changePassword(String loginId, String oldPassword, String newPassword, UserContext userContext) {

		UserDTO dto = findByLoginId(loginId, null);
		dto.setCreatedBy(userContext.getLoginId());

		if (dto != null && oldPassword.equals(dto.getPassword())) {

			dto.setPassword(newPassword);
			update(dto, userContext);

			HashMap<String, String> map = new HashMap<>();
			map.put("firstName", dto.getFirstName());
			map.put("lastName", dto.getLastName());
			map.put("login", dto.getLoginId());
			map.put("password", dto.getPassword());

			String message = EmailBuilder.getChangePasswordMessage(map);

			EmailMessage email = new EmailMessage();
			email.setTo(dto.getLoginId());
			email.setSubject("ORS Password Changed Successfully");
			email.setMessage(message);
			email.setMessageType(EmailMessage.HTML_MSG);

			emailservice.sendMail(email);
			return dto;

		} else {

		}
		return dto;
	}
}