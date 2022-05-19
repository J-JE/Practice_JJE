package com.uni.boot2.service;

import com.uni.boot2.dto.BoardDto;

import java.util.List;

public interface BoardService {

    List<BoardDto> selectBoardAll();

    void insertBoard(BoardDto board);

    void deleteById(long id); //Long : 대문자로도 인식을 함

    Object selectBoard(long id);

    void updateBoard(BoardDto board);
}
