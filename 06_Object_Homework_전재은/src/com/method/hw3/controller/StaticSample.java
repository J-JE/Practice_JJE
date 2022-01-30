package com.method.hw3.controller;

public class StaticSample {

	private static String value;
	
	public StaticSample() { 
		// TODO Auto-generated constructor stub
	}
	//getter
	public static String getValue() {
		return value;
	}
	//setter
	public static void setValue(String value) {
		StaticSample.value = value;
	}
	
	/* 각 메소드에서 출력문은 존재하지 않는다.
	테스트 출력은 main 함수에서 value에 접근하여 출력*/
	
	//1. 매개변수없고 반환값도 없는 메소드
	public static void toUpper() {
		// value 필드 값을 모두 대문자로 변경 --> char 배열 응용
		
		char[] chArr =new char[value.length()];//문자열 value의 길이만큼 배열 할당
		
		for(int i=0;i<value.length();i++) {
			chArr[i]=value.charAt(i); //한글자씩 옮겨담기
			if(chArr[i]>=97&&chArr[i]<=122) {//'a'=97, 'z'=122
				chArr[i]-=32; //'A'=65, 'Z'=90 소문자와의 차 32
			}
		}
		
		value=""; //value값을 비워주고 문자를 for문을 실행해야 안겹침.
		for(int i=0;i<chArr.length;i++) {
			value+=chArr[i]; //문자 하나를 더하는게 아니라 한개씩 누적해야함
		}
		
	}
	
	//2. 매개변수가 있고 반환값이 없는 메소드
	public static void setChar(int index, char c) {
		// 전달받은 인덱스 위치의 value 값을 전달받은 문자로 변경하는 static 메소드
		char[] chArr= new char[value.length()];
		
		for(int i=0; i<value.length(); i++) {
			chArr[i] = value.charAt(i);
		}
		
		chArr[index]=c;
		
		value="";
		for(int i=0;i<chArr.length;i++) {
			value+=chArr[i];
		}
	}
	
	//3. 매개변수가 없고 반환값이 있는 메소드
	public static int valueLength() {
		// value 필드 값에 기록되어 있는 문자 갯수 리턴
		return value.length();
	}
	
	//4. 매개변수도 있고 반환값도 있는 메소드
	public static String valueConcat(String str) {
		// 문자열 값을 전달받아 value 필드 값과 하나로 합쳐서 리턴
		return value+=str;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
