package com.rays.common;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Generic Base DAO implementation using JPA.
 * Provides common CRUD and search operations.
 * 
 * @author Yusuf Khan
 */
public abstract class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Set EntityManager manually.
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Return DTO class type.
	 */
	public abstract Class<T> getDTOClass();

	/**
	 * Build dynamic where clause for search.
	 */
	protected abstract List<Predicate> getWhereClause(T dto, CriteriaBuilder builder, Root<T> qRoot);

	/**
	 * Populate extra fields before save/update.
	 */
	protected void populate(T dto, UserContext userContext) {
	}

	/**
	 * Add new record.
	 */
	public long add(T dto, UserContext userContext) {

		dto.setCreatedBy(userContext.getLoginId());
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedBy(userContext.getLoginId());
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.persist(dto);

		return dto.getId();
	}

	/**
	 * Update existing record.
	 */
	public void update(T dto, UserContext userContext) {

		dto.setModifiedBy(userContext.getLoginId());
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.merge(dto);
	}

	/**
	 * Delete record.
	 */
	public void delete(T dto, UserContext userContext) {
		entityManager.remove(dto);
	}

	/**
	 * Find record by primary key.
	 */
	public T findByPK(long pk, UserContext userContext) {
		T dto = entityManager.find(getDTOClass(), pk);
		return dto;
	}

	/**
	 * Find record by unique field.
	 */
	public T findByUniqueKey(String attribute, Object val, UserContext userContext) {

		Class<T> dtoClass = getDTOClass();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> cq = builder.createQuery(dtoClass);

		Root<T> qRoot = cq.from(dtoClass);

		Predicate condition = builder.equal(qRoot.get(attribute), val);

		cq.where(condition);

		TypedQuery<T> query = entityManager.createQuery(cq);

		List<T> list = query.getResultList();

		T dto = null;

		if (list.size() > 0) {
			dto = list.get(0);
		}

		return dto;
	}

	/**
	 * Create criteria query for search.
	 */
	protected TypedQuery<T> createCriteria(T dto, UserContext userContext) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> cq = builder.createQuery(getDTOClass());

		Root<T> qRoot = cq.from(getDTOClass());

		cq.select(qRoot);

		List<Predicate> whereClause = getWhereClause(dto, builder, qRoot);

		cq.where(whereClause.toArray(new Predicate[whereClause.size()]));

		TypedQuery<T> query = entityManager.createQuery(cq);

		return query;
	}

	/**
	 * Search with pagination.
	 */
	public List search(T dto, int pageNo, int pageSize, UserContext userContext) {

		TypedQuery<T> query = createCriteria(dto, userContext);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List list = query.getResultList();
		return list;
	}

	/**
	 * Search without pagination.
	 */
	public List search(T dto, UserContext userContext) {
		return search(dto, 0, 0, userContext);
	}

	/**
	 * Check empty string.
	 */
	protected boolean isEmptyString(String val) {
		return val == null || val.trim().length() == 0;
	}

	/**
	 * Check zero Double.
	 */
	protected boolean isZeroNumber(Double val) {
		return val == null || val == 0;
	}

	/**
	 * Check zero Long.
	 */
	protected boolean isZeroNumber(Long val) {
		return val == null || val == 0;
	}

	/**
	 * Check zero Integer.
	 */
	protected boolean isZeroNumber(Integer val) {
		return val == null || val == 0;
	}

	/**
	 * Check not null.
	 */
	protected boolean isNotNull(Object val) {
		return val != null;
	}
}