package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_insurace")
public class InsurancePolicyDTO extends BaseDTO {

	@Column(name = "policyNumber", length = 50)
	private String policyNumber;

	@Column(name = "holderName", length = 50)
	private String holderName;

	@Column(name = "premiumAmount", length = 50)
	private String premiumAmount;

	@Column(name = "policyType", length = 50)
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
	public String getUniqueKey() {
		return "policyNumber";
	}

	@Override
	public String getUniqueValue() {
		return policyNumber;
	}

	@Override
	public String getLabel() {
		return "policyNumber";
	}

	@Override
	public String getTableName() {
		return "policy Number";
	}

}
