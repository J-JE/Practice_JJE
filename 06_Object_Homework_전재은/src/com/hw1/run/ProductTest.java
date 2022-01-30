package com.hw1.run;

import com.hw1.model.vo.Product;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Product p =new Product();//없어도 됨.
		
		Product p1 =new Product("ssgnote9","갤럭시노트9","경기도 수원",960000,10.0);
		Product p2 =new Product("lgxnote5 ","LG스마트폰5","경기도 평택",780000,0.7);
		Product p3 =new Product("ktsnote3","KT스마트폰3","서울시 강남 ",250000,0.3);
		
		System.out.println(p1.information());
		System.out.println(p2.information());
		System.out.println(p3.information());
		System.out.println("=====================================================");
		
		p1.setPrice(1200000);
		p1.setTax(0.05);
		p2.setPrice(1200000);
		p2.setTax(0.05);
		p3.setPrice(1200000);
		p3.setTax(0.05);
		
		System.out.println(p1.information());
		System.out.println(p2.information());
		System.out.println(p3.information());
		System.out.println("=====================================================");
		
		System.out.println("상품명 = "+ p1.getProductName()+"\n부가세 포함 가격 = "+ (int)(p1.getPrice()*(1+p1.getTax()))+"원");
		System.out.println("상품명 = "+ p2.getProductName()+"\n부가세 포함 가격 = "+ (int)(p2.getPrice()*(1+p2.getTax()))+"원");
		System.out.println("상품명 = "+ p3.getProductName()+"\n부가세 포함 가격 = "+ (int)(p3.getPrice()*(1+p3.getTax()))+"원");
	}

}
