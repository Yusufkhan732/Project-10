package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.HotelDTO;

public class HotelForm extends BaseForm {

	@NotEmpty(message = "Room No is required")
	private String roomNo;

	@NotEmpty(message = "Room Type is required")
	private String roomType;

	@NotEmpty(message = "Price is required")
	private String price;

	@NotEmpty(message = "Status is required")
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
	public BaseDTO getDto() {

		HotelDTO dto = initDTO(new HotelDTO());

		dto.setRoomNo(roomNo);
		dto.setRoomType(roomType);
		dto.setPrice(price);
		dto.setStatus(status);

		return dto;
	}
}