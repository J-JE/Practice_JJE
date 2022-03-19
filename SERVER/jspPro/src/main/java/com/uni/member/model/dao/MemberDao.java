package com.uni.member.model.dao;

import static com.uni.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.uni.member.model.dto.Member;

public class MemberDao {
	private Properties prop = new Properties();

	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
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

	public Member loginMember(Connection conn, String userId, String userPwd) {
		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//loginMember=SELECT * FROM MEMBER WHERE USER_ID=? AND USER_PWD=? AND STATUS='Y'
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt=conn.prepareStatement(sql); //?
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery(); //?
			
			if(rset.next()) {
				loginUser = new Member(rset.getInt("USER_NO"),
										rset.getString("USER_ID"),
										rset.getString("USER_PWD"),
										rset.getString("USER_NAME"),
										rset.getString("PHONE"),
										rset.getString("EMAIL"),
										rset.getString("ADDRESS"),
										rset.getString("INTEREST"),
										rset.getDate("ENROLL_DATE"),
										rset.getDate("MODIFY_DATE"),
										rset.getString("STATUS")
										);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
	}

	public int insertMember(Connection conn, Member mem) {
		int result = 0;
		PreparedStatement pstmt = null;

//		insertMember=INSERT INTO MEMBER VALUES(SEQ_UNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, SYSDATE, SYSDATE, DEFAULT)
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,mem.getUserId());
			pstmt.setString(2,mem.getUserPwd());
			pstmt.setString(3,mem.getUserName());
			pstmt.setString(4,mem.getPhone());
			pstmt.setString(5,mem.getEmail());
			pstmt.setString(6,mem.getAddress());
			pstmt.setString(7,mem.getInterest());
			
			result = pstmt.executeUpdate(); //레코드 수 반환
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
