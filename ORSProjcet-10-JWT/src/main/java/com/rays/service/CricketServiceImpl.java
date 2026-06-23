package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CricketDAOInt;
import com.rays.dto.CricketDTO;

@Service
public class CricketServiceImpl extends BaseServiceImpl<CricketDTO, CricketDAOInt> implements CricketServiceInt {

}