package com.uni.spring.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.uni.spring.member.model.dto.Member;

@Repository
public class MemberDao { //("memberDao")

	public Member loginMember(SqlSessionTemplate sqlSession, Member m) {
		
		Member m1 = sqlSession.selectOne("memberMapper.loginMember", m);
		return m1;
	}

	public int insertMember(SqlSessionTemplate sqlSession, Member m) {
		// TODO Auto-generated method stub
		return sqlSession.insert("memberMapper.insertMember", m);
	}

}
