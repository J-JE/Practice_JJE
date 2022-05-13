package com.uni.mpro.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.mpro.member.dao.MemberMapper;
import com.uni.mpro.member.dto.Member;
import com.uni.mpro.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	//mapper와 연결항 때 dao는 클래스였음 그래서 mapper 쿼리문의 id와 mapper namespace를 일치시켜서 사용했음
	//interface를 사용하면 sqlSEssion객체의 주입이 없어도 됨, mapper의 namespace를 MemberMapper의 클래스와 일치하게 만들어서 사용
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public Member loginMember(Member m) {
		
		Member loginUser = memberMapper.loginMember(m);
		return loginUser;
	}

}
