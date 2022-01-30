package com.uni.opertaor;

import java.util.Scanner;

public class A_LogicalNegation {
	//단항연산자 (하나의 값을 가지고 연산함)
	//논리부정연산자 --> ! : 논리값을 반대로 바꾸는 연산자
	//* 논리값 : true/false

	public void method1() {
		System.out.println("true 의 부정 : "+ !true);
		System.out.println("false 의 부정 : "+ !false);
		
		boolean b1 = true;
		boolean b2 = false;
		
		System.out.println(b1);
		System.out.println("b1의 부정 : "+!b1);
		
		System.out.println(b2);
		System.out.println("b2의 부정 : "+!b2);
	}

	public void method2 () {
		//사용자가 입력한 정수값이 0보다 크면 true 출력, 작으면 false 출력하는 메소드
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 하나 입력 : ");
		
//		int num = sc.nextInt();
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.println("입력한 정수가 양수인가 ?" + (num > 0));
		System.out.println("입력한 정수가 양수인가 ?" + !(num < 0));
		
		
		
		
	}
	
}
