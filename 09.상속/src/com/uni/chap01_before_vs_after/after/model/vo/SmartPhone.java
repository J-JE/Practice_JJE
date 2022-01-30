package com.uni.chap01_before_vs_after.after.model.vo;

public class SmartPhone extends Product{

	private String mobileAgency;//통신사
	
	public SmartPhone() {
		// TODO Auto-generated constructor stub
	}

	public SmartPhone(String brand, String pCode, String pName, int price, String mobileAgency) {
		super(brand, pCode, pName, price);
		this.mobileAgency = mobileAgency;
	}

	public String getMobileAgency() {
		return mobileAgency;
	}

	public void setMobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", mobileAgency="+mobileAgency;
	}
	
	
}
