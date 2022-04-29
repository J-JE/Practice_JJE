package com.uni.spring.model.anno.dto;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Primary //구현 클래스가 여러개 있어도 이 클래스가 우선권을 갖고있음
@Component //("chicken1") //chicken으로 쓸거면 별칭 명시하지 않아도 ㄱㅊ 알아서 소문자로
public class Chicken implements Food {

	@Override
	public void eat(String foodName) {
		System.out.println("한강에서" + foodName + "치킨을 먹는 중~~");
		
	}

}
