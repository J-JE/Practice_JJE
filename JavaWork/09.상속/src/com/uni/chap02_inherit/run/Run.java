package com.uni.chap02_inherit.run;

import com.uni.chap02_inherit.model.vo.Airplane;
import com.uni.chap02_inherit.model.vo.Car;
import com.uni.chap02_inherit.model.vo.Ship;
import com.uni.chap02_inherit.model.vo.Vehicle;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Airplane a = new Airplane("비행기", 10.21, "에어버스", 22, 2);
		Car c = new Car("벤틀리", 12.5, "세단", 4);
		Ship s = new Ship("배", 30, "유조선", 10);
		
		System.out.println(a);
		System.out.println(c);
		System.out.println(s);
		
		a.howToMove();
		c.howToMove();
		s.howToMove();
		
		//다형성 적용하고 howToMove() 찍기
		System.out.println("=================");
		
		Vehicle[] v = new Vehicle[3];
		
		v[0]=a;
		v[1]=c;
		v[2]=s;
		
		for(Vehicle v2:v) {
			v2.howToMove();
		}
	}

}
