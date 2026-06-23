package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.InsurancePolicyDAOInt;
import com.rays.dto.InsurancePolicyDTO;

@Service
public class InsurancePolicyServiceImpl extends BaseServiceImpl<InsurancePolicyDTO, InsurancePolicyDAOInt>
		implements InsurancePolicyServiceInt {
}
