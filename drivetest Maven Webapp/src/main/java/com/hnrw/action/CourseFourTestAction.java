package com.hnrw.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnrw.entity.ExamPaper4;
import com.hnrw.service.IInfoService;
import com.hnrw.service.IPaper4Service;
/**
 * 科目四模拟考action
 * @author ningjianguo
 *
 */
@Controller
@Scope("prototype")
public class CourseFourTestAction extends BaseAction<ExamPaper4>{
	
	private static final long serialVersionUID = -2586205347378307451L;
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
		String paper4Number = request.getParameter("paper4Number");
		printJsonStringToBrowser(infoServiceImpl.submitPaper4(paper4Number));
		return null;
	}
}
