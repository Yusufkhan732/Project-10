package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_priority")
public class PriorityDTO extends BaseDTO {

	@Column(name = "priority_id")
	private Long priorityId;

	@Column(name = "priority_code")
	private String priorityCode;

	@Column(name = "priority_level")
	private String priorityLevel;

	@Column(name = "color_tag")
	private String colorTag;

	@Column(name = "priority_status")
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
	public String getUniqueKey() {
		return "priorityCode";
	}

	@Override
	public String getUniqueValue() {
		return priorityCode;
	}

	@Override
	public String getLabel() {
		return "priorityCode";
	}

	@Override
	public String getTableName() {
		return "priority";
	}
}
