package com.hnrw.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnrw.entity.ExamInfo;
import com.hnrw.service.IGradeService;
import com.hnrw.service.IPaper1Service;

@Controller
@Scope("prototype")
public class GradeAction extends BaseAction<ExamInfo>{
	
	private static final long serialVersionUID = -603175340902119341L;
	private String page;
	private String rows;
	@Resource
	private IGradeService gradeServiceImpl;
	@Resource
	private IPaper1Service paper1ServiceImpl;	
	private String paperNumber;
	public String toMygradeJsp(){
		return SUCCESS;
	}
	
	public String loadDataToGrid(){
		String papertype = request.getParameter("papertype");
		String statu = request.getParameter("statu");
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		StringBuffer sbf = new StringBuffer();
		sbf.append("1=1");
		if(!"-1".equals(papertype)){
			sbf.append(" and infoType="+papertype+"");
		}
		if(!"-1".equals(statu)){
			if("0".equals(statu)){
				sbf.append(" and infoEndTime is null");
			}else{
				sbf.append(" and infoEndTime is not null");
			}
		}
		if(!"".equals(time1)&&!"".equals(time2)){
			sbf.append(" and date_format('"+time1+"','%Y-%m-%d')<=date_format(infoEndTime,'%Y-%m-%d') and date_format(infoEndTime,'%Y-%m-%d')<=date_format('"+time2+"','%Y-%m-%d')");
		}
		printJsonStringToBrowser(gradeServiceImpl.loadGradeByArgs(Integer.parseInt(page), Integer.parseInt(rows),sbf.toString()));
		return null;
	}
	
	public String deleteGrade(){
		String delItems = request.getParameter("delItems");
		printJsonStringToBrowser(gradeServiceImpl.deleteGrade(delItems));
		return null;
	}
	
	public String againTest(){
		this.paperNumber = request.getParameter("paper1Number");
		return SUCCESS;
	}

	public void setPaperNumber(String paperNumber) {
		this.paperNumber = paperNumber;
	}

	public String getPaperNumber() {
		return paperNumber;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	public void setRows(String rows) {
		this.rows = rows;
	}

}
