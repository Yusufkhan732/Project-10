package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_hotel")
public class HotelDTO extends BaseDTO {

	@Column(name = "room_no")
	private String roomNo;

	@Column(name = "room_type")
	private String roomType;

	@Column(name = "price")
	private String price;

	@Column(name = "status")
	private String status;

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getUniqueKey() {
		return "roomNo";
	}

	@Override
	public String getUniqueValue() {
		return roomNo;
	}

	@Override
	public String getLabel() {
		return "Room No";
	}

	@Override
	public String getTableName() {
		return "hotel";
	}
}