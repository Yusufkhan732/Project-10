package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CricketDTO;

@Repository
public class CricketDAOImpl extends BaseDAOImpl<CricketDTO> implements CricketDAOInt {

	@Override
	public Class<CricketDTO> getDTOClass() {
		return CricketDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(CricketDTO dto, CriteriaBuilder builder, Root<CricketDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<>();

		if (!isEmptyString(dto.getPlayerName())) {
			whereCondition.add(builder.like(qRoot.get("playerName"), dto.getPlayerName() + "%"));
		}

		if (!isEmptyString(dto.getTeam())) {
			whereCondition.add(builder.like(qRoot.get("team"), dto.getTeam() + "%"));
		}

		if (!isEmptyString(dto.getRole())) {
			whereCondition.add(builder.like(qRoot.get("role"), dto.getRole() + "%"));
		}

		if (dto.getRuns() != null) {
			whereCondition.add(builder.equal(qRoot.get("runs"), dto.getRuns()));
		}

		return whereCondition;
	}
}