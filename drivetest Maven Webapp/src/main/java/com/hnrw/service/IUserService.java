package com.hnrw.service;

import com.hnrw.entity.ExaminationUser;


public interface IUserService {
	
		/**
		 * 用户登录
		 * @param user 前台传入参数
		 * @return 用户对象
		 */
		public ExaminationUser login(ExaminationUser user);
}
