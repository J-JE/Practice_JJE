package com.uni.opertaor;

import java.util.Scanner;

public class E_Logical {
	/*
	 * * 논리 연산자
	 * - 두 논리값을 연산하는 연산자 
	 * - 논리 연산자의 결과값 또한 논리값
	 * 
	 * 논리값 && 논리값 : 왼쪽, 오른쪽 둘 다 true일 경우 true (AND) 이고 ,  이면서 
	 * 논리값 || 논리값 : 왼쪽, 오른쪽 둘 중에 하나라도 true일 경우 true (OR) 이거나, 또는 
	 */

	public void method1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수하나 입력 : ");
		
		int num = sc.nextInt();
		
		boolean result;
		//사용자가 입력한 num 값이 1이상이고 100이하인가요?
		//result = (1 <= num <=100)
		result = (num >= 1) && (num <= 100);
		
		System.out.println("사용자가 입력한 num 값이 1이상이고 100이하의 값인가요 ? " + result);

	}
	
	public void method2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자하나 입력 : ");
		
		char ch = sc.nextLine().charAt(0);
		
		//char형은 실제로 정수형이다.
		//'A'~'Z' 실제로 컴퓨터에서는 65~90 까지의 숫자가 연달아 나열
		
		boolean result = (ch >='A') && (ch <= 'Z');
		
		System.out.println((int)ch);
		System.out.println("사용자가 입력한 문자가 영어 대문자입니까 ? "+ result);

		
	}
	
	public void method3() {
		
		//사용자가 입력한 문자가 y또는 Y인지 확인하기
		Scanner sc = new Scanner(System.in);
		System.out.println("정수하나 입력 : ");
		
		char ch = sc.nextLine().charAt(0);
		
		boolean result = ch == 'y' || ch == 'Y';
		
		System.out.println("사용자가 입력한 문자가 y 또는 Y 입니까 " + result);
		
	}
	/*
	 *  && : 두 개의 조건이 모두 true 여야 결과값이 true이다. (AND)
	 *  
	 *  true && true 	=> true
	 *  true && false 	=> false
	 *  false && true	=> false
	 *  false && false 	=> false
	 *  
	 *  --> && 연산자를 기준으로 앞의 결과가 false값이 나온다면 뒤의 조건은 굳이 실행하지 않는다. 
	 *  
	 *  || : 두 개의 조건이 하나라도 true라면 결과값이 true이다. (OR)
	 *  
	 *  true || true 	=> true
	 *  true || false 	=> true
	 *  false || true	=> true
	 *  false || false	=> false
	 * 
	 * --> || 연산자를 기준으으로 앞의 결과가 true가 나온다면 뒤의 조건은 굳이 실행하지 않는다. 
	 */

	public void method4() {
		int num = 10;
		
		System.out.println("&& 연산전 num 값 : " + num);
		
		boolean result1 = (num <5 ) && (++num > 0); //숏컷으로 뒤에 값은 계산도 안함
		
		System.out.println(result1);
		System.out.println("&& 연산후 num 값 : " + num); //10
		
		System.out.println("==============================");
		
		boolean result2 = (num < 20) || (++num >0 ); //|| 연산자를 기준으로 뒤에 있는 연산자는 계산도 안함 (숏컷연산)
		
		System.out.println(result2);
		System.out.println("|| 연산후 num 값 : " + num); //11
	}
}
