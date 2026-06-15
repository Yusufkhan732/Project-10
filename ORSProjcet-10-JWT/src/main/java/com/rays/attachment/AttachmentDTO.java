package com.rays.attachment;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseDTO;

/**
 * Attachment Data Transfer Object (DTO).
 * 
 * <p>
 * This entity represents file attachments stored in the system. It stores file
 * metadata such as name, type, description, associated user ID, and binary file
 * content.
 * </p>
 * 
 * <p>
 * The file content is stored as a BLOB in the database.
 * </p>
 *
 * @author Yusuf Khan
 * @version 1.0
 */
@Entity
@Table(name = "ST_ATTACHMENT")
public class AttachmentDTO extends BaseDTO {

	/**
	 * Name of the file.
	 */
	@Column(name = "NAME", length = 100)
	protected String name;

	/**
	 * MIME type of the file (e.g., image/jpeg, application/pdf).
	 */
	@Column(name = "TYPE", length = 100)
	protected String type;

	/**
	 * Description of the attachment.
	 */
	@Column(name = "DESCRIPTION", length = 500)
	protected String description;

	/**
	 * ID of the user associated with this attachment.
	 */
	@Column(name = "USER_ID")
	protected Long userId;

	/**
	 * Binary content of the file stored as Large Object (BLOB).
	 */
	@Lob
	@Column(name = "DOC")
	private byte[] doc;

	/**
	 * Default constructor.
	 */
	public AttachmentDTO() {
	}

	/**
	 * Constructs AttachmentDTO from MultipartFile.
	 *
	 * @param file uploaded file
	 */
	public AttachmentDTO(MultipartFile file) {
		this.name = file.getOriginalFilename();
		this.type = file.getContentType();

		try {
			this.doc = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return file name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name file name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return file MIME type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type MIME type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return attachment description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return associated user ID
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId user ID to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return binary file data
	 */
	public byte[] getDoc() {
		return doc;
	}

	/**
	 * @param doc binary file data to set
	 */
	public void setDoc(byte[] doc) {
		this.doc = doc;
	}

	/**
	 * Returns unique key for dropdown usage.
	 *
	 * @return unique key (not implemented)
	 */
	@Override
	public String getUniqueKey() {
		return null;
	}

	/**
	 * Returns unique value for dropdown usage.
	 *
	 * @return unique value (not implemented)
	 */
	@Override
	public String getUniqueValue() {
		return null;
	}

	/**
	 * Returns label for dropdown usage.
	 *
	 * @return label (not implemented)
	 */
	@Override
	public String getLabel() {
		return null;
	}

	/**
	 * Returns table name.
	 *
	 * @return table name (not implemented)
	 */
	@Override
	public String getTableName() {
		return null;
	}
}