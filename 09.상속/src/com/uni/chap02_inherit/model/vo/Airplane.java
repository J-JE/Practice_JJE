package com.uni.chap02_inherit.model.vo;

public class Airplane extends Vehicle{
	
	private int tire;
	private int wing;
	
	public Airplane() {
		// TODO Auto-generated constructor stub
	}

	public Airplane(String name, double mileage, String kind,int tire, int wing) {
		super(name, mileage, kind);
		this.tire=tire;
		this.wing=wing;
		// TODO Auto-generated constructor stub
	}

	public int getTire() {
		return tire;
	}

	public void setTire(int tire) {
		this.tire = tire;
	}

	public int getWing() {
		return wing;
	}

	public void setWing(int wing) {
		this.wing = wing;
	}

	@Override
	public String toString() {
		return "Airplane [tire=" + tire + ", wing=" + wing + ", toString()=" + super.toString() + "]";
	}

	@Override
	public void howToMove() {
		// TODO Auto-generated method stub
		System.out.println("날개를 가지고 날아다닌다.");
	}
	
}
