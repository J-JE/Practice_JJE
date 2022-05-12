package com.uni.spring.board.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.spring.board.model.dao.BoardDao;
import com.uni.spring.board.model.dto.Board;
import com.uni.spring.board.model.dto.PageInfo;
import com.uni.spring.board.model.dto.Reply;
import com.uni.spring.common.CommException;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public int selectListCount() {
		return boardDao.selectListCount(sqlSession);
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		return  boardDao.selectList(sqlSession, pi);
	}

	@Override
	public void insertBoard(Board b) {
		int result = boardDao.insertBoard(sqlSession, b);
		if(result <0) {
			throw new CommException("게시글 등록에 실패했습니다.");
		}
	}

	@Override
	public Board selectBoard(int bno) {
		//조회수 증가
		Board b = null;
		
		int result = boardDao.increaseCount(sqlSession, bno);
		
		if(result < 0) {
			throw new CommException("increaseCount 실패");
		}else {
			//게시글 조회
			b = boardDao.selectBoard(sqlSession, bno);
		}
		return b;
	}

	@Override
	public void updateBoard(Board b) {
		int result = boardDao.updateBoard(sqlSession, b);
		
		if(result < 0) {
			throw new CommException("게시글 수정 실패");
		}
	}

	@Override
	public void deleteBoard(int bno) {
		int result = boardDao.deleteBoard(sqlSession, bno);
		
		if(result < 0) {
			throw new CommException("게시글 삭제 실패");
		}
	}

	@Override
	public ArrayList<Reply> selectReplyList(int bno) {
		return boardDao.selectReplyList(sqlSession, bno);
	}

	@Override
	public int insertReply(Reply r) {
		return boardDao.insertReply(sqlSession, r);
	}

	@Override
	public ArrayList<Board> selectTopList() {
		return boardDao.selectTopList(sqlSession);
	}

}
