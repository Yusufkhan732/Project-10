package com.rays.ctl;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import com.rays.attachment.AttachmentDTO;
import com.rays.attachment.AttachmentService;
import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.common.UserContext;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;
import com.rays.form.ChangePasswordForm;
import com.rays.form.MyProfileForm;
import com.rays.form.UserForm;
import com.rays.service.RoleServiceInt;
import com.rays.service.UserServiceInt;

/**
 * User Controller. Handles user management, profile update, password change and
 * profile picture upload/download.
 * 
 * @author Yusuf Khan
 */
@RestController
@RequestMapping(value = "User")
public class UserCtl extends BaseCtl<UserForm, UserDTO, UserServiceInt> {

	@Autowired
	private RoleServiceInt roleService;

	@Autowired
	private UserServiceInt userService;

	@Autowired
	private AttachmentService attachment;

	/**
	 * Load role list for dropdown.
	 */
	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse resp = new ORSResponse(true);

		List<DropdownList> roleList = roleService.search(new RoleDTO(), userContext);

		resp.addResult("roleList", roleList);

		return resp;
	}

	/**
	 * Update logged-in user profile.
	 */
	@PostMapping("myProfile")
	public ORSResponse myProfile(@RequestBody @Valid MyProfileForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = baseService.findById(userContext.getUserId(), userContext);
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLoginId(form.getLogin());
		dto.setDob(form.getDob());
		dto.setPhone(form.getMobileNo());
		dto.setGender(form.getGender());

		baseService.update(dto, userContext);

		return res;
	}

	/**
	 * Change user password.
	 */
	@PostMapping("changePassword")
	public ORSResponse changePassword(@RequestBody @Valid ChangePasswordForm form, BindingResult bindingResult) {
		ORSResponse res = validate(bindingResult);
		if (!res.isSuccess())
			return res;

		UserDTO changedDto = baseService.changePassword(form.getLoginId(), form.getOldPassword(), form.getNewPassword(),
				userContext);

		if (changedDto == null) {
			res.setSuccess(false);
			res.addMessage("Invalid old password");
			return res;
		}

		res.setSuccess(true);
		res.addMessage("Password has been changed");
		return res;
	}

	/**
	 * Upload profile picture.
	 */
	@PostMapping("/profilePic/{userId}")
	public ORSResponse uploadPic(@PathVariable Long userId, @RequestParam("file") MultipartFile file,
			HttpServletRequest req) {

		UserContext userContext = new UserContext();

		AttachmentDTO attachmentDto = new AttachmentDTO(file);
		attachmentDto.setDescription("profile pic");
		attachmentDto.setUserId(userId);

		UserDTO userDto = userService.findById(userId, userContext);

		if (userDto.getImageId() != null && userDto.getImageId() > 0) {
			attachmentDto.setId(userDto.getImageId());
		}

		Long imageId = attachment.save(attachmentDto, userContext);

		if (userDto.getImageId() == null) {
			userDto.setImageId(imageId);
			userService.update(userDto, userContext);
		}

		ORSResponse res = new ORSResponse(true);
		res.addResult("imageId", imageId);

		return res;
	}

	/**
	 * Download profile picture.
	 */
	@GetMapping("/profilePic/{userId}")
	public @ResponseBody void downloadPic(@PathVariable Long userId, HttpServletResponse response) {

		try {

			UserDTO userDto = userService.findById(userId, userContext);
			AttachmentDTO attachmentDTO = null;

			if (userDto != null) {
				attachmentDTO = attachment.findById(userDto.getImageId());
			}

			if (attachmentDTO != null) {
				response.setContentType(attachmentDTO.getType());
				OutputStream out = response.getOutputStream();
				out.write(attachmentDTO.getDoc());
				out.close();
			} else {
				response.getWriter().write("ERROR: File not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}