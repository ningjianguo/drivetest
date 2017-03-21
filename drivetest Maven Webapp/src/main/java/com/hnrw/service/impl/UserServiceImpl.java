package com.hnrw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hnrw.dao.IUser;
import com.hnrw.entity.ExaminationUser;
import com.hnrw.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUser userDaoImpl;
	
	@Override
	public ExaminationUser login(ExaminationUser user) {
		 return userDaoImpl.isExistUser(user);
	}

}
