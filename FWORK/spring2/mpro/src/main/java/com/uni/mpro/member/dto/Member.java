package com.uni.mpro.member.dto;

import java.sql.Date;

import lombok.Data;

@Data
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
