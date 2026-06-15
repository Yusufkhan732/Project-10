package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.ContactDTO;
import com.rays.form.ContactForm;
import com.rays.service.ContactServiceInt;

@RestController
@RequestMapping(value = "Contact")
public class ContactCtl extends BaseCtl<ContactForm, ContactDTO, ContactServiceInt> {

}
