package com.uni.spring.model.dto;

public class BeanFactory {

	public static Object getBean(String name) {
		Singer singer = null;
		
		if(name.equals("Twice")) {
			singer = new Twice();
		}else {
			singer = new Blackpink();
		}
		
		return singer;
	}
}
