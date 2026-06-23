package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.StartupDTO;
import com.rays.form.StartupForm;
import com.rays.service.StartupServiceInt;

@RestController
@RequestMapping(value = "Startup")
public class StartupCtl extends BaseCtl<StartupForm, StartupDTO, StartupServiceInt> {

}
