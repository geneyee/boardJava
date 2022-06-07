package com.blog.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.blog.project.beans.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{
	
	//java의 경우 interceptor에서는 bean 주입 안됨
	//그래서 생성자로 받음
	private UserBean loginUserBean;
	
	public CheckLoginInterceptor(UserBean loginUserBean) {
		
		this.loginUserBean = loginUserBean;
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		if(loginUserBean.isUserLogin() == false) {//로그인 x
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/user/not_login");//웹브라우저에 해당 주소 요청
			return false;//다음단계로 더이상 이동하지 않고 여기서 처리 종료
		}
		return true;//로그인 했다면 true - 다음단계 즉, controller로 이동
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
