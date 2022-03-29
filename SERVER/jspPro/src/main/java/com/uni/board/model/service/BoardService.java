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

	public Board selectBoard(int bno) {
		Connection conn = getConnection();
		int result = new BoardDao().increaseCount(conn, bno);//조회수
		Board b = null;
		
		if(result > 0) {
			commit(conn);
			b = new BoardDao().selectBoard(conn, bno);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return b;
	}

	public Attachment selectAttachment(int bno) {
		Connection conn = getConnection();
		Attachment at = new BoardDao().selectAttachment(conn, bno);
		close(conn);
		return at;
	}

	public Board selectUpdateBoard(int bno) {
		Connection conn = getConnection();
		Board b = new BoardDao().selectBoard(conn, bno);
		close(conn);
		return b;
	}
	
	public int deleteBoard(int bno) {
		Connection conn = getConnection();
		
		int result1 = new BoardDao().deletetBoard(conn, bno); //지운 게시글이 있으면 0 이상이 반환됨
		
		int result2 = 1; //있을수도 없을수도 근데 굳이 체크 안해도 됨
		Attachment at = new BoardDao().selectAttachment(conn, bno);
		if(at != null) { //attachment가 있다면
			result2 = new BoardDao().deleteAttachment(conn, bno);
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
//		int result2 = new BoardDao().deleteAttachment(conn, bno);
//		
//		if(result1 > 0) {
//			commit(conn);
//		}else {
//			rollback(conn);
//		}
		
		close(conn);
//		return result1;
		return result1 * result2;
	}

	public int updateBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		int result1 = new BoardDao().updateBoard(conn, b);
		int result2 = 1;
		if(at != null) {
			if(at.getFileNo() != 0) {
				result2 = new BoardDao().updateAttachment(conn, at);
			}else { //파일번호가 안담긴 경우 (추가)
//				result2 = new BoardDao().insertAttachment(conn, at); //불가능 -> 이유 다시 공부
				result2 = new BoardDao().insertNewAttachment(conn, at);
				
			}
		}
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result1 * result2;
	}


}
