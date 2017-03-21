package com.hnrw.dao;

import com.hnrw.entity.ExaminationUser;

public interface IUser {
	
	/**
	 * 验证用户是否存在
	 * @param user 前台传入数据
	 * @return 用户对象
	 * */
	public ExaminationUser isExistUser(ExaminationUser user);
}