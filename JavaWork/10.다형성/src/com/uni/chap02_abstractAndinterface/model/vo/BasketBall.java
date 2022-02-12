package com.uni.chap02_abstractAndinterface.model.vo;

public class BasketBall extends Sports /*implements iSports1, iSports2*/{
	// 상속 받는 순간 --> 부모클래스에있는 추상메소드를 강제 오버라이딩 하게끔 뜸 , 또는 추상클래스라고 명시 하게끔 뜬다 --> 미완성 상태이기 때문에

	@Override
	public void rule() {
		System.out.println("공을 던져서 링에 넣어야한다.");
		
	}
	
//	@Override
//	public void rule1() {
//		System.out.println("인터페이스 ISports1 메소드 rule1()");		
//	}
	
//	@Override
//	public void startTime() {
//		System.out.println("인터페이스 ISports2 메소드 startTime()");
//		
//	}

//	@Override
//	public void endTime() {
//		System.out.println("인터페이스 ISports2 endTime()");
//		
//	}
}
