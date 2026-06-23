package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.CricketDTO;
import com.rays.form.CricketForm;
import com.rays.service.CricketServiceInt;

@RestController
@RequestMapping(value = "Cricket")
public class CricketCtl extends BaseCtl<CricketForm, CricketDTO, CricketServiceInt> {

}
