package com.uni.chap02.loop;

import java.util.Scanner;

public class C_DoWhile {
	/*
	 * * do-while문
	 * 
	 * [초기식]
	 * 
	 * do{
	 * 		반복적으로 실행할 코드;
	 * 
	 * 		[증감식]
	 * 
	 * }while(조건식); 
	 * 
	 * 
	 * 초기식  --> 무조건 한번은 실행 --> 증감식 
	 * 조건식 --> true일 경우 실행 --> 증감식
	 * 조건식 --> true일 경우 실행 --> 증감식
	 * 조건식 --> false일 경우 빠져나감
	 * 
	 * while문과 다른 점은 while문은 처음 수행될때도 조건식을 검사하고 나서 조건식이 true일 경우 실행되는데
	 * do while문은 첫 실행은 조건식없이 무조건 수행된다는 점
	 * 
	 */
	
	public void method1() {
		int num = 1;
		do {
			System.out.println(num);
		}while(num == 0);
	}
	
	public void method2() {
		//1부터 5까지
		int i = 1;
		do {
//			System.out.print(i+" ");
//			i++;
			
			System.out.print(i++ +" ");
		}while(i<=5); 
	}
	
	public void method3() {
		int random = (int)(Math.random()*10+1);

		System.out.println("랜덤값 : "+ random);

		int sum = 0;

		int i = 1;
		do {
			sum +=i;
			i++;
		}while( i <= random);
		System.out.println("1부터 "+random+" 까지의 합 : "+ sum);
	}
	public void method4() {
		//사용자가 입력한 단 출력하기
		Scanner sc = new Scanner(System.in);
		System.out.println("단수(2~9) 입력 : ");
		int dan = sc.nextInt();

		if(dan > 1 && dan < 10) {
			int i = 1;
			do {
				System.out.printf("%d * %d = %d\n", dan, i, dan*i);
				i++;
			}while(i < 10);
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
		do {
			System.out.println(str.charAt(i));
			i++;
		}while(i<str.length());
	}
	
	public void method6() {
		Scanner sc = new Scanner(System.in);		

		do {
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
		}while(true);
	}
	public void method7() {
		Scanner sc = new Scanner(System.in);		

		String str ="";

		do {
			System.out.println("문자열을 입력해주세요 : ");
			str =sc.nextLine();
			System.out.println("str : "+str);

		}while(!str.equals("exit"));
		System.out.println("exit를 입력해서 종료 되었습니다.");
	}
	public void method8() {
		//무한 루프 break으로 빠져나가기

		Scanner sc = new Scanner(System.in);		

		String str ="";

		do {
			System.out.println("문자열을 입력해주세요 : ");
			str =sc.nextLine();
			if(str.equals("exit")) {
				break;
			}
			System.out.println("str : "+str);
		}while(true);
		System.out.println("exit를 입력해서 종료 되었습니다.");
	}
}
