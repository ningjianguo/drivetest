package com.hnrw.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnrw.entity.ExamQuestion1;
import com.hnrw.service.ICollectionService;
import com.hnrw.service.IQuestion1Service;
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
	private IQuestion1Service question1ServiceImpl;
	@Resource
	private ICollectionService collectionServiceImpl;
	
	public String toTest1ReviewJsp(){
		return SUCCESS;
	}
	
	public String createOnePaper(){
		printJsonStringToBrowser(question1ServiceImpl.createReviewPaper1());
		return null;
	}
	
	public String chooseOneAnswer(){
		printJsonStringToBrowser(question1ServiceImpl.nextReviewQuestion1(getModel().getQuestion1No()));
		return null;
	}
	
	public String collectOrNotCollectQuestion1(){
		String question1Id = request.getParameter("question1Id");
		printJsonStringToBrowser(collectionServiceImpl.collectOrNotCollect(question1Id));
		return null;
	}
}
