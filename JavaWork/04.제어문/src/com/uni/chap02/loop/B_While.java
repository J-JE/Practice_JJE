package com.uni.chap02.loop;

import java.util.Scanner;

public class B_While {
	/*
	 * * while문
	 * 
	 * [초기식]
	 * 
	 * while(조건식) {
	 * 		반복적으로 실행할 코드;
	 * 		[증감식]
	 * }
	 * 
	 * 조건식이 true일 경우 해당 실행코드 실행
	 * 
	 * 조건식 검사 --> true일 경우 실행코드 실행
	 * 조건식 검사 --> true일 경우 실행코드 실행
	 * 조건식 검사 --> false일 경우 실행코드 실행 X --> 반복문 빠져 나감
	 * 
	 * 
	 */
	
	public void method0() {
		int i = 1; //변수 선언, 초기화
		while(i <= 10) { // 조건식 i가10이 될 때까지
			System.out.println(i + " 출력"); 
			i++;
		}
	}
	
	public void method1() {
		
		int i = 1;
		while(i <= 5) {
			System.out.println("안녕하세요");
			i++;
		}
		System.out.println("i : "+i);
		
		i = 1;
		while(i <= 5) {
			System.out.print(i+" ");
			i++;
		}
		System.out.print("/ ");
		
		i = 5;
		while(i >= 1) {
			System.out.print(i+" ");
			i--;
		}
	}
	
	public void method2() {
		
		int i = 1;
		while(i<=10) {
			if(i%2==1) {
				System.out.print(i+" ");
			}
			i++; //if문 안에다 넣으면 if문을 탔을 때만 증가되기 때문에 위치 선정 중요
		}
		i=1;
		while(i<=10) {
			System.out.print(i+ " ");
			i += 2;
		}
	}
	
	public void method3() {
		int random = (int)(Math.random()*10+1);
		
		System.out.println("랜덤값 : "+ random);
		
		int sum = 0;
		
		int i = 1;
		while( i <= random) {
			sum +=i;
			i++;
		}
		System.out.println("1부터 "+random+" 까지의 합 : "+ sum);
	}
	
	public void method4() {
		//사용자가 입력한 단 출력하기
		Scanner sc = new Scanner(System.in);
		System.out.println("단수(2~9) 입력 : ");
		int dan = sc.nextInt();

		if(dan > 1 && dan < 10) {
			int i = 1;
			while(i < 10) {
				System.out.printf("%d * %d = %d\n", dan, i, dan*i);
				i++;
			}
		}else {
			System.out.println("반드시 2~9 사이의 양수를 입력해야합니다.");
		}
	}
	public void method5() {
		// 사용자한테 문자열을 입력받아서 각인덱스 별로 문자를 각각 추출 하시오
		Scanner sc = new Scanner(System.in);		
		System.out.println("문자열 입력 : ");
		String str = sc.nextLine();
		
		System.out.println("문자열 길이 "+str.length());
		
		int i = 0;
		while(i<str.length()) {
			System.out.println(str.charAt(i));
			i++;
		}
	}
	
	public void method6() {
		Scanner sc = new Scanner(System.in);		

		int i=1;
		while(true) {
			System.out.println();
			System.out.println("========메뉴========");
			System.out.println("1. 1부터 5까지 출력");
			System.out.println("2. 1부터 10 사이의 홀수만 출력");
			System.out.println("3. 1부터 어떤 랜덤값 까지의 합계");
			System.out.println("9. 프로그램 종료");
			
			System.out.println("메뉴 선택 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘못입력하였습니다.");
				break;
			}
		}
	}
	
	public void method7() {
		//계속 문자열을 입력 받고 그문자열을 출력 하게끔 
		//하지만 그문자열이 "exit" 가 아닐때 까지 반복

		Scanner sc = new Scanner(System.in);		
		
		String str ="";
		
		while(!str.equals("exit")) {
			System.out.println("문자열을 입력해주세요 : ");
			str =sc.nextLine();
			System.out.println("str : "+str);
			
		}
		System.out.println("exit를 입력해서 종료 되었습니다.");
	}
	
	public void method8() {
		//무한 루프 break으로 빠져나가기

		Scanner sc = new Scanner(System.in);		

		String str ="";

		while(true) {
			System.out.println("문자열을 입력해주세요 : ");
			str =sc.nextLine();
			if(str.equals("exit")) {
				break;
			}
			System.out.println("str : "+str);
		}
		System.out.println("exit를 입력해서 종료 되었습니다.");
	}
	
	
	
	
}
