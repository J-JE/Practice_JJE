package com.uni.chap02_encapsulation.model.vo;

public class Student {
	//필드부 
	/* 1. 필드 : 객체의 속성을 저장하기위한 공간
	 * 
	 * 
	 * 멤버변수 == 인스턴스변수 
	 * <표현법>
	 * 접근제한자 [예약어] 자료형 변수명; 
	 * 
	 * 필드부에 접근제한자는 private 으로 하는게 객체지향설계원칙 중 하나이다. --> 캡슐화
	 * */
	private String name;
	private int age;
	private double height;
	private int kor;
	private int math;
	
	
	// 생성자부 
		/*
		 * 2. 생성자 
		 * - 객체를 생성하기 위한 일종의 메소드
		 * 
		 * <표현법>
		 * 접근제한자 클래스명([매개변수]){
		 * 
		 * }
		 * 
		 * */
	public Student() {
		
		//매개변수가 없는 생성자를 기본 생성자라고 한다.(단지 생성만을 목적으로 하는 것)
		
	}
	
	// 메소드부
		/*
		 * 3. 메소드
		 * -기능을 구현하는 부분
		 * 
		 * <표현법>
		 * [접근제한자] [예약어] 반환형 메소드명 ([자료형 매개변수명]){
		 * 		//기능구현
		 * }
		 * 
		 * 
		 * */
		/* 3_1. 데이터를 기록 및 수정하는 기능을 하는 메소드 (setter메소드)
		 * 		이때 메소드는 접근가능하도록 해야하기 때문에 public 접근제한자를 사용해야함.
		 * 
		 * public void setName(String newName){
		 * 		//매개변수 : 해당 메소드 호출시 전달되는 값을 받아주기위한 변수 선언문, 이 메소드 내에서만 사용가능 
		 * 		
		 * 		name = newName; // 필드에 전달받은 매개변수를 대입
		 * }
		 * 		* 관례상 메소드명을 필드명이랑 똑같이해준다 setXxx
		 * */

	
	
	public void setName(String name) {
		//name = name; //매게변수 name = 매개변수 name; 해당하는 메소드 안에서는 우선순위가 매개변수가 더 높다.
		
		//this : 인스턴스(객체) 자신을 가리키는 참조변수, 인스턴스 주소값이 담겨있다.
//		필드의 name = 매게변수 name;
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setHeight(double height){
		this.height = height;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	/* 3_2 데이터를 반환해주는 기능을 하는 메소드 (getter메소드) getXxx
	 * 해당 필드에 담겨있는 값을 반환만 시켜주면 되기 때문에 이 메소드로 전달되는 값은없다. (즉, 매개변수가 없다)
	 * 단, 반환을 해줘야하기 때문에 내가 반환하고하는 값의 자료형을 반환형에 써줘야 한다. 
	 * 
	 * */

	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public double getHeight(){
		return this.height;
	}
	
	public int getKor() {
		return this.kor;
	}
	
	public int getMath() {
		return math; //매개변수가 따로 없어서 this.를 안써도 필드에서 가져옴
	}
	
	public String information() {
		String info ="이름 : "+ name + ", 나이 : " +age+ ", 키 : "+height+", 국어 점수 : "+kor+", 수학 점수 : "+math;
		return info;
		
	}
}
