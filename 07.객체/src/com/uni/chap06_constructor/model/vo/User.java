package com.uni.chap06_constructor.model.vo;

public class User {
	/*
	 * * 생성자 : 다른 패키지나 사용하고자하는 클래스에서 현재클래스를 통한 객체를 생성할때 사용하는 메소드
	 * 
	 * [접근제한자] 클래스명([매개변수, 매개변수, ...]) {... }
	 * 접근제한자 :public (다른클래스에서 생성하려는 목적이므로)
	 * 
	 * * 생성자를 작성하는 목적
	 * 1. 객체를 생성해주기 위한 목적
	 * 2. 매개변수로 전달받은 값들을 필드에 바로 초기화할 목적
	 * 
	 * * 생성자 작성시 주의사항
	 * 1. 반드시 클래스명과 동일해야된다. (대/소문자 구분)
	 * 2. 반환형이 존재하지 않는다. (메소드와 유사해서 헷갈릴수있음)
	 * 3. 매개변수 생성자를 명시적으로 작성하게되면 기본생성자를 JVM이 자동으로 만들어주지 않는다. 
	 *    즉, 기본생성자는 항상 기본으로 작성하는 습관을 길러라
	 * 
	 */
	
	private String userId;
	private String userPwd;
	private String userName;
	private int age;
	private char gender;
	
	//기본생성자--> public 클래스명(){} : 단지 객체 생성만을 목적으로 하고있다. 매개변수 생성자가 있으면, 생략이 불가능
	public User() {
		// TODO Auto-generated constructor stub
	}

	//매개변수가 있는 생성자(사용자가 직접 만든다) -->public 클래스면(매개변수) : 객체생성과 동시에 전달된 값들을 매개변수로 담아서 해당 필드에 초기화 하는 목적
	public User(String userId, String userPwd, String userName) {
		
		this.userId =userId;
		this.userPwd =userPwd;
		this.userName =userName;
		//this:인스턴스 자신을 가리키는 참조변수, 주소가 저장되어있다.
		
		//나머지 필드 부분은 JVM의 초기값으로 들어가있다.
		
	}
	
	public User(String userId, String userPwd, String userName,int age, char gender) {
		/*this.userId =userId;
		this.userPwd =userPwd;
		this.userName =userName;*/
		
		this(userId, userPwd, userName);
		//위와 같이 중복되는 동일한 초기화하는 내용의 생성자가 존재하는 경우 this()생성자를 사용 가능하다. 
		//같은 클래스내에서는 생성자에서 다른 생성자를 호출가능 단, 이떄 반드시 첫줄에 작성을 해야한다.(단 한번만 호출가능)

		this.age=age;
		this.gender =gender;
	}

	/* 결론
	 * 오버로딩 : 동일한 메소드 명을 사용하는 것  , 매개변수의 자료형과 갯수 , 순서가 다르게 작성되어야 한다. (접근제한자, 반환형은 상관없음) 
	 * */

	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	
	

}
