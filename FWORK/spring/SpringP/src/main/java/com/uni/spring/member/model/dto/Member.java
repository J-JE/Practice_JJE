package com.uni.spring.member.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //파라미터없는 기본생성자
@AllArgsConstructor //모든 파라미터가 있는 생성자
//@RequiredArgsConstructor 필요한 파라미터를 사용해 생성자 만들기
@Setter
@Getter
@ToString
public class Member {
	
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String gender;
	//private int age;
	private String age; // 나중에 회원가입 시
	private String phone;
	private String address;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
}
