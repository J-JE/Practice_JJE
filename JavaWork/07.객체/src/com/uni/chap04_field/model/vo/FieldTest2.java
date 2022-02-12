package com.uni.chap04_field.model.vo;

public class FieldTest2 {
/*[접근제한자][예약어] 자료형 변수명 [=초기값];
	
	 * * 필드에서 사용가능한 접근제한자 4가지
	 * 
	 * public 		=> 어디서든 (같은 패키지, 다른 패키지 모두) 접근 가능
	 * protected	=> 같은 패키지 접근 가능 + 만약 다른 패키지라면 상속구조(부모자식간의 관계)에서는 접근 가능
	 * default 		=> 같은 패키지에서만 접근 가능
	 * private 		=> only 해당 클래스에서만 접근 가능
	 * 
	 * 위에서부터 아래로 내려갈 수록 접근할 수있는 범위가 좁아진다. 
	 * 
	 * 예약어 static->공유개념(전역변수의 일종인 클래스 변수)
	 */

	
	public String pub ="public";
	protected String pro = "protected";
	/*default*/ String def ="default";
	private String pri ="private";
	
	public FieldTest2() {
		// TODO Auto-generated constructor stub
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public String getPri() {
		return pri;
	}

	public void setPri(String pri) {
		this.pri = pri;
	}
	
	
	
	
}
