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
import com.uni.board.model.dto.Reply;
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

	public int increaseCount(Connection conn, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
//		increaseCount=UPDATE BOARD SET COUNT=COUNT+1 WHERE BOARD_NO=?
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Board selectBoard(Connection conn, int bno) {
		Board b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
//		selectBoard=SELECT BOARD_NO, CATEGORY_NAME, BOARD_TITLE, BOARD_CONTENT, USER_ID, COUNT, CREATE_DATE
//		FROM BOARD B JOIN MEMBER ON(BOARD_WRITER = USER_NO) LEFT JOIN CATEGORY USING(CATEGORY_NO)
//		WHERE B.STATUS = 'Y' AND BOARD_NO=?
		String sql = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board(rset.getInt("BOARD_NO"), 
						rset.getString("CATEGORY_NAME"),
						rset.getString("BOARD_TITLE"),
						rset.getString("BOARD_CONTENT"),
						rset.getString("USER_ID"),
						rset.getInt("COUNT"),
						rset.getDate("CREATE_DATE")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}

	public Attachment selectAttachment(Connection conn, int bno) {
		Attachment at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
//		selectAttachment=SELECT FILE_NO, ORIGIN_NAME, CHANGE_NAME FROM ATTACHMENT WHERE REF_BNO=? AND STATUS='Y'
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				at = new Attachment();
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return at;
	}

	public int deletetBoard(Connection conn, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
//		deleteBoard=UPDATE BOARD SET STATUS='N' WHERE BOARD_NO=?
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteAttachment(Connection conn, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
//		deleteAttachment=UPDATE ATTACHMENT SET STATUS='N' WHERE REF_BNO=?
		String sql = prop.getProperty("deleteAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
//		updateBoard=UPDATE BOARD SET CATEGORY_NO=?, BOARD_TITLE=?, BOARD_CONTENT=? WHERE BOARD_NO=?
		String sql = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(b.getCategory()));
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setInt(4, b.getBoardNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	public int updateAttachment(Connection conn, Attachment at) {
		int result = 0;
		PreparedStatement pstmt = null;
//		updateAttachment=UPDATE ATTACHMENT SET CHANGE_NAME=?, ORIGIN_NAME=?, FILE_PATH=? WHERE FILE_NO=?
		String sql = prop.getProperty("updateAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getChangeName());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getFilePath());
			pstmt.setInt(4, at.getFileNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertNewAttachment(Connection conn, Attachment at) {
		int result = 0;
		PreparedStatement pstmt = null;
//		insertNewAttachment=INSERT INTO ATTACHMENT VALUES(SEQ_FNO.NEXTVAL, ?, ?, ?, ?, SYSDATE, 1, DEFAULT)
		String sql = prop.getProperty("insertNewAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, at.getRefBoardNo());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			pstmt.setString(4, at.getFilePath());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Board> selectThList(Connection conn) {
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
/*		selectThList=SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
				FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
				WHERE FILE_NO IN( \
				SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
				WHERE BOARD.STATUS='Y' AND BOARD.BOARD_TYPE=2 ORDER BY BOARD_NO DESC
*/
		String sql = prop.getProperty("selectThList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {//생성자가 있는지 확인
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				
				list.add(b);
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

	public int insertThBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		
//		insertThBoard=INSERT INTO BOARD VALUES(SEQ_BNO.NEXTVAL, 2, NULL, ?, ?, ?, DEFAULT, SYSDATE, DEFAULT)
//		BOARD_TITLE	VARCHAR2(100 BYTE)
//		BOARD_CONTENT	VARCHAR2(4000 BYTE)
//		BOARD_WRITER	NUMBER
		String sql = prop.getProperty("insertThBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setInt(3, Integer.parseInt(b.getBoardWriter()));
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	public int insertAttachment(Connection conn, ArrayList<Attachment> fileList) {
		int result = 0;
		PreparedStatement pstmt = null;
		
//		insertAttachment=INSERT INTO ATTACHMENT VALUES(SEQ_FNO.NEXTVAL, SEQ_BNO.CURRVAL, ?, ?, ?, SYSDATE, 2, DEFAULT)
//		ORIGIN_NAME	VARCHAR2(255 BYTE)
//		CHANGE_NAME	VARCHAR2(255 BYTE)
//		FILE_PATH	VARCHAR2(1000 BYTE)
		String sql = prop.getProperty("insertAttachment");
		
		try {
//			for(Attachment at : fileList) {
			for(int i = 0; i<fileList.size(); i++) {
				Attachment at = fileList.get(i);

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				
				result += pstmt.executeUpdate();
				System.out.println(at.getOriginName());
				System.out.println(at.getChangeName());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Attachment> selectThumbnail(Connection conn, int bId) {
		ArrayList<Attachment> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
//		selectAttachment=SELECT FILE_NO, ORIGIN_NAME, CHANGE_NAME FROM ATTACHMENT WHERE REF_BNO=? AND STATUS='Y'
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bId);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Attachment at = new Attachment();
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				list.add(at);
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

	public int insertReply(Connection conn, Reply r) {
		int result =0;
		PreparedStatement pstmt = null;
		
//		insertReply=INSERT INTO REPLY VALUES(SEQ_RNO.NEXTVAL, ?, ?, ?, SYSDATE, DEFAULT)
//		REPLY_CONTENT	VARCHAR2(400 BYTE)
//		REF_BNO	NUMBER
//		REPLY_WRITER	NUMBER
		String sql = prop.getProperty("insertReply");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, r.getReplyContent());
			pstmt.setInt(2, r.getRefBoardId());
			pstmt.setInt(3, Integer.parseInt(r.getReplyWriter()));
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Reply> selectRList(Connection conn, int bid) {
		ArrayList<Reply> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
//		selectRlist=SELECT REPLY_NO, REPLY_CONTENT, USER_ID, CREATE_DATE
//		FROM REPLY R JOIN MEMBER ON(REPLY_WRITER = USER_NO)
//		WHERE REF_BNO=? AND R.STATUS='Y' ORDER BY REPLY_NO DESC
		String sql = prop.getProperty("selectRlist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Reply r = new Reply(rset.getInt("REPLY_NO"),
									rset.getString("REPLY_CONTENT"),
									rset.getString("USER_ID"),
									rset.getDate("CREATE_DATE")
						);
				list.add(r);
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

	public ArrayList<Board> selectTopList(Connection conn) {
		
		ArrayList<Board> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

/*		selectTopList=SELECT * FROM (SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
		FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
		WHERE FILE_NO IN( \
		SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
		WHERE BOARD.STATUS='Y' AND BOARD.BOARD_TYPE=2 ORDER BY COUNT DESC) WHERE ROWNUM <= 3*/	
		String sql = prop.getProperty("selectTopList");
		
		try {
			pstmt = conn.prepareStatement(sql);
		
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
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

}
