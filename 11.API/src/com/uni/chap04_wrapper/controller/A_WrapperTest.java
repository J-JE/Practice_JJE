package com.uni.chap04_wrapper.controller;

public class A_WrapperTest {
	
	// Wrapper 클래스
	// --> 기본자료형을 객체로 포장해주는 클래스가 래퍼 클래스(Wrapper 클래스)이다.
	
	// - 기본 자료형으로 사용을 해도되지만 프로그램에 따라서 해당 기본 타입을 객체로 취급해야 되는 경우가있다.
	// ex) 메소드의 매개변수로 객체 타입만이 요구될 때
	//     다형성을 적용하고 싶을 때
	//     Object에 있는 메소드를 사용하고 싶을 때

	//		위와 같은 경우 기본자료형의 데이터로는 그대로 사용할 수 없기 때문에 객체로 변환한 후에 작업을 수행해야한다.

	//	기본자료형		  Wrapper클래스
	//	boolean  <-->	Boolean
	//	char	 <-->	Character
	//	short	 <-->	Short
	//	byte	 <-->	Byte
	// 	int		 <-->	Integer
	//	long	 <-->	Long
	//	float	 <-->	Float
	//	double	 <-->	Double

	public void method1() {
		
		//Boxing : 기본자료형 -> Wrapper 클래스 자료형으로 바꾸는 방법
		
		int num1 =10;
		int num2 =15;
		
		//1. 객체생성을 통해 하는 방법
		Integer i1 = new Integer(num1);
		Integer i2 = new Integer(num2);
		System.out.println(i1);
		System.out.println(i2);
		
		System.out.println(i1 == i2);
		
		System.out.println(i1.equals(i2));
		System.out.println(i1.compareTo(i2)); //두 값을 비교해서 앞쪽이 크면 1, 뒤쪽이 크면-1, 같으면 0반환
		
		//2. 객체생성하지않고 바로 대입하는 방법 (AutoBoxing)
		
		//Integer i3 ="123"; -->다른 타입이라서 불가능
		Integer i3 = 123; //같은 타입으로만 가능
		Integer i4 = new Integer("123"); //객체 생성을 통해서 Boxing 하게되면 문자열도 가능하다. -> 문자열을 숫자화 시켜서 ("123A"는 안됨)
		System.out.println(i4);
		
		// UnBoxing : Wrapper 클래스 -> 기본자료형으로 바꾸는 방법
		
		//1. Wrapper 클래스의 xxxValue() 를 통해 변환
		int num3 = i1.intValue();
		int num4 = i2.intValue();
		
		System.out.println(num3+num4);
		
		//2. 객체생성하지않고 바로 대입하는 방법 (AutoUnBoxing)
		
		int num5 =/*(int)*/i1;
		System.out.println(num5);
		
		test(i2);
		test1(i2);
		test2(i2);
	}

	private void test2(Object num) {
		System.out.println(num);
		
	}

	private void test1(int num) {
		System.out.println(num);
		
	}

	private void test(Integer num) {
		System.out.println(num);
	}
}
