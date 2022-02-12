package com.hw2.model.vo;

public class Circle extends Point{ //Point의 자식 클래스

	private int radius;

	public Circle() {
	}
	public Circle(int x, int y, int radius) { //Point의 x와 y를 상속받았다.
		super(x, y); //부모 생성자를 호출하는 super()는 첫줄에
		this.radius=radius;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public void draw() { //부모 메소드를 오버라이딩해서 사용한다.
		super.draw();
		// 면적 : PI * 반지름 * 반지름
		System.out.printf("면적 : %.1f\n",(double)(Math.PI*radius*radius));//printf는 +아니고 ,
		// 둘레 : PI * 반지름 * 2
		System.out.printf("둘레 : %.1f\n",(double)(Math.PI*radius*2));

	}
	
}
