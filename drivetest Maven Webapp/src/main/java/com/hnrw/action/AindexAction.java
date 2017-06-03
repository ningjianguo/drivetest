package com.hnrw.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnrw.entity.ExamQuestion1;
import com.hnrw.service.IQuestion1Service;

@Controller
@Scope("prototype")
public class AindexAction extends BaseAction<ExamQuestion1>{

	private static final long serialVersionUID = 2741894337161616239L;
	private String page;
	private String rows;
	@Resource
	private IQuestion1Service question1ServiceImpl;
	
	public String index(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("loginerr", 1);
		return SUCCESS;
	}
	
	public String toManageUser(){
		return SUCCESS;
	}
	
	public String toManageQuestion1(){
		return SUCCESS;
	}
	
	public String toManageQuestion4(){
		return SUCCESS;
	}
	
	/*public String loadAllQuestion1(){
		String type = request.getParameter("type");
		if("1".equals(type)){
			printJsonStringToBrowser(question1ServiceImpl.loadAllData(Integer.parseInt(page), Integer.parseInt(rows)));
		}else{
			
		}
		return null;
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
	}*/
	
}
