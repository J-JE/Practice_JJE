package com.uni.chap01_poly.part02_electronic.model.vo;

public class Electronic {

	private String brand;
	private String name;
	private int prcie;
	
	public Electronic() {
		// TODO Auto-generated constructor stub
	}

	public Electronic(String brand, String name, int prcie) {
		super();
		this.brand = brand;
		this.name = name;
		this.prcie = prcie;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrcie() {
		return prcie;
	}

	public void setPrcie(int prcie) {
		this.prcie = prcie;
	}

	@Override
	public String toString() {
		return "Electronic [brand=" + brand + ", name=" + name + ", prcie=" + prcie + "]";
	}
	
}
