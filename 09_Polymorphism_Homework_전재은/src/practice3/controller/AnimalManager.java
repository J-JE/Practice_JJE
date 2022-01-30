package practice3.controller;

import practice3.model.vo.Animal;
import practice3.model.vo.Cat;
import practice3.model.vo.Dog;

public class AnimalManager {

	public static void main(String[] args) {
		Animal[] a = new Animal[5];
		
		a[0]=new Dog("초코", "푸들", 2);
		a[1]=new Cat("모카", "코리안 숏헤어", "한국", "얼룩");
		a[2]=new Dog("라떼", "진돗개", 21);
		a[3]=new Cat("차차", "러시안블루", "영국", "회색");
		a[4]=new Dog("또또", "웰시코기", 13);
		
		for(Animal b : a) {
			b.speak();
		}
	}

}
