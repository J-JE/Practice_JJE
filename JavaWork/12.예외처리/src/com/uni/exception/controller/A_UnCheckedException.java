package com.uni.exception.controller;

import java.util.Scanner;

public class A_UnCheckedException {
	// - 예외(Exception) : 소스 코드 수정으로 해결 가능한 에러

	// RuntimeException이란 : 미리 정의 되어 있고 이들이 명시하는 예외 상황은
	//						프로그램의 종료로 이어지는 것이 자연스러운 경우가 많다.
	//						(하!지!만! 예외처리를 통해 프로그램이 종료되지 않게 처리 할 수 있다.)
	
	
	 // - 예외 처리 방법
	 // 	1. if문 : 간단한 예외 처리시
	 //				 (장점은 프로그램이 종료되지 않고 그 예외 상황에 있어서는 if문이
	 //				  실행되지 않게 하여 프로그램의 흐름을 조절할 수 있다.)
	 //				 (단점은 if문이 너무 자주 혹은 깊이 사용되면 그게 예외 상황을 처리하는 것인지
	 //				  프로그램 상의 주 흐름 코드인지가 구분이 안된다.)
	 //
	 //		2. try-catch문 : 예외상황이 발생할 수 있는 지역에 한해서 예외 처리를 하고
	 //						어떻게 처리할지도 결정
	 //						a. try블록 안은 하나의 일의 단위(트랜잭션)이다.
	 //						   예외 상황이 발생하는 부분
	 //						b. catch 블록의 ()안은 try블록 안에서 발생한 예외클래스의
	 //						   인스턴스 참조변수값(객체의 주소값)이 넘어온다.(JVM이 해줌)
	 //
	 //     3. throws : 예외처리를 하지 않고 자신을 호출한 상위 메소드에게 처리를 위임
	 //     			main()메소드까지 위임하고 나서도 throws를 하게 되면
	 //     			마지막엔 JVM이 예외 처리를 함
	 //      
	 //      
	 //   RuntimeException의 후손들
	 // - ArrayIndexOutOfBoundsException : 배열의 접근에 잘못된 인덱스 값을 사용하는 예외상황 --> 개발자가 실수 (코드 해결하면됨)
	 // - ClassCastException : 허용할 수 없는 형변환이 진행되는 예외 상황 --> 개발자가 실수 (코드 해결하면됨)
	 // - NegativeArraySizeException : 배열 선언 과정에서 배열의 크기를 음수로 지정하는 예외상황 --> 개발자가 실수 (코드 해결하면됨)
	 // - NullPointerException : 참조변수가 null로 초기화 된 상황에서 메소드를 호출하는 예외상황 --> 개발자가 실수 (코드 해결하면됨)
	 // - ArithmeticException : 나누기 연산에서 부모가 0인 경우 발생하는 예외 상황 --> 개발자가 실수 
	 //
	 //--> 이러한 RuntimeException 관련된 예외는 충분히 예측가능한 상황에 있어서 
	 //    아예 애초에 예외가 발생이 안되게끔 if문 조건으로 충분히 처리 가능 
	
	private Scanner sc = new Scanner(System.in);
			
	public void method1() {
		
		System.out.println("정수1 : ");
		int num1 =sc.nextInt();
		
		System.out.println("정수2 : ");
		int num2 =sc.nextInt();
		
		//int result = num1/num2; 사용자가 num2에 0을 입력하면 비정상종료 (Exception in thread "main" java.lang.ArithmeticException: / by zero)
		
		int result =0;
		if(num2!=0) {//애초에 예외가 발생할 일이 없게 if문으로 조건검사
			result = num1/num2;
		}
		System.out.println(result);
		
		
		// 예외 처리 : 예외가 발생했을 때 처리하는 구문을 작성해놓는것!
		/*
		 * * try catch 방법
		 * 
		 * try {
		 * 		예외가 발생될 수 있는 구문;
		 * 
		 * }catch(발생될예외클래스 매개변수) {
		 * 		해당 예외가 발생되는 경우 처리할 구문;
		 * 
		 * }
		 */
		
		int result1 = 0;
		try{
			result1 = num1/num2;
			System.out.println(result1);
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}

	}
	
	public void method2() {
		// - NegativeArraySizeException : 배열 선언 과정에서 배열의 크기를 음수로 지정하는 예외상황 --> 개발자가 실수 (코드 해결하면됨)

		System.out.println("배열의 길이 : ");
		int num= sc.nextInt();
		
//		if(num>0) {
//			int arr[] = new int[num];
//		}else {
//			System.out.println("양수를 입력하세요.");
//		}
		
		try {
			int arr[] = new int[num];
		}catch(NegativeArraySizeException n){
			System.out.println("양수를 입력하세요.");
		}
	}
	
	public void method3() {
		try {
			// - ClassCastException : 허용할 수 없는 형변환이 진행되는 예외 상황 --> 개발자가 실수 (코드 해결하면됨)
	
			Object obj = 'a'; //char -> (autoBoxing) -> Character -> (다형성) -> Object
//			String str =(String)obj;//컴파일에러 X, 런타입 에러 O
			String str = String.valueOf(obj);
			
			// - ArrayIndexOutOfBoundsException : 배열의 접근에 잘못된 인덱스 값을 사용하는 예외상황 --> 개발자가 실수 (코드 해결하면됨)
			int[] arr = new int[2];
			arr[0] = 1;
			arr[1] = 2;
//			arr[2] = 3;//런타임 에러 O
			
			// - NullPointerException : 참조변수가 null로 초기화 된 상황에서 메소드를 호출하는 예외상황 --> 개발자가 실수 (코드 해결하면됨)
			String str1 = null;
			int lenght = str1.length(); //런타임 에러 O
		
//		}catch(ClassCastException e) {
//			System.out.println("잘못 형변환했네~~");
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("배열 크기를 잘못 지정했네~~");
//		}catch(NullPointerException e) {
//			System.out.println("객체 없이 메소드를 쓰려고 하네~~");
//		}
		//Multi catch문 -> 나란히 작성하는 경우 형제레벨만 함께사용
		}catch(ClassCastException|ArrayIndexOutOfBoundsException|NullPointerException e) {
			e.printStackTrace(); //유형 + 에러발생경로 + 에러메세지
			
			System.out.println(e.getMessage()); //에러메세지
			System.out.println(e.toString()); //어떤 유형인지 + 메세지
//			System.exit(0); //프로그램 강제종료시키기
//			return;
		}finally {
			System.out.println("여전히 실행하네~~~"); //return이 돼도 실행하고 종료
		}
		System.out.println("프로그램종료");
	}
}
