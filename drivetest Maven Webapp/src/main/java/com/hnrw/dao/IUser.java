package com.hnrw.dao;

import java.util.List;

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
	
	/**
	 * 根据条件获得用户信息
	 * @param limitArgs 限制条件
	 * @param pageNo 当前页码
	 * @param pageSize 当前页行数
	 * @return
	 */
	public List<ExamUser> getUsersByArgs(int pageNo, int pageSize,String limitArgs);
	
	/**
	 * 根据条件获得用户数量
	 * @param limitArgs 限制条件
	 * @return 用户数量
	 */
	public int getUserCountByArgs(String limitArgs);
}