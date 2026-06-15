package com.rays.attachment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;

/**
 * Data Access Object (DAO) implementation for Attachment entity.
 * 
 * <p>
 * This class handles database operations related to AttachmentDTO such as
 * create, update, delete, and find. It extends BaseDAOImpl to inherit common
 * DAO behavior.
 * </p>
 *
 * @author Yusuf Khan
 * @version 1.0
 */
@Repository
public class AttachmentDAO extends BaseDAOImpl<AttachmentDTO> {

	/**
	 * EntityManager used for performing persistence operations.
	 */
	@PersistenceContext
	public EntityManager entityManager;

	/**
	 * Persists a new Attachment record in the database.
	 *
	 * @param dto AttachmentDTO object to be saved
	 * @return generated primary key (ID)
	 */
	public long add(AttachmentDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	/**
	 * Updates an existing Attachment record.
	 *
	 * @param dto AttachmentDTO object to be updated
	 */
	public void update(AttachmentDTO dto) {
		entityManager.merge(dto);
	}

	/**
	 * Deletes an Attachment record from the database.
	 *
	 * @param dto AttachmentDTO object to be deleted
	 */
	public void delete(AttachmentDTO dto) {
		entityManager.remove(dto);
	}

	/**
	 * Finds an Attachment record by primary key.
	 *
	 * @param pk primary key
	 * @return AttachmentDTO object if found, otherwise null
	 */
	public AttachmentDTO findByPk(long pk) {
		return entityManager.find(AttachmentDTO.class, pk);
	}

	/**
	 * Returns the DTO class type.
	 *
	 * @return AttachmentDTO class reference
	 */
	@Override
	public Class<AttachmentDTO> getDTOClass() {
		return AttachmentDTO.class;
	}

	/**
	 * Builds dynamic where clause for search operation.
	 *
	 * @param dto     search criteria DTO
	 * @param builder CriteriaBuilder instance
	 * @param qRoot   query root
	 * @return list of predicates (currently not implemented)
	 */
	@Override
	protected List<Predicate> getWhereClause(AttachmentDTO dto, CriteriaBuilder builder, Root<AttachmentDTO> qRoot) {
		return null;
	}
}