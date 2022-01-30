package com.uni.chap04_field.model.vo;


//클래스 변수(static)
public class FieldTest3 {
	//전역변수의 일종인 클래스 변수는 static 예약어가 붙은 변수 
	
	//static -> 프로그램 실행하자마자 static 메모리 영역에 할당됨 ,static 은 공유의 개념 ,
	//일반멤버 변수는 이 클래스로 객체를 생성해야만 그변수가 메모리에 올라간다면 static 이 붙은 변수는 프로그램 실행과 동시에 메모리에 올라감.
	
	
	public static String pubSta = "public static";
	private static String priSta = "private static";
	
	
	public static String getPriSta() {
		return priSta;
	}
	public static void setPriSta(String priSta) {
		
		FieldTest3.priSta = priSta;//static은 객체를 생성하지 않고 프로그램 실행과 동시에 static 영역에 할당되기 때문에 this가 존재하지 않는다.
	}
	
	
	
}
