package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseForm;

/**
 * Forget Password Form.
 * Used to capture loginId for password recovery process.
 * 
 * @author Yusuf Khan
 */
public class ForgetPasswordForm extends BaseForm {

	@NotEmpty(message = "Login Id is required")
	private String loginId;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}