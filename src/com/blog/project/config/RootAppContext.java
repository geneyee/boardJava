package com.blog.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.blog.project.beans.UserBean;

//프로젝트 작업시 사용할 bean을 정의하는 클래스(데이터 저장 및 관리)
@Configuration
public class RootAppContext {
	
	//로그인 여부 확인용
	@Bean("loginUserBean")
	@SessionScope
	public UserBean loginUserBean() {
		return new UserBean();
	}
	

}
