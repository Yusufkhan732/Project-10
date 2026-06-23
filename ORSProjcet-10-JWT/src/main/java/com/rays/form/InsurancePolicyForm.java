package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.InsurancePolicyDTO;

public class InsurancePolicyForm extends BaseForm {

	@NotEmpty(message = "policyNumber is required")
	private String policyNumber;

	@NotEmpty(message = "holderName is required")
	private String holderName;

	@NotEmpty(message = "premiumAmount is required")
	private String premiumAmount;

	@NotEmpty(message = "policyType  is required")
	private String policyType;

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(String premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	@Override
	public BaseDTO getDto() {
		InsurancePolicyDTO dto = initDTO(new InsurancePolicyDTO());

		dto.setPolicyNumber(policyNumber);
		dto.setPolicyType(policyType);
		dto.setPremiumAmount(premiumAmount);
		dto.setHolderName(holderName);

		return dto;
	}
}
