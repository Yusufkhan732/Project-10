package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.StartupDTO;

/**
 * Startup Form. Used to capture startup details from UI and convert into DTO.
 * Includes validation for required fields.
 * 
 * @author Yusuf Khan
 */
public class StartupForm extends BaseForm {

	@NotEmpty(message = "Startup Name is required")
	private String startupName;

	@NotEmpty(message = "Founder Name is required")
	private String founderName;

	@NotEmpty(message = "Domain is required")
	private String domain;

	@NotEmpty(message = "Funding Amount is required")
	@Pattern(regexp = "^\\d+(\\.\\d{1,2})?$", message = "Enter valid funding amount")
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
	public BaseDTO getDto() {

		StartupDTO dto = initDTO(new StartupDTO());

		dto.setStartupName(startupName);
		dto.setFounderName(founderName);
		dto.setDomain(domain);
		dto.setFundingAmount(fundingAmount);

		return dto;
	}
}