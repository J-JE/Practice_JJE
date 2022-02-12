package com.uni.opertaor;

public class D_Comparision {
	// 비교 연산자 (관계 연산자)
			/*
			 * - 두 값을 비교하는 연산자, 다른 말로 관계 연산자라고도 한다. 
			 * - 비교연산자는 조건을 만족하면 true(참), 만족하지 않으면 false(거짓)을 반환한다. 
			 * 
			 *  a < b   : a가 b보다 작은가 ?
			 *  a > b   : a가 b보다 큰가 ? 
			 *  a == b  : a와 b가 같은가 ? 
			 *  a != b  : a와 b가 다른가 ? 
			 *  a <= b  : a가 b보다 작거나 같은가 ? 
			 *  a >= b  : a가 b보다 크거나 같은가 ?:  
			 */

	public void method1() {
		int a = 10;
		int b = 25;
				
		System.out.println("a == b : "+ (a == b));
		System.out.println("a <= b : "+ (a <= b));
		System.out.println("a > b : "+ (a > b));
		
		
		
		boolean result = (a != b);
		System.out.println(result);
		
		
		System.out.println("a는 짝수인가? : "+ (a %2 == 0));
		System.out.println("a는 짝수인가? : "+ (b %2 == 0));
		
		System.out.println("a는 홀수인가? : "+ (a %2 == 1));
		System.out.println("a는 홀인가? : "+ (b %2 == 1));
		
		
	}
	
}
