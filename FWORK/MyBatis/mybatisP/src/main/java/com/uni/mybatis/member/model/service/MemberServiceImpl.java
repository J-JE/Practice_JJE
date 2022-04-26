package com.uni.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;
import static com.uni.mybatis.common.Template.getSqlSession;

import com.uni.mybatis.member.model.dao.MemberDao;
import com.uni.mybatis.member.model.dto.Member;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao = new MemberDao();
	
	@Override
	public Member loginMember(Member m) throws Exception{ //멤버 서비스 인터페이스의 메소드를 오버라이딩 하기
		SqlSession sqlSession = getSqlSession(); //Template 임포트 해서 sql세션 사용
		
		Member loginUser = memberDao.loginMember(sqlSession, m); //dao에 sqlSession과 함께 파라미터 넘기기
		
		sqlSession.close(); //세션 종료
		return loginUser;
	}

	@Override
	public void insertMember(Member m) throws Exception {
		SqlSession sqlSession = getSqlSession();
		
		int result = MemberDao.insertMember(sqlSession, m);
		
		if(result >0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
			throw new Exception();
		}
		
		sqlSession.close();
//		return result; Exception처리를 했기 때문에 return 하지 않아도 됨
	}

	@Override
	public Member selectMember(String userId) throws Exception {
		SqlSession sqlSession = getSqlSession();
		
		Member member = memberDao.selectMember(sqlSession, userId);
		
		sqlSession.close();
		return member;
	}

	@Override
	public void updateMember(Member updateMem) throws Exception {
		SqlSession sqlSession = getSqlSession();
		
		int result = MemberDao.updateMember(sqlSession, updateMem);
		
		if(result >0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
			throw new Exception();
		}
		
		sqlSession.close();
	}

}
