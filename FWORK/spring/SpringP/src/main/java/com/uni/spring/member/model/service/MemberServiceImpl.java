package com.uni.spring.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.spring.member.model.dao.MemberDao;
import com.uni.spring.member.model.dto.Member;

//비즈니스 로직을 처리하는 클래스(빈)이다.
@Service 
public class MemberServiceImpl implements MemberService {

	//root-context.xml에 bean 생성(템플릿)
	@Autowired 
	private SqlSessionTemplate sqlSession;
	
	//@Repository에서 네이밍을 따로 하지 않았기 때문에 앞글자 소문자로 연결하기
	@Autowired
	private MemberDao memberDao; 
	
	@Override
	public Member loginMember(Member m) throws Exception {
		
		Member loginUser = memberDao.loginMember(sqlSession, m);
		
		System.out.println("loginUser : "+loginUser);
		
		if(loginUser == null) { //조회결과 없으면
			throw new Exception("loginUser 확인"); //예외 발생시키기
		}
		return loginUser; //로그인유저 정보 넘기기
	}

	@Override
	public void insertMember(Member m) {
		int result = memberDao.insertMember(sqlSession, m);
		
	}

}
