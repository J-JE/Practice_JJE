package com.uni.chap03_class.run;

import com.uni.chap03_class.model.vo.Product;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		Person p = new Person();
		
		p.setId("user01");
		p.setPwd("pass01");
		p.setName("로운");
		p.setAge(30);
		p.setGender('m');
		p.setPhone("010-1111-2222");
		p.setEmail("l@uni.com");
		
		System.out.println(p.information());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("변경할 이름 : ");
		String name = sc.next();
		
		//이름 변경
		p.setName(name);
		
		System.out.println(p.information());
*/		
		
		Product p1 = new Product();
		
		p1.setpName("갤럭시");
		p1.setPrice(10000000);
		p1.setBrand("삼성");
		
		Product p2 = new Product();
		
		p2.setpName("아이폰");
		p2.setPrice(20000000);
		p2.setBrand("애플");
		
		System.out.println(p1.information());
		System.out.println(p2.information());
		
		
//		DftProduct d = new DftProduct(); 다른 패키지여서 에러!
		
		
	}

}
