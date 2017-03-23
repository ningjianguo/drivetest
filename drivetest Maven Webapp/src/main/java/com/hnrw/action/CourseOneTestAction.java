package com.hnrw.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnrw.service.IPaper1Service;

@Controller
@Scope("prototype")
public class CourseOneTestAction {
	
	@Resource
	private IPaper1Service paper1ServiceImpl;
	
	public String createOnePaper(){
		paper1ServiceImpl.createPaper1();
		return "createPaper";
	}
}
