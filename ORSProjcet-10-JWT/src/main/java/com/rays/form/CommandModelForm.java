package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CommandModelDTO;

public class CommandModelForm extends BaseForm {

	@NotEmpty(message = "commandName is required")
	private String commandName;

	@NotEmpty(message = "response is required")
	private String response;

	@NotEmpty(message = "language is required")
	private String language;

	@NotEmpty(message = "createdBy is required")
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
	public BaseDTO getDto() {
		CommandModelDTO dto = initDTO(new CommandModelDTO());

		dto.setCommandName(commandName);
		dto.setLanguage(language);
		dto.setCreatedBy(createdBy);
		dto.setResponse(response);
		dto.setLanguage(language);

		return dto;
	}
}
