package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.StartupDAOInt;
import com.rays.dto.StartupDTO;

@Service
public class StartupServiceImpl extends BaseServiceImpl<StartupDTO, StartupDAOInt> implements StartupServiceInt {

}