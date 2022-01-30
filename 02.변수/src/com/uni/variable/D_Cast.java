package com.uni.variable;

public class D_Cast {
	// 형변환 : 값의 자료형을 바꾸는 것
			/*
			 *  * 컴퓨터에서의 값 처리 규칙 (즉, 형 변환이 필요한 상황)
			 *  1. 대입 연산자를 기준으로 왼쪽과 오른쪽은 같은 자료형이여야된다. 
			 *  --> 즉, 같은 자료형에 해당하는 값만 대입이 가능하다. 다른 자료형의 값을 대입하고자 한다면 형변환이 필수
			 *      자료형 변수명 = (자료형)값;
			 *  
			 *  2. 같은 자료형끼리만 계산이 가능 --> 계산 결과도 같은 자료형으로 나옴!
			 *     값 + 값		=> 두 값이 같은 자료형이여야됨!
			 *  
			 *  * 형 변환의 종류
			 *  1. 자동(묵시적) 형변환	--> 자동으로 형변환이 이루어져 우리가 형변환을 시켜줄 필요 없다. 
			 *  
			 *  2. 강제(명시적) 형변환 --> 자동으로 형변환이 안되서 우리가 직접 형변환을 해줘야됨
			 *  
			 *     [표현법] (바꿀자료형)값
			 *     
			 *     (바꿀자료형) 을 cast연산자 즉, 형변환 연산자라고 함
			 *  
			 *  * 주의사항
			 *  boolean은 형변환이 불가하다 오직 true, false의 값만을 가질 수 있다. 
			 *  
			 */
	
	public void rule1() {
		/* 자동형변환 :
		 * 값의 범위가 작은 자료형과 큰자료형의 연산(대입, 계산등) 컴파일러가 자동으로 범위가 작은 자료형을 큰자료형으로 처리 해준다.
		 * */
		
		short s = 1;
		int i = s; //분명 대입연산자를 기준으로 왼쪽과 오른쪽의 자료형이 다르지만 문제 없음.
		
		//1. int(4byte) -> double(8byte)
		int i1 = 12;
		System.out.println("i1 : "+i1);
		
		double d1 = i1;
		System.out.println("d1 : "+ d1);
		
		int i2 = 12;
		double d2 = 3.3;
		double result = /*(double)*/ i2 + d2; //12.0 + 3.3 -> 15.3
		System.out.println("result : "+ result);//int 형과 double 형의 연산의 결과가 double형으로 자동으로 변환
		
		//2. int(4byte) -> long(8byte)
		int i3 = 3333;
		long l3 = i3;
		
		long result1 = /*(long)*/i3 +l3;
		System.out.println("result1 : "+result1);
		
		int i4 = 2147483647;
		long l4 = 1000000000L;
		
		long result2 = /*(long)*/i4 +l4;
		System.out.println("result2 : "+result2);
		
		//3.float(4byte) -> double(8byte)
		float f5 = 1.0f;
		double d5 = f5;
		
		System.out.println("f5 : "+ f5);
		System.out.println("d5 : "+ d5);
		
		//4.long(8byte) -> float(4byte)
		//크기는 long 형이 더 크지만 float 형으로 자동 형변환이 가능한 이유는 표형가능한 수의 범위가 float 형이 더크기 때문이다.
		long l6 =1000000000L;
		float f6 = l6;
		System.out.println(f6);
		
		//5.char(2byte) -> int(4byte)
		int num = 'A';
		System.out.println(num);
		//char -> int 형으로 변환이 가능한 이유는
		//char 의 자료형에 값(숫자)가 들어오면 해당숫자와 일치하는 문자를 유니코드에서 찾아서 출력한다.
		
		char ch = 65;
		System.out.println("ch : "+ch);
		
		//ch = -65; //char 형의 음수값 저장 불가 : 값의 범위가 0~6553 까지이기 때문이다.
		
		byte b2 = 1;
		byte b3 = 10;
		
		int result3 = b2+ b3; //->byte 나 short 연산시 무조건 int로 저리, 따라서 (byte로 바꾸려면)강제형변환이 필요하다.
		byte result4 =(byte)(b2 + b3);
		System.out.println(result4);
		
		/* 
		 * int형 리터럴로 초기화가 가능한 자료형
		 * byte, short, char, int
		 * -> 1) 초기화 시 입력 값을 int형 리터럴로 인식하지 않고 그냥 정수로 인식
		 *    2) 컴파일러가 저장하려는 자료형의 값의 범위와 일치하는지 검사하여
		 *       일치하면 입력값을 저장하려는 자료형으로 변환하여 저장
		 *    3) 값의 범위가 일치하지 않으면 에러 발생  
		 * -> 초기화 된 이후 위 자료형들의 연산 시 무조건 int형으로 처리
		 */
	
		// 자동형변환 : 작은 크기의 자료형이 자동으로 큰 크기의 자료형으로 바뀌는 거 (형변환 생략 가능)
		// 다른 자료형들 끼리의 연산 시 작은자료형 -> 큰 자료형으로 자동 형변환 후 연산처리됨.
	}
	
