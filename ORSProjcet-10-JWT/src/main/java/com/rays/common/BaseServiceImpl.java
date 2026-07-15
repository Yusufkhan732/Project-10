
package com.rays.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.exception.DatabaseException;
import com.rays.exception.DuplicateRecordException;

/**
 * Generic Base Service implementation.
 * Handles business logic and delegates DB operations to DAO.
 * 
 * @author Yusuf Khan
 */
public class BaseServiceImpl<T extends BaseDTO, D extends BaseDAOInt<T>> implements BaseServiceInt<T> {

	@Autowired
	protected D baseDao;

	/**
	 * Add new record.
	 * 
	 * Agar readOnly specify nahi karte, to by default readOnly = false hota hai.
	 */
	@Transactional(readOnly = false)
	public long add(T dto, UserContext userContext) throws DuplicateRecordException {
		long pk = baseDao.add(dto, userContext);
		return pk;
	}

	/**
	 * Update existing record.
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T dto, UserContext userContext) throws DuplicateRecordException {

		T oldDto = baseDao.findByPK(dto.getId(), userContext);

		if (oldDto != null) {
			dto.setCreatedBy(oldDto.getCreatedBy());
			dto.setCreatedDatetime(oldDto.getCreatedDatetime());
		}

		baseDao.update(dto, userContext);
	}

	/**
	 * Save (Add or Update).
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public long save(T dto, UserContext userContext) throws DuplicateRecordException {
		Long id = dto.getId();
		if (id != null && id > 0) {
			update(dto, userContext);
		} else {
			id = add(dto, userContext);
		}
		return id;
	}

	/**
	 * Find record by ID.
	 */
	@Transactional(readOnly = true)
	public T findById(long id, UserContext userContext) {
		T dto = baseDao.findByPK(id, userContext);
		return dto;
	}

	/**
	 * Delete record by ID.
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public T delete(long id, UserContext userContext) throws DatabaseException {
		T dto = findById(id, userContext);
		if (dto == null) {
			throw new DatabaseException("Record Not found ");
		}
		baseDao.delete(dto, userContext);
		return dto;
	}

	/**
	 * Find by unique field.
	 */
	@Transactional(readOnly = true)
	public T findByUniqueKey(String attribute, String val, UserContext userContext) {
		T dto = baseDao.findByUniqueKey(attribute, val, userContext);
		return dto;
	}

	/**
	 * Search with pagination.
	 */
	@Transactional(readOnly = true)
	public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext) {
		return baseDao.search(dto, pageNo, pageSize, userContext);
	}

	/**
	 * Search without pagination.
	 */
	@Transactional(readOnly = true)
	public List<T> search(T dto, UserContext userContext) {
		return baseDao.search(dto, userContext);
	}

}