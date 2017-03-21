package com.hnrw.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.hnrw.entity.ExaminationUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ac = invocation.getInvocationContext();
		Map session = (Map) ac.get(ServletActionContext.SESSION);
		if (session.isEmpty()) {
			ac.put("loginerr", 0);
			return "login";
		} else {
			ExaminationUser user = (ExaminationUser) session.get("user");
			if (user == null) {
				ac.put("loginerr", 0);
				return "login";
			} else {
				return invocation.invoke();
			}
		}
	}
}
