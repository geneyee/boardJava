package com.blog.project.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.project.beans.ContentBean;
import com.blog.project.dao.BoardDao;

@Service
public class MainService {
	
	@Autowired
	BoardDao boardDao;

	public List<ContentBean> getMainList(int board_info_idx) {
		
		RowBounds rowBounds = new RowBounds(0,5);
		
		return boardDao.getContentList(board_info_idx, rowBounds);
		
	}
	

}
