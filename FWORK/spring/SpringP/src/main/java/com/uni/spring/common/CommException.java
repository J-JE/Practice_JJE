package com.uni.spring.common;

public class CommException extends RuntimeException{
	//RuntimeException은 스프링에서 롤백을 하도록 지원해줌
	public CommException() { //기본생성자
		// TODO Auto-generated constructor stub
	}

	public CommException(String message) { //메세지가 있는 생성자 생성
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
