package com.hnrw.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnrw.entity.ExamUser;
import com.hnrw.service.IUserService;
import com.hnrw.util.JDUuid;
/**
 * 用户action
 * @author ningjianguo
 *
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<ExamUser> {
	private static final long serialVersionUID = -7484732053197251028L;
	
	private File file;
	private String fileFileName;
	@Resource
	private IUserService userServiceImpl;
	private String page;
	private String rows;
	/**
	 * 用户登录
	 */
	@SuppressWarnings("unchecked")
	public String userLogin(){
		ExamUser user = userServiceImpl.login(getModel());
		if(user != null){
			//登录成功则把user对象放到session中保存
			session.put("user",user);
			if(user.getUserRole() == 1){
				printJsonStringToBrowser("admin");
			}else{
				printJsonStringToBrowser("success");
			}
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
	
	/**
	 * 更新用户信息
	 */
	public String updateUserInfo(){
		ExamUser user = getModel();
		String descFileName = null;
		if(file != null){
			String fileType = fileFileName.substring((fileFileName.lastIndexOf(".")));
			descFileName = JDUuid.createID("ESDFRTGY")+fileType;
			user.setUserFilepath(descFileName);
		}
		String info = userServiceImpl.updateUserInfo(user);
		if(info.equals("ok") && file != null){
			//保存照片到物理路径
			try {
				FileInputStream inputStream = new FileInputStream(
						this.getFile());
				FileOutputStream outputStream = new FileOutputStream("C://images//"+ descFileName);
				byte[] buf = new byte[1024];
				int length = 0;
				while ((length = inputStream.read(buf)) != -1) {
					outputStream.write(buf, 0, length);
				}
				inputStream.close();
				outputStream.flush();
				outputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(info);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 加载所有用户信息
	 * @return
	 */
	public String loadAllStuInfos(){
		String userAccountName = request.getParameter("userAccountName");
		String userName = request.getParameter("userName");
		StringBuffer sbf = new StringBuffer();
		sbf.append("userRole=0");
		if(!"".equals(userAccountName)){
			sbf.append(" and userAccountName like '%"+userAccountName+"%'");
		}
		if(!"".equals(userName)){
			sbf.append(" and userName like '%"+userName+"%'");
		}
		printJsonStringToBrowser(userServiceImpl.getUserInfosByArgs(Integer.parseInt(page), Integer.parseInt(rows),sbf.toString()));
		return null;
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	public String delUsers(){
		String delItems = request.getParameter("delItems");
		printJsonStringToBrowser(userServiceImpl.deleteUser(delItems));
		return null;
	}
	
	/**
	 * 重置考生密码
	 * @return
	 */
	public String resetStuPsw(){
		String resItems = request.getParameter("resItems");
		printJsonStringToBrowser(userServiceImpl.resetStuPsw(resItems));
		return null;
	}
	
	/**
	 * 前往用户个人设置界面
	 * @return
	 */
	public String toPersonSettingJsp(){
		return SUCCESS;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}
}
