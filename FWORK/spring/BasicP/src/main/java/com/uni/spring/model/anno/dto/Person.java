package com.uni.spring.model.anno.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	
	@Value("유재석") //단순값 주입
	private String name;
	
	@Autowired //오토와이어드에 주입할 클래스 유무에 따라 바뀌는건 나중에 함
	@Qualifier("pizza")
	private Food myFood;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, Food myFood) {
		super();
		this.name = name;
		this.myFood = myFood;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Food getMyFood() {
		return myFood;
	}

	public void setMyFood(Food myFood) {
		this.myFood = myFood;
	}

	@Override
	public String toString() {
		return name + "~~~" + myFood;
	}

}
