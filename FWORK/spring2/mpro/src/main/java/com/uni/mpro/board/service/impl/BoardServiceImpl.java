package com.uni.mpro.board.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.mpro.board.dao.BoardMapper;
import com.uni.mpro.board.dto.Board;
import com.uni.mpro.board.service.BoardService;

@Transactional(rollbackFor = Exception.class)
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public ArrayList<Board> selectTopList() {
		return boardMapper.selectTopList();
	}

}
