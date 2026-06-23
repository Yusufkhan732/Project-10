package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.InsurancePolicyDTO;
import com.rays.form.InsurancePolicyForm;
import com.rays.service.InsurancePolicyServiceInt;

@RestController
@RequestMapping(value = "InsurancePolicy")
public class InsurancePolicyCtl extends BaseCtl<InsurancePolicyForm, InsurancePolicyDTO, InsurancePolicyServiceInt> {

}
