package com.uni.chap05_initBlock.run;

import com.uni.chap05_initBlock.model.vo.Product;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p = new Product();
		
		System.out.println(p.toString());
		System.out.println(p);
		
		Product p1 = new Product();
		System.out.println(p.toString());
		
		Product p2 = new Product();
		System.out.println(p);
		System.out.println(p.toString());
	}

}
