package com.blog.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.blog.project.beans.UserBean;

public interface UserMapper {
	
	//회원가입 아이디 중복확인
	@Select("select user_name "+
			"from user_table "+
			"where user_id = #{user_id}")
	String checkUserIdExist(String user_id);
	
	//회원가입 정보 저장
	@Insert("insert into user_table (user_idx, user_name, user_id, user_pw) "+
			"values (user_seq.nextval, #{user_name}, #{user_id}, #{user_pw})")
	void addUserInfo(UserBean joinUserBean);
	
	//로그인
	@Select("select user_idx, user_name "+
			"from user_table "+
			"where user_id=#{user_id} and user_pw=#{user_pw}")
	UserBean getLoginUserInfo(UserBean tempLoginUserBean);
	
	//정보수정
	@Select("select user_id, user_name "+
			"from user_table "+
			"where user_idx=#{user_idx}")
	UserBean getmodifyUserInfo(int user_idx);//현재 로그인 한 사용자 인덱스 번호
	
	@Update("update user_table "+
			"set user_pw = #{user_pw} "+
			"where user_idx = #{user_idx}")
	void modifyUserInfo(UserBean modifyUserBean);
	

}
