package com.uni.chap01_poly.part01_basic.model.vo;

public class Child2 extends Parent{

	private int n;
	
	public Child2() {
		// TODO Auto-generated constructor stub
	}

	public Child2(int x, int y, int n) {
		super(x, y);
		this.n=n;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	public void printChild2() {
		System.out.println("나 두번째 자식이야");
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("나 두번째 자식이야 print()");
	}
}
