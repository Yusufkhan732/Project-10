package com.rays.common;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * Base DTO class for all entities.
 * Contains common fields like id and audit info.
 * @author Yusuf Khan
 */
@MappedSuperclass
public abstract class BaseDTO implements DropdownList {

	@Id
	@GeneratedValue(generator = "ncsPk")
	@GenericGenerator(name = "ncsPk", strategy = "native")
	@Column(name = "id", unique = true, nullable = false)
	protected Long id;

	@Column(name = "created_by", length = 50)
	protected String createdBy = "root";

	@Column(name = "modified_by", length = 50)
	protected String modifiedBy = "root";

	@Column(name = "created_datetime")
	protected Timestamp createdDatetime;

	@Column(name = "modified_datetime")
	protected Timestamp modifiedDatetime;

	/**
	 * Return unique field name.
	 */
	public abstract String getUniqueKey();

	/**
	 * Return unique field value.
	 */
	public abstract String getUniqueValue();

	/**
	 * Return display label.
	 */
	public abstract String getLabel();

	/**
	 * Return table name.
	 */
	public abstract String getTableName();

	/**
	 * Get ID.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set ID.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get createdBy.
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Set createdBy.
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Get modifiedBy.
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Set modifiedBy.
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * Get created datetime.
	 */
	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	/**
	 * Set created datetime.
	 */
	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	/**
	 * Get modified datetime.
	 */
	public Timestamp getModifiedDatetime() {
		return modifiedDatetime;
	}

	/**
	 * Set modified datetime.
	 */
	public void setModifiedDatetime(Timestamp modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	/**
	 * Return key for dropdown.
	 */
	@Override
	public String getKey() {
		return id + "";
	}

	/**
	 * Return value for dropdown.
	 */
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}