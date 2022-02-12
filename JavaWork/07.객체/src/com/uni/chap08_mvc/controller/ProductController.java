package com.uni.chap08_mvc.controller;
//controller : 사용자의 요청에 의해서 서비스 호출전 파라미터셋팅.(서비스 단을 생략해서 현재는 비즈니스 로직(데이터의 수정,가공처리)을 구현)

import com.uni.chap08_mvc.model.vo.Product;

public class ProductController {

	private Product pro = null;
	
	
	public void insertProduct(String name, String brand, int price) {
		// TODO Auto-generated method stub
		pro = new Product(name, price, brand);
	}


	public Product selectProduct() {
		// TODO Auto-generated method stub
		return pro;
	}


	public void updatePrice(int nPrice) {
		pro.setPrice(nPrice);
	}

}
