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
}
