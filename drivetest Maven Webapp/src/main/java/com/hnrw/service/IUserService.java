package com.hnrw.service;

import com.hnrw.entity.ExamUser;


public interface IUserService {
	
		/**
		 * 用户登录
		 * @param user 前台传入参数
		 * @return 用户对象
		 */
		public ExamUser login(ExamUser user);
		
		/**
		 * 用户注册
		 * @param user 前台传入参数
		 * @return 注册反馈信息
		 */
		public String registe(ExamUser user);
		
		/**
		 * 用户信息更新
		 * @param user
		 * @return 成功:ok、失败:error
		 */
		public String updateUserInfo(ExamUser user);
		
		/**
		 * 根据条件加载用户信息
		 * @param limitArgs 限制条件
		 * @param pageNo 当前页码
		 * @param limitArgs 当前页行数
		 * @return 用户信息
		 */
		public String getUserInfosByArgs(int pageNo, int pageSize,String limitArgs);
		
		/**
		 * 删除用户
		 * @param args 用户主键
		 * @return
		 */
		public String deleteUser(String delItems);
		
		/**
		 * 重置用户密码
		 * @param resItems 用户主键
		 * @return
		 */
		public String resetStuPsw(String resItems);
}
