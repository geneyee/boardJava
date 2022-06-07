package com.blog.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.blog.project.beans.BoardInfoBean;
import com.blog.project.beans.ContentBean;
import com.blog.project.service.MainService;
import com.blog.project.service.TopMenuService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	private TopMenuService topMenuService;
	
	@GetMapping("/main")
	public String main(Model model) {
		
		//List<ContentBean> : 게시판 당 글 5개 목록 / ArrayList<List<ContentBean>> : List<ContentBean> 각 게시판 마다 즉,4개 담을 list
		ArrayList<List<ContentBean>> list = new ArrayList<List<ContentBean>>();
		
		for(int i = 1; i <= 4; i++) {
			List<ContentBean> list1 = mainService.getMainList(i);//각 게시판 마다 글 5개씩 목록 보여줌 / i = board_info_idx
			list.add(list1);
		}
		
		model.addAttribute("list", list);
		
		List<BoardInfoBean> board_list = topMenuService.getTopMenuList();
		model.addAttribute("board_list", board_list);
		
		return "main";
	}

}
