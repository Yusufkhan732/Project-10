package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_startup")
public class StartupDTO extends BaseDTO {

	@Column(name = "startup_name", length = 100)
	private String startupName;

	@Column(name = "founder_name", length = 100)
	private String founderName;

	@Column(name = "domain", length = 100)
	private String domain;

	@Column(name = "funding_amount", length = 50)
	private String fundingAmount;

	public String getStartupName() {
		return startupName;
	}

	public void setStartupName(String startupName) {
		this.startupName = startupName;
	}

	public String getFounderName() {
		return founderName;
	}

	public void setFounderName(String founderName) {
		this.founderName = founderName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getFundingAmount() {
		return fundingAmount;
	}

	public void setFundingAmount(String fundingAmount) {
		this.fundingAmount = fundingAmount;
	}

	@Override
	public String getUniqueKey() {
		return "startupName";
	}

	@Override
	public String getUniqueValue() {
		return startupName;
	}

	@Override
	public String getLabel() {
		return "Startup Name";
	}

	@Override
	public String getTableName() {
		return "Startup";
	}

	@Override
	public String getValue() {
		return startupName;
	}
}