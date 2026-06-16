package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CommandModelDTO;

@Repository
public class CommandModelDAOImpl extends BaseDAOImpl<CommandModelDTO> implements CommandModelDAOInt {

	@Override
	public Class<CommandModelDTO> getDTOClass() {
		return CommandModelDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(CommandModelDTO dto, CriteriaBuilder builder,
			Root<CommandModelDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();
		return whereCondition;
	}

}
