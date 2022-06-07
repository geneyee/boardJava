package com.blog.project.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.project.beans.UserBean;

@Controller
public class HomeController {
	
	/*
	 * @Resource(name="loginUserBean") private UserBean loginBean;
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		//System.out.println(loginBean);
		
		//주소만 치고 들어왔을 때의 실행되는 파일의 위치 - 실제 컴퓨터 상의 물리적인 경로 
		//System.out.println(request.getServletContext().getRealPath("/"));
		
		return "redirect:/main";
	}

}