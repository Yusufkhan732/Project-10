package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CustomerDAOInt;
import com.rays.dto.CustomerDTO;

@Service
public class CustomerServiceimpl extends BaseServiceImpl<CustomerDTO, CustomerDAOInt> implements CustomerServiceInt {

}
