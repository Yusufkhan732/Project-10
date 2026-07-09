package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.WeatherDAOInt;
import com.rays.dto.WeatherDTO;

@Service
public class WeatherServiceImpl extends BaseServiceImpl<WeatherDTO, WeatherDAOInt> implements WeatherServiceInt {

}
