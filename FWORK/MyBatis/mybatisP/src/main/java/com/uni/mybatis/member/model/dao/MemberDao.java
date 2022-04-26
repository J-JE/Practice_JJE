package com.uni.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.uni.mybatis.member.model.dto.Member;

public class MemberDao {

	public Member loginMember(SqlSession sqlSession, Member m) throws Exception {
		
		Member loginUser = null;
		
		loginUser = sqlSession.selectOne("memberMapper.loginMember",m); //select -> namespace.id, 파라미터
		System.out.println("Memberdao loginMember() : "+loginUser);
		return loginUser;
	}

	public static int insertMember(SqlSession sqlSession, Member m) throws Exception {
		return sqlSession.insert("memberMapper.insertMember",m); //mapper에 insert태그 생성
	}

	public Member selectMember(SqlSession sqlSession, String userId) throws Exception {
		Member member = sqlSession.selectOne("memberMapper.selectMember", userId);
		System.out.println("Memberdao selectMemeber() : "+member);
		return member;
	}

	public static int updateMember(SqlSession sqlSession, Member updateMem) {
		return sqlSession.insert("memberMapper.updateMember",updateMem);
	}

}
