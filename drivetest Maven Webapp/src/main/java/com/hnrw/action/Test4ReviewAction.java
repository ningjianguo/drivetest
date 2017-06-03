package com.hnrw.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnrw.entity.ExamQuestion4;
import com.hnrw.service.ICollectionService;
import com.hnrw.service.IQuestion4Service;
/**
 * 科目四复习action
 * @author Techape
 *
 */
@Controller
@Scope("prototype")
public class Test4ReviewAction extends BaseAction<ExamQuestion4>{

	private static final long serialVersionUID = -8434492100037005150L;
	@Resource
	private IQuestion4Service question4ServiceImpl;
	@Resource
	private ICollectionService collectionServiceImpl;
	
	public String toTest4ReviewJsp(){
		return SUCCESS;
	}
	
	public String createOnePaper(){
		printJsonStringToBrowser(question4ServiceImpl.createReviewPaper4());
		return null;
	}
	
	public String chooseOneAnswer(){
		printJsonStringToBrowser(question4ServiceImpl.nextReviewQuestion4(getModel().getQuestion4No()));
		return null;
	}
	
	public String collectOrNotCollectQuestion4(){
		String question4Id = request.getParameter("question4Id");
		printJsonStringToBrowser(collectionServiceImpl.collectOrNotCollect(question4Id));
		return null;
	}
}
