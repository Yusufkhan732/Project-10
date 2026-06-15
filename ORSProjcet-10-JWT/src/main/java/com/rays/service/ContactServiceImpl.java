package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ContactDAOInt;
import com.rays.dto.ContactDTO;

@Service
public class ContactServiceImpl extends BaseServiceImpl<ContactDTO, ContactDAOInt> implements ContactServiceInt {

}
