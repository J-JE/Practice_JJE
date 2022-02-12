package com.uni.chap07_method.part02_overloadingTest;

public class OverloadingTest {

	
	//오버로딩 : 한클래스 내에서 같은 메소드명으로 정의할 수 있는 방법
	public void test() {}
	
	
	/*
	public void test() {}
	 */
	
	public void test(int a) {}
	
	public void test(int a, String s) {}
	
	public void test(String s, int a) {} //순서가 다름
	
	public void test(int a, int b) {} //자료형이 다름
	
	//public void test(int c, int d) {} //--> 에러발생 매개변수명과는 상관없다
	
	public void test(int a, int b, String str) {}
	
	//public int test(int a, int b, String str) {} //--> 에러발생 반환형과는 상관없다.
	
	//private void test(int a, int b, String str) {} // --> 에러발생 접근제한자 하고는 상관없다.
	/* 결론
	 * 오버로딩 : 동일한 메소드 명을 사용하는 것  , 매개변수의 자료형과 갯수 , 순서가 다르게 작성되어야 한다. (접근제한자, 반환형은 상관없음) 
	 * */
}
