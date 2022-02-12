package com.uni.first;//유사한 클래스들 묶는 패키지
//한줄
/*영역, 전체주석 -> 글을 적고 범위를 잡아서 컨트롤 + 시프트 + / */
/**
 * 클래스 :
 * 최초 작성자 :
 * 설명 :
 * 
 * 
 * **/

//crtl+z 실행을 뒤로 back!
//ctrl+y 실행 앞으로
//ctrl+s 저장
public class HelloWorld { //클래스
	//public : 메임 메소드는 외부에서 호출 할 수 있다.는 뜻
	//static : 객체를 생성하지 않고도 실행 시킬 수 있다.
	//void : 반환되는 값이 없다.
	//String[] args : 스트링 배열로 인자를 받겠다.
	public static void main(String[] args) { //실행 메서드
		// TODO Auto-generated method stub
		System.out.println("Hi"); //sysout 컨트롤 스페이스 동시에 클릭
		
		
		
//		System.out.println(args[0]);
//		System.out.println(args[1]);
		
		System.out.println("안녕하세요");
		System.out.print("안녕하세요");
		System.out.print("반갑습니다\n"); // \n-> 줄바꿈
		System.out.println("안녕하세요");
	}

}
