package com.hw2.run;

import com.hw2.model.vo.Circle;
import com.hw2.model.vo.Rectangle;

public class Run {

	/*크기가 2인 Circle, Rectangle 각각의 객체 배열 할당 후 사용데이터를 참고하여 각 객체 초기화
		반복문을 통해 각 도형의 draw메소드 실행*/
	
	public static void main(String[] args) {
		
		// 크기가 2인 Circle, Rectangle 각각 객체 배열 할당
		Circle[] c =new Circle[2];
		Rectangle[] r =new Rectangle[2];
		
		// 위의 사용 데이터를 참고하여 각각 초기화
		c[0] =new Circle(1, 2, 3); //x, y, radius
		c[1] =new Circle(3, 3, 4);
		
		r[0] =new Rectangle(-1, -2, 5, 2); //x, y, width, height
		r[1] =new Rectangle(-2, 5, 2, 8);
		
		// 각 도형의 draw 메소드 실행--> 향상된 for문 이용해서
		System.out.println("===== circle =====");
		
		for(Circle circle :c) {
			circle.draw(); //c가 아닌 circle로
		}
		
		System.out.println("===== rectangle =====");
		for(Rectangle rectangle :r) {
			rectangle.draw();
		}
		
	}

}
