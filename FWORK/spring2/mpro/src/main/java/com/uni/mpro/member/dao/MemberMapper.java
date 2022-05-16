package com.uni.mpro.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.uni.mpro.member.dto.Member;

@Mapper //mybatis 3.0에서 지원 인터페이스지만 따로 임플리먼트 지원 안해도 됨 mapper.xml파일에 namespace에 전체 경로를 적어주면 됨, id명은 메소드명과 일치시키기
public interface MemberMapper {

	public Member loginMember(Member m);

	public int insertMember(Member m);

}
