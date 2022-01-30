package com.uni.chap04_field.model.vo;

public class FieldTest4 {
	/*
	 *  * 상수 필드
	 *  
	 *  public 접근제한자에 static과 final 예약어를 함께 사용하는 것을 상수필드라고 한다.
	 *  static final 순서 상관 없음
	 *  
	 *  static - 공유의 개념
	 *  final - 한번 지정된 값 변경 X
	 * 
	 *  static final - 반드시 선언과 동시에 값 초기화 해야됨
	 *  왜냐면 static 키워드가 붙은 변수는 전부 static 영역에 저장되기 때문에
	 * 
	 *  프로그램 시작시 값이 저장되면 더이상 변경되지 않고 공유하면서 사용할 목적으로 사용된다.
	 */

	
	public static final int NUM = 1;//상수필드는 무조건 초기화
}
