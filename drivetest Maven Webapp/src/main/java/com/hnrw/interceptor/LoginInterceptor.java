package com.hnrw.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 取得Session。
		ActionContext ac = invocation.getInvocationContext();
		Map session = (Map) ac.get(ServletActionContext.SESSION);
		if (session.isEmpty()) {
			ac.put("loginerr", 0);
			return "login";
		} else {
			User user = (User) session.get("user");
			if (user == null) {
				ac.put("loginerr", 0);
				return "login";
			} else {
				return invocation.invoke();
			}
		}
	}
}
