package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.SecretDTO;

@Repository
public class SecretDAOImpl extends BaseDAOImpl<SecretDTO> implements SecretDAOInt {

	@Override
	public Class<SecretDTO> getDTOClass() {
		return SecretDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(SecretDTO dto, CriteriaBuilder builder, Root<SecretDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		return whereCondition;

	}

}
