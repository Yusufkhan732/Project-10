package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ContactDTO;

public class ContactForm extends BaseForm {

	@NotNull(message = "contactId is required")
	@Min(1)
	private Long contactId;

	@NotEmpty(message = "name is required")
	private String name;

	@NotEmpty(message = "email is required")
	private String email;

	@NotEmpty(message = "phone is required")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String mobileNo;

	@NotEmpty(message = "message is required")
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
	public BaseDTO getDto() {
		ContactDTO dto = initDTO(new ContactDTO());
		dto.setContactId(contactId);
		dto.setName(name);
		dto.setEmail(email);
		dto.setMobileNo(mobileNo);
		dto.setMessage(message);
		return dto;
	}
}
