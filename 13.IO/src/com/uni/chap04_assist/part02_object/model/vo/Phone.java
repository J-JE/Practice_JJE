package com.uni.chap04_assist.part02_object.model.vo;

import java.io.Serializable;

public class Phone implements Serializable{
	
	/*
	 *  직렬화  : 객체를 입출력 하고자 한다면 반드시 직렬화가 필요하다
	 *  객체를 바이트의 배열로 변환을 해서 파일이나 메모리 등을 저장하는 과정 ,
	 *   저장된것을 다시 객체로 변환 하는것을 역직열화 라고 한다. 
	 *  
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 510194549677934739L;

	private String brand;
	private int price;
	
	public Phone() {
		// TODO Auto-generated constructor stub
	}

	public Phone(String brand, int price) {
		super();
		this.brand = brand;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Phone [ brand = "+brand +" , price = "+ price+ "]";
	}
	
}
