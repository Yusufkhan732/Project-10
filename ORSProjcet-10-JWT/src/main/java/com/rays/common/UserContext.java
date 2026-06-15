package com.rays.common;

import com.rays.dto.UserDTO;

/**
 * Holds logged-in user information.
 * Used across application for user/session data.
 * 
 * @author Yusuf Khan
 */
public class UserContext {

	private Long userId = 0L;
	private String loginId = "root";
	private String name = null;
	private Long roleId = 0L;
	private String roleName = "root";

	private UserDTO userDTO = null;

	/**
	 * Default constructor.
	 */
	public UserContext() {
	}

	/**
	 * Initialize from UserDTO.
	 */
	public UserContext(UserDTO dto) {
		this.userDTO = dto;
		this.userId = dto.getId();
		this.loginId = dto.getLoginId();
		this.name = dto.getFirstName();
		this.roleId = dto.getRoleId();
		this.roleName = dto.getRoleName();
	}

	/**
	 * Get user ID.
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Set user ID.
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Get login ID.
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Set login ID.
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * Get user name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set user name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get role ID.
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * Set role ID.
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * Get role name.
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Set role name.
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Get UserDTO.
	 */
	public UserDTO getUserDTO() {
		return userDTO;
	}

	/**
	 * Set UserDTO.
	 */
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
}