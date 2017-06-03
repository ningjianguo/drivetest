package com.hnrw.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnrw.entity.ExamPaper1;
import com.hnrw.service.IInfoService;
import com.hnrw.service.IPaper1Service;
/**
 * 科目一模拟考action
 * @author ningjianguo
 *
 */
@Controller
@Scope("prototype")
public class CourseOneTestAction extends BaseAction<ExamPaper1>{
	
	private static final long serialVersionUID = -1118483794890454073L;
	@Resource
	private IPaper1Service paper1ServiceImpl;
	@Resource
	private IInfoService infoServiceImpl;
	private String paperNumber;
	
	public String toDriverTest1Jsp(){
		return SUCCESS;
	}
	
	public String createOnePaper(){
		printJsonStringToBrowser(paper1ServiceImpl.createPaper1());
		return null;
	}
	
	public String chooseOneAnswer(){
		printJsonStringToBrowser(paper1ServiceImpl.chooseOneAnswer(getModel()));
		return null;
	}
	
	public String submitPaper1(){
		String paper1Number = request.getParameter("paper1Number");
		printJsonStringToBrowser(infoServiceImpl.submitPaper1(paper1Number));
		return null;
	}
	
	public String againTest(){
		printJsonStringToBrowser(paper1ServiceImpl.againOneTest(paperNumber));
		return null;
	}
	public String getPaperNumber() {
		return paperNumber;
	}

	public void setPaperNumber(String paperNumber) {
		this.paperNumber = paperNumber;
	}
	
}
