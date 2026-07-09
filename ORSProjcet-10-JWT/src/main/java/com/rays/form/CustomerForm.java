package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CustomerDTO;

public class CustomerForm extends BaseForm {

	@NotEmpty(message = "Chat Support is required")
	private String chatSupport;

	@NotEmpty(message = "Call Support is required")
	private String callSupport;

	@NotEmpty(message = "Raise Complaint is required")
	private String raiseComplaint;

	@NotEmpty(message = "FAQ is required")
	private String faq;

	public String getChatSupport() {
		return chatSupport;
	}

	public void setChatSupport(String chatSupport) {
		this.chatSupport = chatSupport;
	}

	public String getCallSupport() {
		return callSupport;
	}

	public void setCallSupport(String callSupport) {
		this.callSupport = callSupport;
	}

	public String getRaiseComplaint() {
		return raiseComplaint;
	}

	public void setRaiseComplaint(String raiseComplaint) {
		this.raiseComplaint = raiseComplaint;
	}

	public String getFaq() {
		return faq;
	}

	public void setFaq(String faq) {
		this.faq = faq;
	}

	@Override
	public BaseDTO getDto() {

		CustomerDTO dto = initDTO(new CustomerDTO());

		dto.setChatSupport(chatSupport);
		dto.setCallSupport(callSupport);
		dto.setRaiseComplaint(raiseComplaint);
		dto.setFaq(faq);

		return dto;
	}
}