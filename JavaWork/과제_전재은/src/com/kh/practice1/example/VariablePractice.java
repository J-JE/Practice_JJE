package com.kh.practice1.example;

import java.util.Scanner;

public class VariablePractice {
	
	public void method1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.println("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		System.out.println("성별을 입력하세요(남/여) : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.println("키를 입력하세요(cm) : ");
		double height = sc.nextDouble();
		
		System.out.println("키 "+height+"인 "+age+"살 "+gender+"자 "+name+"님 "+"반갑습니다^^");
		
	}

	public void method2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫 번째 정수를 입력하세요 : ");
		int iNum1 = sc.nextInt();
		System.out.println("두 번째 정수를 입력하세요 : ");
		int iNum2 = sc.nextInt();
		
		System.out.printf("더하기 결과 : %d\n",iNum1+iNum2);
		System.out.printf("빼기 결과 : %d\n",iNum1-iNum2);
		System.out.printf("곱하기 결과 : %d",iNum1*iNum2);
		System.out.printf("나수기 몫 결과 : %d",iNum1/iNum2);
		
	}
	
	public void method3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가로 : ");
		double w = sc.nextDouble();
		System.out.println("세로 : ");
		double h = sc.nextDouble();
		
		System.out.printf("면적 : %.2f\n",w*h);
		System.out.printf("둘레 : %.1f\n",(w+h)*2);
		
	}
	
	public void method4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열을 입력하세요 : ");
		String str =sc.nextLine();
		
		System.out.println("첫 번째 문자 : "+str.charAt(0));
		System.out.println("두 번째 문자 : "+str.charAt(1));
		System.out.println("세 번째 문자 : "+str.charAt(2));
		
	}
}
