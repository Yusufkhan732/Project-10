package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.PriorityDTO;
import com.rays.form.PriorityForm;
import com.rays.service.PriorityServiceInt;

@RestController
@RequestMapping(value = "Priority")
public class PriorityCtl extends BaseCtl<PriorityForm, PriorityDTO, PriorityServiceInt> {

}
