package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_customer")
public class CustomerDTO extends BaseDTO {

	@Column(name = "chatSupport")
	private String chatSupport;

	@Column(name = "callSupport")
	private String callSupport;

	@Column(name = "raiseComplaint")
	private String raiseComplaint;

	@Column(name = "faq")
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
	public String getUniqueKey() {
		return "chatSupport";
	}

	@Override
	public String getUniqueValue() {
		return chatSupport;
	}

	@Override
	public String getLabel() {
		return chatSupport;
	}

	@Override
	public String getTableName() {
		return "Customer";
	}

}