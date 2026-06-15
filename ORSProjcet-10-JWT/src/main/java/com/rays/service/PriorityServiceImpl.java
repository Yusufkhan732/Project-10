package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.PriorityDAOInt;
import com.rays.dto.PriorityDTO;

@Service
public class PriorityServiceImpl extends BaseServiceImpl<PriorityDTO, PriorityDAOInt> implements PriorityServiceInt {

}
