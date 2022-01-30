package com.uni.chap04_field.run;

import com.uni.chap04_field.model.vo.FieldTest1;
import com.uni.chap04_field.model.vo.FieldTest2;
import com.uni.chap04_field.model.vo.FieldTest3;
import com.uni.chap04_field.model.vo.FieldTest4;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//-----1.FieldTest1
		
//		FieldTest1 f1 =new FieldTest1();
//		f1.test(20);
		
		//-----1.FieldTest2
				
//		FieldTest2 f2 = new FieldTest2();
		
		//public --> 어디서든 접근가능
//		System.out.println(f2.pub);
		
		//protected --> 같은 패키지 내, 상속구조에서만 접근가능
//		System.out.println(f2.pro);-->다른 패키지 이면서, 상속 구조도 아니기 때문에 접근 불가
//		System.out.println(f2.getPro()); //getter 메소드를 통해 값을 알아올 수 있다.
		
		
		//default -->같은 패키지 내에서만 접근 가능
//		System.out.println(f2.getDef()); //다른 패키지이기 때문에 접근 불가
		
		//private --> 같은 클래스 내에서만 접근 가능
//		System.out.println(f2.pri);
//		System.out.println(f2.getPri());
	
	
		//-----1.FieldTest3
		
//		FieldTest3 f3 = new FieldTest3(); 객체 생성 할 필요 없음

//		System.out.println(FieldTest3.pubSta); //객체생성 할 필요 없이 클래스명.으로 접근이 가능하다.
//		System.out.println(Math.PI);
		
//		FieldTest3.pubSta="값 변경";
//		System.out.println(FieldTest3.pubSta);
		
//		FieldTest3.priSta="값 변경";
//		FieldTest3.setPriSta("값 변경");
//		System.out.println(FieldTest3.getPriSta());

		
		//-----1.FieldTest4
//		System.out.println(FieldTest4.NUM);
//		FieldTest4.NUM =3; -->상수이기 때문에 수정 불가
		
	}

}
