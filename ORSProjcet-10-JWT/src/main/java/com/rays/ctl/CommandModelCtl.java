package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.CommandModelDTO;
import com.rays.form.CommandModelForm;
import com.rays.service.CommandModelServiceInt;

@RestController
@RequestMapping(value = "CommandModel")
public class CommandModelCtl extends BaseCtl<CommandModelForm, CommandModelDTO, CommandModelServiceInt> {

}
