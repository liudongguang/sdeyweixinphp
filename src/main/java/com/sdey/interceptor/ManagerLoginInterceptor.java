package com.sdey.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sdey.api.constant.SysConstant;

public class ManagerLoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// System.out.println(
		// "ManagerLoginInterceptor" + request.getRequestURL() + " " +
		// request.getContentLength());
		HttpSession session = request.getSession();
		Object manager = session.getAttribute(SysConstant.LOGINMANAGER);
		if (manager != null) {
			return true;
		} else {
			if (request.getHeader("x-requested-with") != null
					&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) { // 如果是ajax请求响应头会有，x-requested-with
				response.setHeader("sessionstatus", "timeout");// 在响应头设置session状态
			} else {
				response.sendRedirect(request.getContextPath() + "/houtaimanager/login.jsp");
			}
			return false;
		}
	}
}
