package com.uni.chap03_class.model.vo;


//클래스에 사용 가능한 접근 제한자 --> public, default(생략)
public class Product {

	private String pName;
	private int price;
	private String brand;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String information() {
		return pName + " " + price + " " + brand;
	}
	
	DftProduct d = new DftProduct(); //같은 패키지이기 때문에 가능
}


class DftProduct{
	
	private String dName;
	
	public String getDName() {
		return dName;
	}
	
	public void setDName(String dName) {
		this.dName =dName;
	}
	
	
	
}
