package com.hnrw.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class CourseOneTestAction {
	
	public String createOnePaper(){
		
		return "createPaper";
	}
}
