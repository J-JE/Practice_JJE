package com.uni.member.model.dao;

import static com.uni.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uni.member.model.dto.Member;
/* 이전 프로젝트에서 Dao가 맡은 업무
1) JDBC드라이버 등록
2) DB 연결 Connection 객체생성
3) SQL 실행
4) 처리결과에 따른 트랜잭션처리(commit, rollback)
5) 자원 반환

이 때, 실제로 dao가 처리해야 업무는 SQL문을 DB로 전달하여 실행하고 반환값을 받아오는
3번의 역할만을 진행해야 함. 
 --> 3번 이외에 1,2,4,5 역할을 분리해야 함.
 
+ 1,2,4,5의 업무는 어디서든 공통적으로 이루어지는 공통 업무
 --> 한번에 묶어서 처리해주기
 --> 공통업무를 처리하기 위한
 JDBCTemplate 클래스 생성.
*/

public class MemberDao {

	public ArrayList<Member> selectAll(Connection conn) {
		ArrayList<Member> list = null;
		
		Statement stmt = null; //실행할 쿼리
		ResultSet rset = null; //Select한 후 결과값 받아올 객체
		
		String sql = "SELECT * FROM MEMBER"; //자동으로 세미콜론을 붙여서 실행하기 때문에 ;를 붙이지 않는다.
		
		try {
			//3. 쿼리문을 실행할 statement 객체 생성
			stmt = conn.createStatement();
			
			//4. 쿼리문 전송, 실행결과를 ResultSet으로 받기
			rset = stmt.executeQuery(sql);
			
			//5. 받은 결과값(ResultSet)을 객체에 옮겨서 담기
			list = new ArrayList<Member>();
			
			while(rset.next()) { //행별로 받아오기 위함
				Member m = new Member();
				m.setUserId(rset.getString("USERID"));
				m.setPassword(rset.getString("PASSWORD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setPhone(rset.getString("PHONE"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
				
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public Member selectOne(Connection conn, String memberId) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
		
		try {
			//3. 쿼리문을 실행할 prepareStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId); //1->첫번 째 파라미터
			//4. 쿼리문 전송, 실행결과를 ResultSet으로 받기
			rset = pstmt.executeQuery();
			
			//5. 받은 결과값(ResultSet)을 객체에 옮겨서 담기
			if(rset.next()) {
				m = new Member();
				m.setUserId(rset.getString("USERID"));
				m.setPassword(rset.getString("PASSWORD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setPhone(rset.getString("PHONE"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}

	public Member selectName(Connection conn, String memberName) {
		Member m = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USERNAME = '"+memberName+"'";
		
		try {
			//3. 쿼리문을 실행할 statement 객체 생성
			stmt = conn.createStatement();
			
			//4. 쿼리문 전송, 실행결과를 ResultSet으로 받기
			rset = stmt.executeQuery(sql);
			
			//5. 받은 결과값(ResultSet)을 객체에 옮겨서 담기
			if(rset.next()) {
				m = new Member();
				m.setUserId(rset.getString("USERID"));
				m.setPassword(rset.getString("PASSWORD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setPhone(rset.getString("PHONE"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) { //두번째 try/catch
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}
		return m;
	}
	
	public int insertMember(Connection conn, Member m) {
		int result = 0; //행을 받을 변수

		PreparedStatement pstmt = null;  

		String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE )";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());

			result = pstmt.executeUpdate();//처리한 행의 갯수 리턴

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateMemeber(Connection conn, Member m) {
		int result = 0;

		PreparedStatement pstmt = null;  

		String sql = "UPDATE MEMBER SET PASSWORD = ? , EMAIL = ? , PHONE = ? , ADDRESS = ?"
				+ " WHERE USERID = ?";
		
		try {
			//3.쿼리문을 실행할 statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getPassword());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();//처리한 행의 갯수 리턴
			

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteMember(Connection conn, String userId) {
		int result = 0;

		PreparedStatement pstmt = null;  


		String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		try {
			//3.쿼리문을 실행할 statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();//처리한 행의 갯수 리턴


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public List<Member> selectByName(String memberName){
		ArrayList<Member> list = null;

		Connection conn = null; 
		PreparedStatement pstmt = null;  
		ResultSet rset = null;

		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE ?";
		try {
			//1.Jdbc driver 등록처리 : 해당 database 벤더사가 제공하는 클래스 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("드라이버 등록성공");
			//2.등록된 클래스를 이용해서 db를 연결
			// 드라이버타입@ip주소:포트번호:db이름(SID)
			// orcl:사용자정의설치 , thin : 자동으로 설치 //ip주소 -> localhost 로 변경해도됨
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "STUDENT", "STUDENT");
			System.out.println("conn : " + conn); // 성공하면 connection 값, 실패하면 null


			//3. 쿼리문을 실행할 statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+memberName+"%");
			//4. 쿼리문 전송, 실행결과를 ResultSet으로 받기
			rset = pstmt.executeQuery();
			
			//5. 받은 결과값(ResultSet)을 객체에 옮겨서 담기
			list = new ArrayList<Member>();
			
			while(rset.next()) { //행별로 받아오기 위함
				Member m = new Member();
				m.setUserId(rset.getString("USERID"));
				m.setPassword(rset.getString("PASSWORD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setPhone(rset.getString("PHONE"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
				
				list.add(m);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) { //두번째 try/catch
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}

	public ArrayList<Member> selectAllDeleteMember(Connection conn) {
		ArrayList<Member> list = null;
		
		Statement stmt = null; //PreparedStatement도 상관은 없음 파라미터로 넣을 값이 없을 뿐
		ResultSet rset = null; 
		
		String sql = "SELECT * FROM MEMBER_DEL";
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<Member>();
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserId(rset.getString("USERID"));
				m.setPassword(rset.getString("PASSWORD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setPhone(rset.getString("PHONE"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
				m.setDelDate(rset.getDate("DEL_DATE"));
				
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}
	
}
