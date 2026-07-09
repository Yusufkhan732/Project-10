package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.WeatherDTO;

@Repository
public class WeatherDAOImpl extends BaseDAOImpl<WeatherDTO> implements WeatherDAOInt {

	@Override
	public Class<WeatherDTO> getDTOClass() {
		return WeatherDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(WeatherDTO dto, CriteriaBuilder builder, Root<WeatherDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<>();

		if (!isEmptyString(dto.getAlertCode())) {

			whereCondition.add(builder.like(qRoot.get("alertCode"), dto.getAlertCode() + "%"));
		}

		if (!isEmptyString(dto.getCityName())) {

			whereCondition.add(builder.like(qRoot.get("cityName"), dto.getCityName() + "%"));
		}

		if (dto.getTemperature() != null) {

			whereCondition.add(builder.equal(qRoot.get("temperature"), dto.getTemperature()));
		}

		if (!isEmptyString(dto.getStatus())) {

			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
		}

		return whereCondition;
	}
}