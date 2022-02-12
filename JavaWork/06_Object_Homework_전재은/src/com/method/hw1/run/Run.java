package com.method.hw1.run;

import java.util.Scanner;

import com.method.hw1.controller.NonStaticSample;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.
		NonStaticSample sample = new NonStaticSample();
		System.out.print("랜덤값 : ");
		sample.printLottoNumbers();
		System.out.println();
		
		//2.
		System.out.print("a문자 5개 출력 : ");
		sample.outputchar(5,'a');//매개변수의 타입과 순서에 유의
		System.out.println();
		
		/* 사용자에게 값 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.println("문자 입력 : ");
		char ch = sc.next().charAt(0);
		System.out.println("숫자 입력 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		System.out.print(ch+"문자 "+num+"개 출력 : ");
		sample.outputchar(num,ch);//매개변수의 타입과 순서에 유의
		System.out.println();
		*/
		
		//3.
		System.out.print("랜덤 영문자 출력 : ");
		char alphabette = sample.alphabette();
		System.out.println(alphabette);
		
		//4.
		System.out.print("apple의 2번 4번 인덱스 사이의 값 출력 : ");
		String result = sample.mySubstring("apple", 2, 4);
		System.out.println(result);
		
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("문자 입력 : ");
		String str = sc.nextLine();
		System.out.println("인덱스1 입력 : ");
		int index1 = sc.nextInt();
		System.out.println("인덱스2 입력 : ");
		int index2 = sc.nextInt();
		sc.nextLine();
		
		System.out.println(str+"의 "+index1+"번 "+index2+"번 인덱스 사이의 값 출력");
		String result = sample.mySubstring(str, index1, index2);
		System.out.println(result);
		*/
	}

}
