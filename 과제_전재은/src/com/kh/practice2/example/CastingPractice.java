package com.kh.practice2.example;

import java.util.Scanner;

public class CastingPractice {

	public void method1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		System.out.println("A Unicode : "+ (int)ch);
		
	}
	
	public void method2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 : ");
		double d1 =sc.nextDouble();
		System.out.println("영어 : ");
		double d2 =sc.nextDouble();
		System.out.println("수학 : ");
		double d3 =sc.nextDouble();

		System.out.printf("총점 : %d\n",(int)(d1+d2+d3));
		System.out.printf("평균 : %d",((int)(d1+d2+d3))/3);
		
	}
	
	public void method3() {
		
		int iNum1 = 10;
		int iNum2 = 4;
		
		float fNum = 3.0f;
		
		double dNum = 2.5;
		
		char ch = 'A';
		
		System.out.println( iNum1/iNum2 ); // 2
		System.out.println( (int)dNum ); // 2
		
		System.out.println( iNum2*dNum ); // 10.0
		System.out.println( (double)iNum1 ); // 10.0
		
		System.out.println( (double)iNum1/iNum2 ); // 2.5
		System.out.println( dNum ); // 2.5
		
		System.out.println( (int)fNum ); // 3
		System.out.println( iNum1/(int)fNum ); // 3
		
		System.out.println( iNum1/fNum );// 3.3333333
		System.out.println( (double)iNum1/fNum ); // 3.333333333333335
		
		System.out.println( ch ); // 'A'
		System.out.println( (int)ch ); // 65
		
		System.out.println( ch+iNum1 ); // 75 ch앞에(int)는 빼도 됨 int값이랑 산술해서 자동 형변환
		System.out.println( (char)(ch+iNum1) ); // 'K'		
		
	}
	
}
