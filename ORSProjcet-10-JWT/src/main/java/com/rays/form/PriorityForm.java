package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PriorityDTO;

public class PriorityForm extends BaseForm {

	@NotNull(message = "priorityId is required")
	@Min(1)
	private Long priorityId;

	@NotEmpty(message = "prioritycode is required")
	private String priorityCode;

	@NotEmpty(message = "priorityLevel is required")
	private String priorityLevel;

	@NotEmpty(message = "colorTag is required")
	private String colorTag;

	@NotEmpty(message = "priorityStatus is required")
	private String priorityStatus;

	public Long getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(Long priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriorityCode() {
		return priorityCode;
	}

	public void setPriorityCode(String priorityCode) {
		this.priorityCode = priorityCode;
	}

	public String getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(String priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public String getColorTag() {
		return colorTag;
	}

	public void setColorTag(String colorTag) {
		this.colorTag = colorTag;
	}

	public String getPriorityStatus() {
		return priorityStatus;
	}

	public void setPriorityStatus(String priorityStatus) {
		this.priorityStatus = priorityStatus;
	}

	@Override
	public BaseDTO getDto() {

		PriorityDTO dto = initDTO(new PriorityDTO());

		dto.setPriorityId(priorityId);
		dto.setPriorityCode(priorityCode);
		dto.setPriorityLevel(priorityLevel);
		dto.setPriorityStatus(priorityStatus);
		dto.setColorTag(colorTag);

		return dto;
	}
}
