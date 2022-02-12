package com.uni.chap02_abstractAndinterface.model.vo;
//미완성 클래스 : 클래스 extends (하나만 상속가능)
//인터페이스 : implements (여러개 적을 수 있다.
public class FootBall extends Sports implements iSports1/*, iSports2*/{

	@Override
	public void rule() {
		System.out.println("손이 아니고 발로 공을 찬다.");
		
	}

	@Override
	public void rule1() {
		System.out.println("인터페이스 ISports1 메소드 rule1()");
	}

	@Override
	public void startTime() {
		System.out.println("인터페이스 ISports2 메소드 startTime()");
		
	}

	@Override
	public void endTime() {
		System.out.println("인터페이스 ISports2 endTime()");
		
	}
	
}
