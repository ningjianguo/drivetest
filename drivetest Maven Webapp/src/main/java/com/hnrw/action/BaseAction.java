package com.hnrw.action;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 基础action
 * @author ningjianguo
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private static final long serialVersionUID = 3747848528904059097L;
	protected T model;
	protected HttpServletRequest request;
	protected Map session;
	protected Map application;
	protected HttpServletResponse response;
	
	
	protected String page;
	protected String rows;
	
	public BaseAction() {
		this.session = ActionContext.getContext().getSession();
		this.request = ServletActionContext.getRequest();
		this.application = ActionContext.getContext().getApplication();
		response = ServletActionContext.getResponse();
		try {
			ParameterizedType type = (ParameterizedType) getClass()
					.getGenericSuperclass();
			Class classz = (Class) type.getActualTypeArguments()[0];

			this.model = (T) classz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 打印json格式输出流到前端
	 */
	public void printJsonStringToBrowser(String jsonString){
		try {
			response.setContentType("html/text;charset=UTF-8");
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public T getModel() {
		return this.model;
	}
	
	public void setPage(String page) {
		this.page = page;
	}
	
	public void setRows(String rows) {
		this.rows = rows;
	}
	
}
