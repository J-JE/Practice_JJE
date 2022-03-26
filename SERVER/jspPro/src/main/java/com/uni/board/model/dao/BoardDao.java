package com.uni.board.model.dao;

import static com.uni.common.JDBCTemplate.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.uni.board.model.dto.Attachment;
import com.uni.board.model.dto.Board;
import com.uni.board.model.dto.PageInfo;
import com.uni.notice.model.dto.Notice;

public class BoardDao {
	private Properties prop = new Properties();
	public BoardDao() {
		String fileName = BoardDao.class.getResource("/sql/board/board-query.properties").getPath();
		System.out.println("fileName   " + fileName);
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
//		getListCount=SELECT COUNT(*) FROM BOARD WHERE BOARD_TYPE=1 AND STATUS='Y'
		String sql = prop.getProperty("getListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql); //쿼리 담아서 실행해야 함
			
			if(rset.next()) {
				listCount = rset.getInt(1); //첫번째 컬럼
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	public ArrayList<Board> selectList(Connection conn, PageInfo pi) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
//		selectList=SELECT * FROM (SELECT ROWNUM RNUM, A.*
//		FROM (SELECT BOARD_NO, CATEGORY_NAME, BOARD_TITLE, USER_ID, COUNT, CREATE_DATE FROM BOARD B JOIN CATEGORY USING(CATEGORY_NO)
//		JOIN MEMBER ON (BOARD_WRITER=USER_NO) WHERE BOARD_TYPE=1 AND B.STATUS='Y' ORDER BY BOARD_NO DESC) A)
//		WHERE RNUM BETWEEN ? AND ?
		String sql = prop.getProperty("selectList");
		
		/* board 게시글
		 * currentPage = 1 startRow = 1 endRow = 10;
		 * currentPage = 2 startRow = 11 endRow = 20;
		 * currentPage = 3 startRow = 21 endRow = 30;
		 * 
		 * 
		 * 
		 * */
		
		int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
		int endRow = startRow + pi.getBoardLimit() - 1;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			//BOARD_NO, CATEGORY_NAME, BOARD_TITLE, USER_ID, COUNT, CREATE_DATE
			
			rset = pstmt.executeQuery();
			while(rset.next()) {//생성자가 있는지 확인
				list.add(new Board(rset.getInt("BOARD_NO"), 
									rset.getString("CATEGORY_NAME"),
									rset.getString("BOARD_TITLE"),
									rset.getString("USER_ID"),
									rset.getInt("COUNT"),
									rset.getDate("CREATE_DATE")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int insertBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		//insertBoard=INSERT INTO BOARD VALUES(SEQ_BNO.NEXTVAL, 1, ?, ?, ?, ?, DEFAULT, SYSDATE, DEFAULT)
		String sql = prop.getProperty("insertBoard");
//		CATEGORY_NO
//		BOARD_TITLE
//		BOARD_CONTENT
//		BOARD_WRITER
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(b.getCategory()));
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setInt(4, Integer.parseInt(b.getBoardWriter()));
			//타입 확인 잘하기 Number인데 String으로 보냄, 지금은 숫자만 있기 때문에 입력에 문제가 없었지만 확실히 해둬야 함 
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	public int insertAttachment(Connection conn, Attachment at) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		//insertAttachment=INSERT INTO ATTACHMENT VALUES(SEQ_FNO.NEXTVAL, SEQ_BNO.CURRVAL, ?, ?, ?, SYSDATE, NULL, DEFAULT)
		String sql = prop.getProperty("insertAttachment");
//		ORIGIN_NAME
//		CHANGE_NAME
//		FILE_PATH
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
