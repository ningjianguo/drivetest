package com.hnrw.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnrw.entity.ExamPaper4;
import com.hnrw.service.IInfoService;
import com.hnrw.service.IPaper4Service;

@Controller
@Scope("prototype")
public class CourseOneTestAction extends BaseAction<ExamPaper4>{
	
	private static final long serialVersionUID = -1118483794890454073L;
	@Resource
	private IPaper4Service paper4ServiceImpl;
	@Resource
	private IInfoService infoServiceImpl;
	
	public String toDriverTest4Jsp(){
		return SUCCESS;
	}
	
	public String createOnePaper(){
		printJsonStringToBrowser(paper4ServiceImpl.createPaper4());
		return null;
	}
	
	public String chooseOneAnswer(){
		printJsonStringToBrowser(paper4ServiceImpl.chooseOneAnswer(getModel()));
		return null;
	}
	
	public String submitPaper4(){
		String paper4Number = request.getParameter("paper1Number");
		printJsonStringToBrowser(infoServiceImpl.submitPaper4(paper4Number));
		return null;
	}
}
