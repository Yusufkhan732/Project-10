package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_secret")
public class SecretDTO extends BaseDTO {

	@Column(name = "secret_code")
	private String secretCode;

	@Column(name = "key_name")
	private String keyName;

	@Column(name = "value")
	private String value;

	@Column(name = "status")
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
	public String getUniqueKey() {
		return "keyName";
	}

	@Override
	public String getUniqueValue() {
		return keyName;
	}

	@Override
	public String getLabel() {
		return "key Name";
	}

	@Override
	public String getTableName() {
		return "secret";
	}

}
