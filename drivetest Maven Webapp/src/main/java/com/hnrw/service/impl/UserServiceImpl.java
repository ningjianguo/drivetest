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

	@Override
	public String registe(ExaminationUser user) {
		String userName = user.getUserName();
		String userAccountName = user.getUserAccountName();
		try {
			if(!userDaoImpl.isExistUserByUserAccountName(userAccountName)){
				if("".equals(userName) || userName == null){
					user.setUserName(userAccountName);
				}
				//用户注册默认为普通权限，区别于管理员权限
				user.setUserRole("0");
				userDaoImpl.saveUser(user);
				return "注册成功!";
			}else{
				return "该用户名已被占用!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "系统内部错误,注册失败!";
		}
	}
	
}
