package com.uni.mpro.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.uni.mpro.board.dto.Board;

@Mapper
public interface BoardMapper {

	ArrayList<Board> selectTopList();

}
