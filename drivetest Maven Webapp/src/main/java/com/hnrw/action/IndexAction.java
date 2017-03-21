package com.hnrw.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class IndexAction extends ActionSupport{
	
	private static final long serialVersionUID = 4119097920883093377L;

	public String index(){
		return SUCCESS;
	}
}
