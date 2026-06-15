package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ContactDTO;

@Repository
public class ContactDAOImpl extends BaseDAOImpl<ContactDTO> implements ContactDAOInt {

	@Override
	public Class<ContactDTO> getDTOClass() {
		return ContactDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ContactDTO dto, CriteriaBuilder builder, Root<ContactDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));

		}
		if (!isEmptyString(dto.getEmail())) {
			whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));

		}

		return whereCondition;
	}
}
