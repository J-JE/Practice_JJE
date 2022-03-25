package com.uni.notice.model.service;

import static com.uni.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.uni.notice.model.dao.NoticeDao;
import com.uni.notice.model.dto.Notice;

public class NoticeService {

	public ArrayList<Notice> selectList() {
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectList(conn);
		
		close(conn);
		return list;
	}

	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		int result = new NoticeDao().insertNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public Notice selectNotice(int nno) {
		Connection conn = getConnection();
		int result = new NoticeDao().increaseCount(conn, nno); //조회수 올리기
		Notice n = null;
		if(result > 0) {
			commit(conn);
			//조회수가 올라갔을 때 객체 생성
			n = new NoticeDao().selectNotice(conn, nno);
		}else {
			rollback(conn);
		}
		close(conn);
		return n;
	}

	public int deleteNotice(int nno) {
		Connection conn = getConnection();
		int result = new NoticeDao().deleteNotice(conn, nno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int updateNotice(int nno, String newTitle, String newContent) {
		Connection conn = getConnection();
		int result = new NoticeDao().updateNotice(conn, nno, newTitle, newContent);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

}
