package com.uni.member.service;

import static com.uni.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.uni.common.exception.MemberException;
import com.uni.member.model.dao.MemberDao;
import com.uni.member.model.dto.Member;
/* Service 클래스에서 메소드 작성 방법
 * 1) Controller로 부터 인자를 전달받음
 * 2) Connection 객체 생성
 * 3) Dao 객체 생성
 * 4) Dao로 생성한 Connection 객체와 인자를 전달
 * 5) Dao 수행 결과를 가지고 비즈니스 로직 및 트랜잭션 관리를 함 */
public class MemberService {

	public ArrayList<Member> selectAll() throws MemberException {
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().selectAll(conn);
		
		return list;
	}

	public Member selectOne(String memberId) throws MemberException {
		Connection conn = getConnection();
		Member m = new MemberDao().selectOne(conn, memberId);
		
		return m;
	}

	public ArrayList<Member> selectByName(String memberName) throws MemberException {
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().selectByName(conn, memberName);
		
		return list;
	}

	public int insertMember(Member m) throws MemberException {
		Connection conn = getConnection();
		 int result = new MemberDao().insertMember(conn, m);

		 if(result > 0) {
			 commit(conn);
		 }else {
			 rollback(conn);
		 }
		return result;
	}

	public int updateMemeber(Member m) throws MemberException {
		Connection conn = getConnection();

		int result = new MemberDao().updateMemeber(conn, m);

		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int deleteMember(String userId) throws MemberException {
		Connection conn = getConnection();

		int result = new MemberDao().deleteMember(conn, userId);

		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public ArrayList<Member> selectAllDeleteMember() throws MemberException {
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().selectAllDeleteMember(conn);
		
		return list;
	}
	
	public void exitProgram() {
		close(getConnection());
	}

}
