package com.uni.member.model.service;

import static com.uni.common.JDBCTemplate.close;
import static com.uni.common.JDBCTemplate.commit;
import static com.uni.common.JDBCTemplate.getConnection;
import static com.uni.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.uni.member.model.dao.MemberDao;
import com.uni.member.model.dto.Member;

public class MemberService {

	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
		Member loginUser = new MemberDao().loginMember(conn, userId, userPwd);
		
		close(conn);
		return loginUser;
	}

	public int insertMember(Member mem) {
		Connection conn = getConnection();
		int result = new MemberDao().insertMember(conn, mem);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Member selectMember(String userId) {
		Connection conn = getConnection();
		
		Member mem = new MemberDao().selectMember(conn, userId);
		
		close(conn);
		return mem;
	}

	public Member updateMember(Member m) {
		Connection conn = getConnection();
		Member updateMem = null; //return값으로 넘기기 위해 null값으로 초기화
		int result = new MemberDao().updateMember(conn, m);
		
		if(result > 0) { //update값이 여러개일 수 있기 때문에 result > 0
			commit(conn); //업데이트 되었다면 커밋, 커밋 된(수정된) 값을 가져오기 위함.
			updateMem = new MemberDao().selectMember(conn, m.getUserId()); //리턴값을 주기 위해서 m의Id를 파라미터로 selectMember에 넘겨서 값을 가져옴 
		}else {
			rollback(conn); //업데이트 실패했다면 rollback
		}
		close(conn);
		return updateMem;
	}

	public int deleteMember(String userId) {
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(conn, userId);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Member updatePwd(String userId, String userPwd, String newPwd) {
		Connection conn = getConnection();
		Member updateMem = null; //return값으로 넘기기 위해 null값으로 초기화
		int result = new MemberDao().updatePwd(conn, userId, userPwd, newPwd);
		
		if(result > 0) {
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, userId);
		}else {
			rollback(conn);
		}
		close(conn);
		return updateMem;
	}

}
