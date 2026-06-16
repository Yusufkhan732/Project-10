package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_command")
public class CommandModelDTO extends BaseDTO {

	@Column(name = "commandName")
	private String commandName;

	@Column(name = "response")
	private String response;

	@Column(name = "language")
	private String language;

	@Column(name = "createdBy")
	private String createdBy;

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String getUniqueKey() {
		return "commandName";
	}

	@Override
	public String getUniqueValue() {
		return commandName;
	}

	@Override
	public String getLabel() {
		return commandName;
	}

	@Override
	public String getTableName() {
		return "command Name";
	}

}
