package com.uni.mybatis.member.model.service;

import com.uni.mybatis.member.model.dto.Member;

public interface MemberService {

	Member loginMember(Member m) throws Exception; //컨트롤러에서 Exception 잡기

	void insertMember(Member m) throws Exception;

	Member selectMember(String userId) throws Exception;

	void updateMember(Member updateMem) throws Exception;

}
