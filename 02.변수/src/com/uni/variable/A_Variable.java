package com.uni.variable;//A_Variable 이 다른 패키지이기 때문에 같은 클래스명을 적어도 에러가 나지 않는다.

public class A_Variable {
	// 변수란 : 어떠한 값을 메모리에 기억하기 위한 공간이다 (박스같은개념)
		/* 변수를 사용하는 이유 :
		 * 변수는 우선적으로 값에 의미를 부여하기위한 목적으로 사용 한다. (가독성이 좋아짐)
		 * 또한 한번값을 저장해두고 계속 사용할 목적으로 사용된다. 
		 * 
		 * -> 유지보수를 쉽게 하기위한 목적
		*/

	public void printValue() {
		System.out.println("변수 사용전");
		System.out.println( 2 * 3.14592648347338 * 10 );
		System.out.println( 3.14592648347338 * 10 * 10 );
		System.out.println( 3.14592648347338 * 10 * 10 * 20);
		System.out.println( 4 * 3.14592648347338 * 10 * 10);

		double pi = 3.14592648347338;
		int r = 10;
		int h = 20;
		
		System.out.println("변수 사용후");
		System.out.println( 2 * pi * r );
		System.out.println( pi * r * r );
		System.out.println( pi * r * r * h);
		System.out.println( 4 * pi * r * r);
	}
	
	public void declareVariable() {
		/*
		 * 변수의 선언 (저장할 값을 기록하기 위한 변수를 메모리 공간에 확보해놓는 과정) == 변수(박스)만들겠다!! 
		 * [표현법] 자료형 변수명;
		 * 
		 * 자료형 : 어떤 값을 담아낼지, 어떤 크기의 값을 담아낼지에 대해 변수(박스)의 크기 및 모양을 정하는 부분
		 * 변수명 : 변수(박스)의 이름을 정하는 부분 (의미부여) -> 여기서 지정한 이름으로 앞으로 호출
		 * 
		 * 주의할점
		 * - 변수명은 반드시 첫 문자가 소문자여야된다. 
		 * - 하지만 여러단어로 엮어 있는경우 연결되는 단어의 첫글자는 대문자 
		 * - 동일한 변수명으로 선언 불가
		 * - 해당 영역({})에 선언한 변수는 해당 지역({}) 안에서만 꺼내 쓸수 있다. (다른 메소드에서는 사용 불가)
		 *   == 지역변수 개념
		 * 
		 */
		
		//자료형의 개념
		
		//1. 논리형
		boolean isTrue; //값이 true, false, 1, 0 //1byte =8bit
		
		
		//2. 숫자형
		//2_1 정수형
		
		byte bNum; //1byte
		short sNum; //2byte
		int iNum; //4byte -->정수형중에 가장 대표적인 자료형(기본형) -21억~21억 xxx 까지 값이 담기는 자료형
		long lNum; //8byte
		
		
		//2_2 실수형
		float fNum; //4byte
		double dNum; //8byte -->실수형 중에서 가장 대표적인 자료형(기본형) 더 넓은 범위를 표현
		
		//3.문자형
		char ch; //2byte
		
		//-------------여기까지가 기본자료형(8개)
		
		//4.문자열(참조자료형)
		String str;
		
		/* 변수에 값 대입
		 * 위에서 값을 담기위한 공간을 확보했다면 해당 변수에 값 대입 가능 
		 * 
		 * [표현법] 변수명 = 값;
		 * */

		isTrue = true;
		
		bNum = 1;
		sNum = 2;
		iNum = 5;
		lNum = 8L; //L을 붙여야함
		
		fNum = 4.0f; //반드시 f를 붙여야함
		dNum = 8.0; //d를 붙이지 않아도 된다.
		
		ch = 'A'; //따옴표를 사용해서 값 대입
		//ch = 'ABC'; //문자에는 한 문자가 저장됨
		
		ch = '강';
		str = "ABC"; //쌍따옴표를 이용해서 값대입
		str = "A"; //한개의 문자만 써도 쌍따옴표 이용
		
		// 변수에 담긴 값 호출하여 출력
		System.out.println("isTrue 의 값 "+ isTrue);
		System.out.println("bNum 의 값 "+ bNum);
		System.out.println("sNum 의 값 "+ sNum);
		System.out.println("iNum 의 값 "+ iNum);
		System.out.println("lNum 의 값 "+ lNum);
		System.out.println("fNum 의 값 "+ fNum);
		System.out.println("dNum 의 값 "+ dNum);
		System.out.println("ch 의 값 "+ ch);
		System.out.println("str 의 값 "+ str);

	}
	
	public void initVariable() {
		/*
		 * 변수 선언과 동시에 초기화(=값대입) 
		 * [표현법] 자료형 변수명 = 값;
		 * 
		 * */
		
		boolean isTrue = true;
		
		byte bNum = 1;
		short sNum = 2;
		int iNum = 5;
		long lNum = 8L; //L을 붙여야함
		
		float fNum = 4.0f; //반드시 f를 붙여야함
		double dNum = 8.0; //d를 붙이지 않아도 된다.
		
		char ch = 'A'; //따옴표를 사용해서 값 대입
		//ch = 'ABC'; //문자에는 한 문자가 저장됨
		
		ch = '강';
		String str = "ABC"; //쌍따옴표를 이용해서 값대입
		str = "A"; //한개의 문자만 써도 쌍따옴표 이용
		
		// 변수에 담긴 값 호출하여 출력
		System.out.println("isTrue 의 값 "+ isTrue);
		System.out.println("bNum 의 값 "+ bNum);
		System.out.println("sNum 의 값 "+ sNum);
		System.out.println("iNum 의 값 "+ iNum);
		System.out.println("lNum 의 값 "+ lNum);
		System.out.println("fNum 의 값 "+ fNum);
		System.out.println("dNum 의 값 "+ dNum);
		System.out.println("ch 의 값 "+ ch);
		System.out.println("str 의 값 "+ str);
		
		//변수명명규칙
		
		int number;

		//1) 변수명이 같으면 에러발생 
		//int number;


		//2) 대소문자구분
		int numBer;

		//3) 예약어(이미 자바에서 사용되고 있는 키워드)사용하면 에러 발생 
		//int true;
		//int class;
		//int void;

		//4) 숫자 가능 (단, 숫자로 시작하는것은 안됨)
		//int 1age;

		//5)특수문자가능(단, _ $ 이외의 특수문자는 불가능)
		int number_1;
		int number$2;

		//int number#1;


		//6) 여러단어로된 변수명일경우, 붙여쓰고 연결되는 단어의 첫글자 대문자
		String username;//관례상 틀림
		String userName;//관례상 맞는표현

		String 이름;//한글도 잘 사용 하지않는다. 

		/*
		 * 정리 
		 * 변수 : 리터럴(값) 을 저장하기위한 공간(메모리에 값을 기록하기 위한 공간)
		 * 값 : 프로그램상에 필요한 명시적인 값 / 또는 사용자가 마우스 또는 키보드로 입력한 값
		 * 
		 * 
		 * */
		
	}
	
	public void test() {
		
		boolean v1 = false;
	 	System.out.println(v1);	// false 
	 	char v2 = '가';
		System.out.println(v2);	// 가
		double v3 = 3.14;
		System.out.println(v3);	// 3.14
		int v4 = 30;
		System.out.println(v4);	// 30
		String v5 = "aaa";
		System.out.println(v5);	// aaa
	}
	
}
