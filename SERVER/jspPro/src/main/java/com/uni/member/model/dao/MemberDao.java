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
			pstmt=conn.prepareStatement(sql); //
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery(); //
			
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
			
			result = pstmt.executeUpdate(); //????????? ??? ??????
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Member selectMember(Connection conn, String userId) {
		Member mem = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
//		selectMember=SELECT * FROM MEMBER WHERE USER_ID=? AND STATUS='Y'
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			
			rset = pstmt.executeQuery(); //?????? ????????? ???????????? ??????
			
			if(rset.next()) { //java.sql.SQLException: ORA-01407: cannot update ("SERVER"."MEMBER"."USER_NAME") to NULL ??????
				mem = new Member(rset.getInt("USER_NO"),
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
		return mem;
	}

	public int updateMember(Connection conn, Member m) {
		int result = 0; //return result???????????? ????????? ?????? ?????????
		PreparedStatement pstmt = null; //???????????? ??? sql?????? ???????????? ?????? ??????
		
//updateMember=UPDATE MEMBER SET USER_NAME=?, PHONE=?, EMAIL=?, ADDRESS=?, INTEREST=?, MODIFY_DATE=SYSDATE WHERE USER_ID=?
		String sql = prop.getProperty("updateMember"); //?????????????????? ????????? ???????????? ???????????? ???????????? ?????? ??????
		
		try {
			pstmt = conn.prepareStatement(sql); //conn?????? ????????? ???????????? ???????????? ?????? ????????? ???????????? ?????? ??????
			
			pstmt.setString(1, m.getUserName()); //m??? get?????? ?????? ??? ????????? ????????? ????????? ?????? pstmt??? set?????? ??? ?????? 
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4 ,m.getAddress());
			pstmt.setString(5, m.getInterest());
			pstmt.setString(6, m.getUserId());
			
			result = pstmt.executeUpdate(); //result??? pstmt??? update??? ?????? ????????? ?????????
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt); //pstmt ?????????
		}
		
		return result; //result??? ??????
	}

	public int deleteMember(Connection conn, String userId) {
		int result = 0; //????????? ?????? ?????? ??? ?????? ??????
		PreparedStatement pstmt = null;

//deleteMember=UPDATE MEMBER SET STATUS='N' WHERE USER_ID=?
		String sql = prop.getProperty("deleteMember"); //???????????? ????????? ???????????? deleteMember ???????????? ????????????
		
		try {
			pstmt = conn.prepareStatement(sql); //???????????? conn??? ????????? ???????????? ??????
			pstmt.setString(1,userId);
			
			result = pstmt.executeUpdate(); //executeUpdate : ???????????????????????? insert, update, create, delete??? ????????? ?????? ?????? ??????
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updatePwd(Connection conn, String userId, String userPwd, String newPwd) {
		int result = 0;
//		updatePwd=UPDATE MEMBER SET USER_PWD=?, MODIFY_DATE=SYSDATE WHERE USER_ID=? AND USER_PWD=?
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updatePwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,newPwd);
			pstmt.setString(2,userId);
			pstmt.setString(3,userPwd);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int idCheck(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
//		idCheck=SELECT COUNT(*) FROM MEMBER WHERE USER_ID=?
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			
			rset = pstmt.executeQuery(); //?????? ????????? ???????????? ??????
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

}
