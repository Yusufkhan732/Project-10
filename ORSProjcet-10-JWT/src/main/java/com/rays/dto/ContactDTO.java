package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_contact")
public class ContactDTO extends BaseDTO {
	
	@Column(name = "contect_id")
	private Long contactId;
	
	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "email", length = 50)
	private String email;

	@Column(name = "mobile_no", length = 50)
	private String mobileNo;

	@Column(name = "message")
	private String message;

	
	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getUniqueKey() {
		return "email";
	}

	@Override
	public String getUniqueValue() {
		return email;
	}

	@Override
	public String getLabel() {
		return "Email Id";
	}

	@Override
	public String getTableName() {
		return "contact";
	}
}
