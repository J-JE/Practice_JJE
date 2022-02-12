package com.uni.chap01_string.run;

public class Run {

	public static void main(String[] args) {
		// String 클래스의 원리
		// String a 값에 게속 값을 더해가는 경우 새로운 String 클래스가 만들어진다.
		
		// StringBuffer 나 StringBuilder의 원리
		
		// 새로운 객체를 생성시키지 않고, 기존에 있는 객체의 크기를 증가시키면서 값을 더한다.
		// * 응답시간
		// String > StringBuffer > StringBuilder
		// * 메모리
		// String > StringBuffer == StringBuilder
		
		/*
		 * StringBuffer나 StringBuilder는 mutable이다.(가변)
		 * 16개의 문자를 저장할 수 있는 공간이 생성된다.
		 * 처음에 어떤 크기로 할지 정해서 생성할 수도 있다.
		 */
		
		//Run.method1();
		new Run().method2();
		
	}

	private void method2() {
		
		String str = "abc";
		
		//charAt(해당인덱스) :  문자뽑아내기 
		System.out.println(str.charAt(2));
		
		//concat: 문자열 합치기
		System.out.println(str.concat("def"));
		
		//contains : 포함 여부확인
		System.out.println(str.contains("ab"));
		
		//equals : 동등여부 확인 (문자값이 일치)
		System.out.println(str.equals("abc"));
		
		//length() : 문자열길이 (문자열에 포함된 문자 갯수)
		System.out.println(str.length());
		
		//split : 문자 구분(특수기호를 기준으로 각각을 문자열 배열로 쪼개서 반환하는 메소드)
		
		String str1 = "a,bc,de";
		String[] strArr = str1.split(",");
		
		for(String arr : strArr) {
			System.out.println(arr);
		}
		
		
		String strCase1 = "Abc";
		String strCase2 = "aBc";
		
		//toUpperCase: 대문자로
	    //tolowerCase: 소문자로 
	    //equalsIgnoreCase : 대소문자 상관없이 문자열 비교 (boolean)
		System.out.println(strCase1.toUpperCase());
		System.out.println(strCase2.toLowerCase());
		
		System.out.println(strCase1.equalsIgnoreCase(strCase2));
		
		//trim : 문자열 양쪽 공백제거
		String str2 = "        ab  c               ";
		System.out.println(str2);
		System.out.println(str2.trim());

	}

	private static void method1() {
		// TODO Auto-generated method stub

		
		//1. 문자열을 리터럴로 생성
		String str = "abc";
		String str1 = "abc";
		String str2 = "def";
		//2. 문자열을 new 생성자()로 생성
		String str3 = new String("abc");
		String str4 = new String("abc");
		
		
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		
		System.out.println(str.hashCode());
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		
		System.out.println(System.identityHashCode(str));
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		
		str3 +="z";//문자열값 수정이 불가능하다. immutable(불변)
		System.out.println(System.identityHashCode(str3));
		
	}

}
