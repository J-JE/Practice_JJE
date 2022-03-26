package com.uni.board.model.service;

import static com.uni.common.JDBCTemplate.close;
import static com.uni.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.uni.board.model.dao.BoardDao;
import com.uni.board.model.dto.Attachment;
import com.uni.board.model.dto.Board;
import com.uni.board.model.dto.PageInfo;

public class BoardService {

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = new BoardDao().getListCount(conn);
		
		close(conn);
		return listCount;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().selectList(conn, pi);
		
		close(conn);
		return list;
	}

	public int insertBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		int result1 = new BoardDao().insertBoard(conn, b);
		
		int result2 = 1;
		
		if(at != null) {
			result2 = new BoardDao().insertAttachment(conn, at);
		}
		
		if(result1 * result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result1 * result2;
	}

}
