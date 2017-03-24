package com.hnrw.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnrw.entity.ExamInfo;
import com.hnrw.service.IPaper1Service;

@Controller
@Scope("prototype")
public class CourseOneTestAction extends BaseAction<ExamInfo>{
	
	private static final long serialVersionUID = -1118483794890454073L;
	@Resource
	private IPaper1Service paper1ServiceImpl;
	
	public String toDriverTest1Jsp(){
		return SUCCESS;
	}
	
	public String createOnePaper(){
		printJsonStringToBrowser(paper1ServiceImpl.createPaper1());
		return null;
	}
}
