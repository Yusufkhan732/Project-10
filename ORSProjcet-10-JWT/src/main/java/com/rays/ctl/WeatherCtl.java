package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.WeatherDTO;
import com.rays.form.WeatherForm;
import com.rays.service.WeatherServiceInt;

@RestController
@RequestMapping(value = "Weather")
public class WeatherCtl extends BaseCtl<WeatherForm, WeatherDTO, WeatherServiceInt> {

} 
