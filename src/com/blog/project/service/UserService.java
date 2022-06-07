package com.blog.project.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.project.beans.UserBean;
import com.blog.project.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	//RootAppContext에서 주입받은 빈(로그인 여부 확인용)
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	//아이디 중복확인
	public boolean checkUserIdExist(String user_id) {
		
		String user_name = userDao.checkUserIdExist(user_id);
		
		if(user_name==null) {
			return true;
		}else {
			return false;
		}
	}
	
	//회원가입 정보 저장
	public void addUseInfo(UserBean joinUserBean) {
		userDao.addUserInfo(joinUserBean);	
	}
	
	//로그인 성공
	public void getLoginUserInfo(UserBean tempLoginUserBean) {

		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);
	
		if(tempLoginUserBean2 != null) {//가져온 데이터가 있다면
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
			loginUserBean.setUserLogin(true);//로그인 여부 확인
		}
	}
	
	//정보수정
	public void getmodifyUserInfo(UserBean modifyUserBean) {//controller에서 주입받은 거
		UserBean tempModifyUserBean = userDao.getmodifyUserInfo(loginUserBean.getUser_idx());
		
		modifyUserBean.setUser_id(tempModifyUserBean.getUser_id());
		modifyUserBean.setUser_name(tempModifyUserBean.getUser_name());
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
	}
	
	public void modifyUserInfo(UserBean modifyUserBean) {
		
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
		
		userDao.modifyUserInfo(modifyUserBean);
		
	}

}
