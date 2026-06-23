package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.StartupDTO;

@Repository
public class StartupDAOImpl extends BaseDAOImpl<StartupDTO> implements StartupDAOInt {

	@Override
	public Class<StartupDTO> getDTOClass() {
		return StartupDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(StartupDTO dto, CriteriaBuilder builder, Root<StartupDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<>();

		if (!isEmptyString(dto.getStartupName())) {

			whereCondition.add(builder.like(qRoot.get("startupName"), dto.getStartupName() + "%"));
		}

		if (!isEmptyString(dto.getFounderName())) {

			whereCondition.add(builder.like(qRoot.get("founderName"), dto.getFounderName() + "%"));
		}

		if (!isEmptyString(dto.getDomain())) {

			whereCondition.add(builder.like(qRoot.get("domain"), dto.getDomain() + "%"));
		}

		if (!isEmptyString(dto.getFundingAmount())) {

			whereCondition.add(builder.like(qRoot.get("fundingAmount"), dto.getFundingAmount() + "%"));
		}

		return whereCondition;
	}
}