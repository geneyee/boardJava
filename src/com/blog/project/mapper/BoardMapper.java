package com.blog.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import com.blog.project.beans.ContentBean;

public interface BoardMapper {
	
	@SelectKey(statement = "select content_seq.nextval from dual", keyProperty = "content_idx", before = true, resultType = int.class)
	
	//글 저장
	@Insert("insert into content_table(content_idx, content_subject, content_text, " +
			"content_file, content_writer_idx, content_board_idx, content_date) " +
			//"values (content_seq.nextval, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, " +
			"values (#{content_idx}, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, " +
			"#{content_writer_idx}, #{content_board_idx}, sysdate)")
	void addContentInfo(ContentBean writeContentBean);
	
	//글 목록 - 게시판 이름
	@Select("select board_info_name " +
			"from board_info_table " +
			"where board_info_idx = #{board_info_idx}")
	String getBoardInfoName(int board_info_idx);
	
	//글 목록 보기
	@Select("select a1.content_idx, a1.content_subject, a2.user_name as content_writer_name, " +
			"		to_char(a1.content_date, 'YYYY-MM-DD') as content_date " +
			"from content_table a1, user_table a2 " +
			"where a1.content_writer_idx= a2.user_idx " +
			"		and a1.content_board_idx = #{board_info_idx} " +
			"order by a1.content_idx desc")
	List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds);
	
	//글 읽기
	@Select("select a2.user_name as content_writer_name, to_char(a1.content_date, 'YYYY-MM-DD') as content_date, " +
			"		a1.content_subject, a1.content_text, a1.content_file, a1.content_writer_idx " +
			"from content_table a1, user_table a2 " +
			"where a1.content_writer_idx= a2.user_idx " +
			"    and a1.content_idx = #{content_idx}")
	ContentBean getContentInfo(int content_idx);
	
	//글 수정
	@Update("update content_table " +
			"set content_subject = #{content_subject}, content_text = #{content_text}, " +
			"	content_file = #{content_file, jdbcType=VARCHAR} " +
			"where content_idx = #{content_idx}")
	void modifyContentInfo(ContentBean modifyContentBean);
	
	//글 삭제
	@Delete("delete from content_table where content_idx = #{content_idx}")
	void deleteContentInfo(int content_idx);
	
	//전체 글 개수
	@Select("select count(*) from content_table where content_board_idx = #{content_board_idx}")
	int getContentCnt(int content_board_idx);
}
