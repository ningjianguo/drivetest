package com.hnrw.dao;

import com.hnrw.entity.ExamUser;

public interface IUser {
	
	/**
	 * 验证用户是否存在
	 * @param user 前台传入数据
	 * @return 用户对象
	 * */
	public ExamUser isExistUser(ExamUser user);
	/**
	 * 验证用户是否存在
	 * @param userAccountName 用户帐号
	 * @return true 存在、 false 不存在
	 */
	public boolean isExistUserByUserAccountName(String userAccountName);
	
	public void saveUser(ExamUser user);
	public void updateUser(ExamUser user);
	public void deleteUser(ExamUser user);
}