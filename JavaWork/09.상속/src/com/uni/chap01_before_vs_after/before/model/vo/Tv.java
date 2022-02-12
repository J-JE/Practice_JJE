package com.uni.chap01_before_vs_after.before.model.vo;

public class Tv {
	private String brand;//브랜드
	private String pCode;//상품번호
	private String pName;//상품명
	private int price;//가격
	
	private int inch; //인치
	
	public Tv() {
		// TODO Auto-generated constructor stub
	}

	public Tv(String brand, String pCode, String pName, int price, int inch) {
		super();
		this.brand = brand;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.inch = inch;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
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

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		return "Tv [brand=" + brand + ", pCode=" + pCode + ", pName=" + pName + ", price=" + price + ", inch=" + inch
				+ "]";
	}
	
	
	
}
