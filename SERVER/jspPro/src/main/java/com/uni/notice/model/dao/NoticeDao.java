package com.uni.notice.model.dao;

import static com.uni.common.JDBCTemplate.close;

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

import com.uni.notice.model.dto.Notice;

public class NoticeDao {
	private Properties prop = new Properties();

	public NoticeDao() {
		String fileName = NoticeDao.class.getResource("/sql/notice/notice-query.properties").getPath();
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

	public ArrayList<Notice> selectList(Connection conn) {


		ArrayList<Notice> list = new ArrayList<Notice>();
		
		//PreparedStatement pstmt = null; //selectList에는 ?가 없기 때문에 Statement 도 괜찮
		Statement stmt = null; //Statement로 해보기
		ResultSet rset = null;
		
//		selectList=SELECT NOTICE_NO, NOTICE_TITLE, USER_ID, COUNT, CREATE_DATE
//		FROM NOTICE N JOIN MEMBER ON (NOTICE_WRITER=USER_NO) WHERE N.STATUS='Y' ORDER BY NOTICE_NO DESC
		String sql = prop.getProperty("selectList");
		
		try {
			//pstmt = conn.prepareStatement(sql);
			//rset = pstmt.executeQuery(); //바로 결과 받기
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {//생성자가 있는지 확인
				/*list.add(new Notice(rset.getInt("NOTICE_NO"), 
									rset.getString("NOTICE_TITLE"),
									rset.getString("USER_ID"), //->noticeWriter임, 글쓴이
									rset.getInt("COUNT"),
									rset.getDate("CREATE_DATE")
						));*/
				list.add(new Notice(rset.getInt(1), 
						rset.getString(2),
						rset.getString(3),
						rset.getInt(4),
						rset.getDate(5)
						));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//close(pstmt);
			close(stmt);
			close(rset);
		}
		
		return list; //list
	}

	public int insertNotice(Connection conn, Notice n) {
		int result =0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertNotice");
//		insertNotice=INSERT INTO NOTICE VALUES(SEQ_NNO.NEXTVAL, ?, ?, ?, DEFAULT, SYSDATE, DEFAULT)		
//NOTICE_NO -
//NOTICE_TITLE
//NOTICE_CONTENT
//NOTICE_WRITER
//COUNT -
//CREATE_DATE -
//STATUS -
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, Integer.parseInt(n.getNoticeWriter()) );
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int increaseCount(Connection conn, int nno) {
		int result =0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("increaseCount");
//		increaseCount=UPDATE NOTICE SET COUNT = COUNT+1 WHERE NOTICE_NO=? AND STATUS='Y'		

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Notice selectNotice(Connection conn, int nno) {
		Notice n = null;
//selectNotice=SELECT NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, USER_ID, COUNT, CREATE_DATE
//FROM NOTICE N JOIN MEMBER ON (NOTICE_WRITER=USER_NO) WHERE NOTICE_NO=? AND N.STATUS='Y'
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new Notice(rset.getInt("NOTICE_NO"),
								rset.getString("NOTICE_TITLE"),
								rset.getString("NOTICE_CONTENT"),
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
		
		return n;
	}

	public int deleteNotice(Connection conn, int nno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
//		deleteNotice=UPDATE NOTICE SET STATUS='N' WHERE NOTICE_NO=?
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateNotice(Connection conn, int nno, String newTitle, String newContent) {
		int result = 0;
		PreparedStatement pstmt = null;
		
//		updateNotice=UPDATE NOTICE SET NOTICE_TITLE=?, NOTICE_CONTENT=? WHERE NOTICE_NO=?
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newTitle);
			pstmt.setString(2, newContent);
			pstmt.setInt(3, nno);
			
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
