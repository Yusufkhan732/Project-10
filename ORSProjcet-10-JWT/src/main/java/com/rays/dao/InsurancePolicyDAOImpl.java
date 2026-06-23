package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.InsurancePolicyDTO;

@Repository
public class InsurancePolicyDAOImpl extends BaseDAOImpl<InsurancePolicyDTO> implements InsurancePolicyDAOInt {
	@Override
	public Class<InsurancePolicyDTO> getDTOClass() {
		return InsurancePolicyDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(InsurancePolicyDTO dto, CriteriaBuilder builder,
			Root<InsurancePolicyDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (dto.getId() != null) {

			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));

		}

		if (!isEmptyString(dto.getPolicyNumber())) {

			whereCondition.add(builder.like(qRoot.get("policyNumber"), dto.getPolicyNumber() + "%"));

		}

		if (!isEmptyString(dto.getHolderName())) {

			whereCondition.add(builder.like(qRoot.get("holderName"), dto.getHolderName() + "%"));

		}

		return whereCondition;
	}

}
