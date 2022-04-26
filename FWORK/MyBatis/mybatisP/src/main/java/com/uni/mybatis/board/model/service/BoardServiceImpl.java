package com.uni.mybatis.board.model.service;

import static com.uni.mybatis.common.Template.getSqlSession;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.uni.mybatis.board.model.dao.BoardDao;
import com.uni.mybatis.board.model.dto.Board;
import com.uni.mybatis.board.model.dto.PageInfo;
import com.uni.mybatis.board.model.dto.SearchCondition;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao = new BoardDao();
	
	@Override
	public int getListCount() throws Exception{
		SqlSession sqlSession = getSqlSession();
		
		int listCount = boardDao.getListCount(sqlSession);
		System.out.println("listCount : "+listCount);
		sqlSession.close();
		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) throws Exception{
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> list = boardDao.selectList(sqlSession, pi);
		return list;
	}

	@Override
	public int getSearchListCount(SearchCondition sc) throws Exception {
		SqlSession sqlSession = getSqlSession(); //열린 세션 가져오기
		int listCount = boardDao.getSearchListCount(sqlSession, sc); //검색어도 넘김
		System.out.println("BoardServiceImpl.getSearchListCount() : "+listCount);
		sqlSession.close();
		return listCount;
	}

	@Override
	public ArrayList<Board> selectSearchList(SearchCondition sc, PageInfo pi) throws Exception {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Board> list =boardDao.selectSearchList(sqlSession,sc,pi);
		sqlSession.close();
		return list;
	}

	@Override
	public Board selectBoard(int bno) throws Exception {
		SqlSession sqlSession = getSqlSession();
		int result = boardDao.updateCount(sqlSession, bno);
		
		Board b = null;
		if(result >0) {
			sqlSession.commit();
			b = boardDao.selectBoard(sqlSession, bno);
		}else {
			sqlSession.rollback();
			throw new Exception();
		}
		sqlSession.close();
		return b;
	}

}
