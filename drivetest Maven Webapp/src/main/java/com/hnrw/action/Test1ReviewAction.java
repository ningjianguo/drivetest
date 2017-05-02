package com.hnrw.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnrw.entity.ExamQuestion1;
import com.hnrw.service.IInfoService;
import com.hnrw.service.IPaper1Service;
/**
 * 科目一复习action
 * @author Techape
 *
 */
@Controller
@Scope("prototype")
public class Test1ReviewAction extends BaseAction<ExamQuestion1>{

	private static final long serialVersionUID = -8434492100037005150L;
	@Resource
	private IPaper1Service paper1ServiceImpl;
	@Resource
	private IInfoService infoServiceImpl;
	
	public String toTest1ReviewJsp(){
		return SUCCESS;
	}
	
	public String createOnePaper(){
		printJsonStringToBrowser(paper1ServiceImpl.nextReviewQuestion1(1));
		return null;
	}
	
	public String chooseOneAnswer(){
		printJsonStringToBrowser(paper1ServiceImpl.nextReviewQuestion1(getModel().getQuestion1Id()));
		return null;
	}
	
	public String submitPaper1(){
		String paper1Number = request.getParameter("paper1Number");
		printJsonStringToBrowser(infoServiceImpl.submitPaper1(paper1Number));
		return null;
	}
}
