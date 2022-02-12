package com.uni.first; //패키지 명은 항상 소문자로 시작한다.

public class A_MethodPrinter {//클래스명은 항상 대문자로 시작한다.

	public void methodA() {//메소드 명은 항상 소문자로 시작한다.

		System.out.println("methodA출력문");
		methodB();
	}

	public void methodB() {

		System.out.println("methodB출력문");
		int a= methodC(1000);
		System.out.println(a);
	}
	
	public int methodC(int intValue) {

		System.out.println("methodC출력문"+intValue);
		
		return intValue +100;
	}


}
