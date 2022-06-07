package com.blog.project.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.blog.project.beans.UserBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UserBean userBean = (UserBean)target;
		
		//유효성 검사를 하는 bean 이름 확인
		String beanName = errors.getObjectName();
		
		//회원가입 or 정보수정 할 떄 유효성 검사
		if(beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {
			if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
				errors.rejectValue("user_pw", "NotEquals");
				errors.rejectValue("user_pw2", "NotEquals");
			}
		}
		
		//회원가입 할 때만 유효성 검사 할 수 있도록
		if(beanName.equals("joinUserBean"))	{
			
			if(userBean.isUserIdExist() == false) {
				errors.rejectValue("user_id", "DontCheckUserIdExist");
			}
		}
	}

}
