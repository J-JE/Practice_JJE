package com.uni.chap03_override.run;

import com.uni.chap03_override.model.vo.Book;

public class Run {

	public static void main(String[] args) {

		
		Book bk1 = new Book("언어의온도","이기주",20000);
		Book bk2 = new Book("개미","베르나르베르베르",10000);
		
		System.out.println(bk1.information());
		System.out.println(bk2.information());
		
		System.out.println(bk1.toString());
		System.out.println(bk1/*.toString()*/); //출력문에 레퍼런스 풀력시 JVM이 자동으로 레퍼런스.toString() 호출해준다.
		
		//모든 클래스는 Object클래스의 후손이다. 즉 최상위 클래스는 Object이다.
		//->Object에 있는 모든 메소드들은 재정의를 할 수 있다.

		//1.toString()
		//오버라이딩 전 : Object 클래스의 toString()이 실행 --> 풀패키지명 @ 해쉬코드 16진수 값이 리턴 
		//오버라이딩 후 : Book 클래스에 있는 toString()실행 --> 내가 재정의 한대로 해당 객체가 가지고있는 필드값에 대한 정보를 리턴.

		System.out.println(bk2);
		
		//-------------------------------------equals(),hashCode()
		//2.equals()-------------------------------------------------------------------------------------
		
		
		Book bk3 = new Book("언어의온도","이기주",20000); //bk1과 동일한 필드값을 가진 bk3 객체를 생성
		
		System.out.println("bk1과 bk3가 같은 책입니까? "+(bk1==bk3)); //false : 주소값 비교이기 때문에
		System.out.println("bk1과 bk3가 같은 책입니까? "+(bk1.equals(bk3))); //false : 주소값 비교이기 때문에
		
		//오버라이딩 전 : Object 클래스의 equals 메소드가 실행 -> 두주소값을 비교 
		//오버라이딩 후 : 두객체의 주소값 비교가 아닌 실제 필드 값들이 같은경우 true를 반환하도록 재정의 
		
		//동등객체 : 실제 필드값은 같지만 해쉬코드값이 다른경우 
		//동일객체 : 실제 필드값도 같고 해쉬코드 값도 같은경우 --> 동일 객체라는건 중복된다는 소리

		//3.hashCode()-------------------------------------------------------------------------------------
		System.out.println("bk1의 해쉬코드 "+bk1.hashCode());
		System.out.println("bk1의 해쉬코드 "+bk2.hashCode());
		System.out.println("bk1의 해쉬코드 "+bk3.hashCode());
		
		
		//오버라이딩 전 : Object 클래스의 hashCode() 메소드 실행 --> 해당 객체의 실제 주소값을 10진수로 계산한 결과 
		//오버라이딩 후 : 두객체의 실제주소값을 가지고 작업 하지않고 두객체의 실제 멤버의 값들이 같은경우 같은 해쉬코드값이 나오도록 재정의

	}

}
