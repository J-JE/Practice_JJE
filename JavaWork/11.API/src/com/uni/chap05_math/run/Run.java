package com.uni.chap05_math.run;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//상수필드
		System.out.println("파이 "+Math.PI );

		//절대값
		int num1 = -10;
		System.out.println(Math.abs(num1));
		
		//올림
		double num2 = 4.349;
		System.out.println(Math.ceil(num2));
		
		//반올림
		System.out.println(Math.round(num2));
		
		
		//버림
		System.out.println(Math.floor(num2));

		// 가장가까운정수값
		System.out.println(Math.rint(num2));

		// 제곱근(루트)
		System.out.println(Math.sqrt(num2));

		// 제곱 --> pow(대상숫자 , 지수)
		System.out.println(Math.pow(2, 10));
		

	}

}
