package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.CustomerDTO;
import com.rays.form.CustomerForm;
import com.rays.service.CustomerServiceInt;

@RestController
@RequestMapping(value = "Customer")
public class CustomerCtl extends BaseCtl<CustomerForm, CustomerDTO, CustomerServiceInt> {

}
