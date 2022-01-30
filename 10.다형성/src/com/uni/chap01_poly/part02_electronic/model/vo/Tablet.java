package com.uni.chap01_poly.part02_electronic.model.vo;

public class Tablet extends Electronic{
	private boolean penFlag;
	
	public Tablet() {
		// TODO Auto-generated constructor stub
	}

	public Tablet(String brand, String name, int prcie, boolean penFlag) {
		super(brand, name, prcie);
		this.penFlag=penFlag;
	}

	public boolean isPenFlag() {
		return penFlag;
	}

	public void setPenFlag(boolean penFlag) {
		this.penFlag = penFlag;
	}

	@Override
	public String toString() {
		return super.toString()+", penFlag : "+ (penFlag ? "있음" : "없음");
	}
	
}
