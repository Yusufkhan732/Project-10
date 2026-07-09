package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.UserDTO;

public interface UserServiceInt extends BaseServiceInt<UserDTO> {

	public UserDTO findByLoginId(String name, UserContext userContext);

	public UserDTO register(UserDTO dto, UserContext userContext);

	public UserDTO authenticate(String name, String password);

	public boolean forgetPassword(String loginId);

	public UserDTO changePassword(String loginId, String oldPassword, String newPassword, UserContext userContext);

}