package com.rays.common;

import java.util.List;

/**
 * Generic DAO interface for CRUD operations.
 * 
 * @author Yusuf Khan
 */
public interface BaseDAOInt<T extends BaseDTO> {

	/**
	 * Add new record.
	 */
	public long add(T dto, UserContext userContext);

	/**
	 * Update record.
	 */
	public void update(T dto, UserContext userContext);

	/**
	 * Delete record.
	 */
	public void delete(T dto, UserContext userContext);

	/**
	 * Find by primary key.
	 */
	public T findByPK(long pk, UserContext userContext);

	/**
	 * Find by unique field.
	 */
	public T findByUniqueKey(String attribute, Object val, UserContext userContext);

	/**
	 * Search with pagination.
	 */
	public List search(T dto, int pageNo, int pageSize, UserContext userContext);

	/**
	 * Search without pagination.
	 */
	public List search(T dto, UserContext userContext);

}