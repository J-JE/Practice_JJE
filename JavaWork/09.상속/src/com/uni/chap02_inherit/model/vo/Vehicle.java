package com.uni.chap02_inherit.model.vo;

public class Vehicle {
	private String name;
	private double mileage;
	private String kind;

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String name, double mileage, String kind) {
		super();
		this.name = name;
		this.mileage = mileage;
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", mileage=" + mileage + ", kind=" + kind + "]";
	}
	
	public void howToMove() {
		System.out.println("움직인다~");
	}
}
