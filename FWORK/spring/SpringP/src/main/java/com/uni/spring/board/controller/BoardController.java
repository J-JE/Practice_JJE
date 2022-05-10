package com.uni.spring.board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uni.spring.board.model.dto.Board;
import com.uni.spring.board.model.dto.PageInfo;
import com.uni.spring.board.model.service.BoardService;
import com.uni.spring.common.Pagination;

@Controller
public class BoardController {
	
	@Autowired
	public BoardService boardService; //왜 public? private?
	
	@RequestMapping("listBoard.do")
	public String selectList(@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage, Model model) {
		
		//@RequestParam(value="currentPage") int currentPage -> 값이 넘어오지 않아 에러 발생
		
		//@RequestParam(value="currentPage", required = false) int currentPage
		//required : 해단 파라미터가 필수인지 여부 (기본값 true : 필수)
		//required = false : 값을 꼭 받아줄 필요가 없다고 선언. -> null이 들어올 수 있다.
		//--> null은 기본형 int에 들어갈 수 없기 떄문에 에러 발생
		
		//@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage
		//defaultValue : 넘어오는 값이 null인 경우 해당 파라미터에 기본값을 지정
		
		int listCount = boardService.selectListCount();
		System.out.println(listCount);
		
//		int pageLimit = 10; //페이지 수
//		int boardLimit = 5; //게시글 수
//		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit);
		
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, 10, 5);
		
		ArrayList<Board> list = boardService.selectList(pi);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		
		return"board/boardListView";
	}
	
}
