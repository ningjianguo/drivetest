package com.hnrw.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnrw.entity.ExaminationUser;
import com.hnrw.service.IUserService;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<ExaminationUser> {
	private static final long serialVersionUID = -7484732053197251028L;
	
	@Resource
	private IUserService userServiceImpl;
	
	/**
	 * 用户登录
	 */
	@SuppressWarnings("unchecked")
	public String userLogin(){
		ExaminationUser user = userServiceImpl.login(getModel());
		if(user != null){
			//登录成功则把user对象放到session中保存
			session.put("user",user);
			printJsonStringToBrowser("success");
		}else{
			printJsonStringToBrowser("fail");
		}
		return null;
	}
	
	/**
	 * 用户登出
	 */
	public String userOutLogin(){
		if(!session.isEmpty()){
			session.clear();
		}
		return "loginOut";
	}
	
	/**
	 * 用户注册
	 */
	public String userRegiste(){
		printJsonStringToBrowser(userServiceImpl.registe(getModel()));
		return null;
	}
}
