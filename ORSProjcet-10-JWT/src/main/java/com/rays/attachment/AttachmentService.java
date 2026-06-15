package com.rays.attachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.UserContext;

/**
 * Service class for Attachment operations. Handles business logic for add,
 * update, delete and find.
 * 
 * @author Yusuf Khan
 */
@Service
@Transactional
public class AttachmentService {

	@Autowired
	public AttachmentDAO dao;

	/**
	 * Adds a new attachment.
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(AttachmentDTO dto, UserContext userContext) {
		return dao.add(dto, userContext);
	}

	/**
	 * Updates an existing attachment.
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(AttachmentDTO dto, UserContext userContext) {
		dao.update(dto, userContext);
	}

	/**
	 * Deletes attachment by ID.
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		try {
			AttachmentDTO dto = findById(id);
			dao.delete(dto);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Finds attachment by primary key.
	 */
	@Transactional(readOnly = true)
	public AttachmentDTO findById(long pk) {
		return dao.findByPk(pk);
	}

	/**
	 * Saves attachment (add or update).
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public long save(AttachmentDTO dto, UserContext userContext) {
		Long id = dto.getId();
		if (id != null && id > 0) {
			update(dto, userContext);
		} else {
			id = add(dto, userContext);
		}
		return id;
	}
}