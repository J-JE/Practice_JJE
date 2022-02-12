package com.uni.run;

import com.uni.first.A_MethodPrinter; // 컨트롤+시프트+o

public class RunA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 1) 실행할 메소드가 있는 클래스를 생성 (new)를 사용해서
		 * [표현법] 클래스명 사용할 이름(참조변수) = new 클래스명();
		 * 
		 */
		A_MethodPrinter a = new A_MethodPrinter();
		/* 2) 생성후 메소드 실행(호출)
		 * [표현법] 사용할이름. 실행할 메소드명();
		 * */
		/*a.methodA();
		a.methodB();
		a.methodC(); */
		
		
		a.methodA();
		
	}

}
