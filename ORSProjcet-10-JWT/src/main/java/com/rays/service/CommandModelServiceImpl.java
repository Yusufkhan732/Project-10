package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CommandModelDAOInt;
import com.rays.dto.CommandModelDTO;

@Service
public class CommandModelServiceImpl extends BaseServiceImpl<CommandModelDTO, CommandModelDAOInt>
		implements CommandModelServiceInt {

}
