package com.uni.chap06_constructor.run;

import com.uni.chap06_constructor.model.vo.User;

public class Run {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1. 기본생성자로 객체생성 직후 해당 객체 정보 출력
		User u1 =new User();
		System.out.println(u1.toString());
		
		
		//2. 매개변수3개짜리 생성자로 객체 생성
		User u2 =new User("user02","pss02","로운");
		System.out.println(u2.toString());
		
		//3. 다른 매개변수 생성자를 사용해서 객체 생성(매개변수5개짜리)
		User u3 =new User("user03","pss03","공명",20,'M');
		System.out.println(u3.toString());
	}

}
