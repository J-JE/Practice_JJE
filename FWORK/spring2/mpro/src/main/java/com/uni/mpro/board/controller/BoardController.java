package com.uni.mpro.board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.GsonBuilder;
import com.uni.mpro.board.dto.Board;
import com.uni.mpro.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@ResponseBody
	@RequestMapping(value="topListBoard.do", produces="application/json; charset=utf-8")
	public String selectTopList() {
		
		ArrayList<Board> list = boardService.selectTopList();
		
		return new GsonBuilder().setDateFormat("yyyy년 MM월 dd일 HH:mm:ss").create().toJson(list);
	}
}
