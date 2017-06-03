package com.hnrw.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.hnrw.dao.IUser;
import com.hnrw.entity.ExamUser;
import com.hnrw.service.IUserService;
import com.hnrw.util.JDUuid;
import com.hnrw.util.MD5Util;
import com.opensymphony.xwork2.ActionContext;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUser userDaoImpl;
	
	@Override
	public ExamUser login(ExamUser user) {
		 //md5解密
		 user.setUserAccountPassword(MD5Util.getInstance().calcMD5(user.getUserAccountPassword()));
		 return userDaoImpl.isExistUser(user);
	}

	@Override
	public String registe(ExamUser user) {
		String userName = user.getUserName();
		String userAccountName = user.getUserAccountName();
		try {
			//判断用户是否已被注册
			if(!userDaoImpl.isExistUserByUserAccountName(userAccountName)){
				if("".equals(userName) || userName == null){
					user.setUserName(userAccountName);
				}
				//用户密码使用md5加密
				user.setUserAccountPassword(MD5Util.getInstance().calcMD5(user.getUserAccountPassword()));
				//用户注册默认为普通权限，区别于管理员权限
				user.setUserRole(0);
				user.setUserId(JDUuid.createID("qwewqert"));
				user.setUserFilepath("user.png");
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

	@Override
	public String updateUserInfo(ExamUser examUser) {
		Map map = ActionContext.getContext().getSession();
		ExamUser user = (ExamUser) map.get("user");
		examUser.setUserId(user.getUserId());
		examUser.setUserRole(0);
		if(!examUser.getUserAccountPassword().equals(user.getUserAccountPassword())){
			examUser.setUserAccountPassword(MD5Util.getInstance().calcMD5(examUser.getUserAccountPassword()));
		}
		if(examUser.getUserFilepath() == null){
			examUser.setUserFilepath(user.getUserFilepath());
		}
		try {
			userDaoImpl.updateUser(examUser);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@Override
	public String getUserInfosByArgs(int pageNo, int pageSize, String limitArgs) {
		List<ExamUser> users = userDaoImpl.getUsersByArgs(pageNo, pageSize, limitArgs);
		Map<String, Object> maps = null;
		JSONObject jobj = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (ExamUser user : users) {
			maps = new HashMap<String, Object>();
			maps.put("userId", user.getUserId());
			maps.put("userAccountName", user.getUserAccountName());
			maps.put("userAccountPassword", user.getUserAccountPassword());
			maps.put("userName", user.getUserName());
			maps.put("userEmail", user.getUserEmail());
			maps.put("userFilePath", user.getUserFilepath());
			list.add(maps);
		}
		jobj = new JSONObject();
        jobj.accumulate("total",userDaoImpl.getUserCountByArgs("".equals(limitArgs) ? null:limitArgs));//total代表一共有多少数据  
        jobj.accumulate("rows", list);//row是代表显示的页的数据  
		return jobj.toString();
	}

	@Override
	public String deleteUser(String delItems) {
		String[] dels = delItems.split(";");
		ExamUser user = null;
		for (String del : dels) {
			user = new ExamUser();
			user.setUserId(del);
			try {
				userDaoImpl.deleteUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "ok";
	}

	@Override
	public String resetStuPsw(String resItems) {
		String[] res = resItems.split(";");
		ExamUser user = null;
		for (String re : res) {
			user = new ExamUser();
			user.setUserId(re);
			user.setUserAccountPassword(MD5Util.getInstance().calcMD5("000000"));
			try {
				userDaoImpl.updateUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "ok";
	}
}
