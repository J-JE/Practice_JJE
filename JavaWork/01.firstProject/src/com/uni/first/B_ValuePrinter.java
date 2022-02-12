package com.uni.first;

public class B_ValuePrinter {
	/*
	 *  ** 원칙 ** 
	 *  1. 클래스명 --> 대문자로 시작
	 *  2. 패키지명 --> 소문자로 시작
	 *  3. 메소드명 --> 소문자로 시작
	 *  4. 변수명  --> 소문자로 시작
	 *  
	 *  단, 여러개의 단어가 있을 때는 단어 앞자리마다 대문자로 !! == 낙타 표기법(개발자간의 예의)
	 *  
	 *  ex) 클래스명 Methodprinter --> MethodPrinter
	 *      메소드명 testprint --> testPrint
	 *  
	 *  그리고 항상 의미있게 이름짓자!!
	 */
	
	public void printValue() {
		
		//1.숫자 출력 -> 따옴표 없이
		System.out.println(123); //정수값 출력
		System.out.println(1.23); //실수값 출력
		
		//2.문자(한글자) 출력 -> 따옴표
		System.out.println('a');
		System.out.println('b');
		
		//3.문자열(여러글자) 출력 -> 쌍따옴표
		System.out.println("안녕하세요.");
		System.out.println("반갑습니다.");
		
		//4.연산한 결과값도 출력가능
		System.out.println(123+456);
		System.out.println(1.23+0.12);
		
		//5.문자와 숫자연산도 가능하다. -> 문자와 숫자 연산시 문자를 자동으로 숫자로 인식
		System.out.println('a'+1); //각 문자마다 컴퓨터가 인식하는 고유한 숫자값을 가지고 있음 a=>97
		
		//6. 문자열("") + 그 이외의 값들의 덧셈연산 -> 문자열화
		System.out.println("하이"+'a');
		System.out.println("하이"+1234);
		System.out.println("하이"+1234+1000);
		System.out.println(1234+1000+"하이");
		System.out.println("하이"+(1234+1000));

		
	}

}
