package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_weather")
public class WeatherDTO extends BaseDTO {

	@Column(name = "alertCode")
	private String alertCode;

	@Column(name = "cityName")
	private String cityName;

	@Column(name = "temperature")
	private Integer temperature;

	@Column(name = "status")
	private String status;

	public String getAlertCode() {
		return alertCode;
	}

	public void setAlertCode(String alertCode) {
		this.alertCode = alertCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getTemperature() {
		return temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getUniqueKey() {
		return "alertCode";
	}

	@Override
	public String getUniqueValue() {
		return alertCode;
	}

	@Override
	public String getLabel() {
		return cityName;
	}

	@Override
	public String getTableName() {
		return "weather";
	}
}