package com.method.hw3.run;

import com.method.hw3.controller.StaticSample;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* StaticSample의 value 필드 값을 “Java”로 먼저 초기화 한 후
		메소드들 호출을 통해 구현 */
		
		/* 각 메소드에서 출력문은 존재하지 않는다.
		테스트 출력은 main 함수에서 value에 접근하여 출력 */
		
		//0. StaticSample 클래스 변수인 value를 “Java”로 초기화 후 출력
		
		StaticSample.setValue("Java");
//		sample1.setValue("Java");
		System.out.println("value : "+StaticSample.getValue());
		
		//1. toUpper 메소드 실행을 통해 대문자로 변경 후 출력
		StaticSample.toUpper();
		System.out.println("대문자로 : "+StaticSample.getValue());
		
		//3. valueLength 메소드 실행을 통해 길이 출력
		System.out.println("길이 : "+StaticSample.valueLength());
		
		//4. valueConcat 메소드 실행을 통해 “PROGRAMMING” 문자열 합친 후 출력
		StaticSample.valueConcat("PROGRAMMONG");
		System.out.println("PROGRAMMING 붙여서 : "+StaticSample.getValue());
		
		//2. setChar 메소드 실행을 통해 “J”를 “C”로 변경 후 출력
		/* 
		StaticSample.setChar(0, 'C');
		System.out.println("J => C : "+StaticSample.getValue());
		*///결과값이 CAVA가 아니라 CAVAPROGRAMMING으로 나옴
		
//		StaticSample sample =new StaticSample();
		StaticSample.setValue("JAVA"); //
		StaticSample.setChar(0, 'C');
		System.out.println("J => C : "+StaticSample.getValue());

	}

}
