package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SecretDTO;

public class SecretForm extends BaseForm {

	@NotEmpty(message = "secretCode is required")
	private String secretCode;

	@NotEmpty(message = "secretCode is required")
	private String keyName;

	@NotEmpty(message = "secretCode is required")
	private String value;

	@NotEmpty(message = "secretCode is required")
	private String status;

	public String getSecretCode() {
		return secretCode;
	}

	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {

		SecretDTO dto = initDTO(new SecretDTO());

		dto.setKeyName(keyName);
		dto.setSecretCode(secretCode);
		dto.setStatus(status);
		dto.setValue(value);

		return dto;

	}
}
