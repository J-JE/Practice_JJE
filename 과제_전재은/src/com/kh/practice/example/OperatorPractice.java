package com.kh.practice.example;

import java.util.Scanner;

public class OperatorPractice {

	public void practice1() {
		Scanner sc = new Scanner (System.in); 

		System.out.println("정수 : ");
		int num = sc.nextInt();

		System.out.println(num>=0?"양수다":"양수가 아니다");
	}

	public void practice2(){
		Scanner sc = new Scanner (System.in); 

		System.out.println("정수 : ");
		int num = sc.nextInt();

		System.out.println(num>0?"양수다":num==0?"0이다":"음수다");
	}

	public void practice3(){
		Scanner sc = new Scanner (System.in); 

		System.out.println("정수 : ");
		int num = sc.nextInt();

		System.out.println(num%2==0?"짝수다":"홀수다");
	}

	public void practice4(){
		Scanner sc = new Scanner (System.in); 
		System.out.println("인원 수 : ");
		int num1 = sc.nextInt();
		System.out.println("사탕 개수 : ");
		int num2 = sc.nextInt();
		
		System.out.println("1인당 사탕 개수 : "+num2/num1);
		System.out.println("남는 사탕 개수 : "+num2%num1);

	}
	
	public void practice5(){
		Scanner sc = new Scanner (System.in); 
		
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("학년(숫자만) : ");
		int grade = sc.nextInt();
		System.out.println("반(숫자만) : ");
		int group = sc.nextInt();
		System.out.println("번호(숫자만) : ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.println("성별(M/F) : ");
		char gender = sc.nextLine().charAt(0);
		System.out.println("성적(소수점 아래 둘째 자리까지) : ");
		double score = sc.nextDouble();

		String result = gender=='M'?"남":"여";
		System.out.println(grade+"학년 "+group+"반 "+number+"번 "+name+" "+result+"학생의 "+"성적은 "+score+"이다." );

	}
	
	public void practice6(){
		Scanner sc = new Scanner (System.in); 
		
		System.out.println("나이 : ");
		int age =sc.nextInt();
				
		System.out.println(age<=13?"어린이":age>19?"성인":"청소년");
		
	}
	
	public void practice7(){
		Scanner sc = new Scanner (System.in); 
		
		System.out.println("국어 : ");
		int num1 = sc.nextInt();
		System.out.println("영어 : ");
		int num2 = sc.nextInt();
		System.out.println("수학 : ");
		int num3 = sc.nextInt();

		int sum = (num1+num2+num3);
		
		
		System.out.println("합계 : "+sum);
		System.out.println("평균 : "+sum/3.0);
		System.out.println(num1>=40&&num2>=40&&num3>=40&&sum>=60?"합격":"불합격");
		
	}
	
	public void practice8(){
		Scanner sc = new Scanner (System.in); 
		
		System.out.println("주민번호를 입력하세요(- 포함) : ");
		char ch = sc.nextLine().charAt(7);
		
		System.out.println(ch%2==1?"남자":"여자");

	}
	
	public void practice9(){
		Scanner sc = new Scanner (System.in); 

		System.out.println("정수1 : ");
		int num1 = sc.nextInt();
		System.out.println("정수2 : ");
		int num2 = sc.nextInt();
		System.out.println("입력 : ");
		int num3 = sc.nextInt();

		System.out.println(num3<=num1||num3>num2?"true":"false");
		
	}
	
	public void practice10(){
		Scanner sc = new Scanner (System.in); 

		System.out.println("입력1 : ");
		int num1 = sc.nextInt();
		System.out.println("입력2 : ");
		int num2 = sc.nextInt();
		System.out.println("입력3 : ");
		int num3 = sc.nextInt();

		System.out.println(num1==num2&&num2==num3?"true":"false");
	}
	
	public void practice11(){
		Scanner sc = new Scanner (System.in); 
		
		System.out.println("A사원의 연봉 : ");
		int a = sc.nextInt();
		System.out.println("B사원의 연봉 : ");
		int b = sc.nextInt();
		System.out.println("C사원의 연봉 : ");
		int c= sc.nextInt();

		double a1 =a*1.4;
		double c1 =c*1.15;
		
		System.out.println("A사원의 인센티브포함 연봉 : "+a1);
		System.out.println(a1>=3000?"3000 이상":"3000 미만");
		System.out.println("A사원의 인센티브포함 연봉 : "+b);
		System.out.println(b>=3000?"3000 이상":"3000 미만");
		System.out.println("A사원의 인센티브포함 연봉 : "+c1);
		System.out.println(c1>=3000?"3000 이상":"3000 미만");
		
	}
	
}
