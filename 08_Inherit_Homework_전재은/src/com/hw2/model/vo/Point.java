package com.hw2.model.vo;

public class Point {

	private int x;
	private int y;
	
	public Point() {	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw() {
		System.out.println("(x, y) : " +"(" + x +", " + y +")");
	}
	
}