	public void rule2() {
		//강제 형변환 : 큰크기의 자료형을 작은 크기의 자료형으로 바꾸는것 ()형변환 생략이 불가능하다)
		
		//1. double(8byte) -> float(4byte)
		double d =4.0;
		//float f = d; //에러발생
		float f = (float) d;
		
		//2. double(8byte) -> int(4byte)
		int iNum =10;
		double dNum = 5.89;
		
		//int iSum = iNum + dNum; //10.0 + 5.89 -> (double형 -> int형 변수로 대입 불가능)
		
		//해결방법
		//1. 수행 결과를 int 형으로 강제 형변환
		int iSum = (int)(iNum + dNum); //실수 -> 정수 : 강제형변환 발생시 소수점 아래부분이 모두 버려짐.
		System.out.println(iSum);
		
		//2.double 형 값은 int 형으로 강제 형변환
		int iSum2 = iNum + (int)dNum;
		System.out.println(iSum2);
		
		//3.연산결과를 double 형으로 받음
		double dSum = iNum + dNum;
		System.out.println(dSum);
		
		//byte, short 연산
		byte bNum = 1;
		short sNum = 2;
		
		//byte result = bNum + sNum;
		//방법 1 : 연산 결과를  byte 또는 short 로 받고 강제 형변환
		byte bSum = (byte)(bNum + sNum);
		short sSum =(short)(bNum + sNum);
		
		System.out.println(bSum);
		System.out.println(sSum);
		//방법 2 : 실행 결과를 int 형으로 저장
		int sum2 = bNum + sNum;
		System.out.println(sum2);
		
		//데이터 손실 test
		int temp1 = 290;
		byte temp2 = (byte)temp1;
		System.out.println(temp2); //계산하기 쉽지않은 데이터 손실이 발생되므로 주의해서 사용해야한다.
		
	}
	
	public void stringTest() {
		
		//리터럴 : stringpool 에서는 이미 값이 있으면 주소를 생성하지 않는다.
		//new : 무조건 힙에 새로운 인스턴스객체 생성, 반환타입이 참조형이라 하는것은 객체의 주소를 반환 한다는 것을 의미한다.
		
		String s = "안녕하세요"; //heap (stringpool)
		String s1 = "안녕하세요"; //heap (stringpool)
		String s2 = new String("안녕하세요"); //(heap)
		
		System.out.println(System.identityHashCode(s));
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		
		System.out.println("---------------------");
		
		String t = "정지훈"; //heap (stringpool)
		String t1 = "이효리"; //heap (stringpool)
		String t2 = new String("유재석"); //heap
		String t3 = "유재석"; //heap (stringpool)
		String t4 = "이효리"; //heap (stringpool)
		
		System.out.println(System.identityHashCode(t));
		System.out.println(System.identityHashCode(t1));
		System.out.println(System.identityHashCode(t2));
		System.out.println(System.identityHashCode(t3));
		System.out.println(System.identityHashCode(t4));
		
		System.out.println("---------------------");

		System.out.println("t4 : "+ t4);
		System.out.println(System.identityHashCode(t4));
		t4 = "싹쓰리";
		System.out.println(System.identityHashCode(t4));
		t4 = "이효리";
		System.out.println(System.identityHashCode(t4));
		System.out.println("t4 : "+ t4);
		
		System.out.println("---------------------");
		System.out.println(System.identityHashCode(t2));
		t2 = "놀면뭐하니";
		System.out.println(System.identityHashCode(t2));
		t2 = new String("유재석");
		System.out.println(System.identityHashCode(t2));
		System.out.println("t2 : "+ t2);
	}
	
	/* HashCode : 객체가 메모리에 가진 해쉬 주소값을 의미 (Java)에서 가지고 있는 주소값 
	 * System.identityHashCode : 특별한 설정을 하지않은경우 hashcode와 같이 주소값을 의미 ,os(system)에서 가지고 있는 주소값 
	 */

}
