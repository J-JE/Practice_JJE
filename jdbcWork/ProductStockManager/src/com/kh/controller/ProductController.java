package com.kh.controller;

import java.util.ArrayList;

import com.kh.common.exception.ProductException;
import com.kh.model.dto.Product;
import com.kh.model.vo.ProductIO;
import com.kh.service.ProductService;
import com.kh.view.ProductMenu;

public class ProductController {
	
	public void selectAll() { //전체 조회
		ProductMenu menu = new ProductMenu();
		ArrayList<Product> list;
		
		try {
			list = new ProductService().selectAll();
			
			if(!list.isEmpty()) {
				menu.displayProductList(list);
			}else {
				menu.displayNoData();
			}
		}catch(ProductException e) {
			menu.displayError("상품 전체 조회 실패, 관리자에게 문의하세요.");
			System.out.println(e.getMessage());
		}
	}

	public void insertProduct(Product p) { //상품 추가
		ProductMenu menu = new ProductMenu();
		int result;
		
		try {
			result = new ProductService().insertProduct(p);
			
			if(result>0) {
				menu.displaySuccess("상품 추가 성공");
			}
		}catch(ProductException e) {
			menu.displayError("상품 추가 실패");
			System.out.println(e.getMessage());
		}
	}

	public void updateProduct(Product p) { //상품 수정
		ProductMenu menu = new ProductMenu();
		int result;
		
		try {
			result = new ProductService().updateProduct(p);
			
			if(result>0) {
				menu.displaySuccess("상품 수정 성공");
			}else {
				menu.displayError("상품 수정 실패");
			}
		}catch(ProductException e) {
			menu.displayError("상품 수정 실패");
			System.out.println(e.getMessage());
		}
	}

	public void deleteProduct(String id) { //상품 삭제
		ProductMenu menu = new ProductMenu();
		int result;
		
		try {
			result = new ProductService().deleteProduct(id);
			
			if(result>0) {
				menu.displaySuccess("상품 삭제 성공");
			}
		}catch(ProductException e) {
			menu.displayError("상품 삭제 실패");
			System.out.println(e.getMessage());
		}
	}

	public void searchProduct(String name) { //상품 검색
		ProductMenu menu = new ProductMenu();
		ArrayList<Product> list;
		
		try {
			list = new ProductService().searchProduct(name);
			
			if(!list.isEmpty()) {
				menu.displayProductList(list);
			}else {
				menu.displayNoData();
			}
		}catch(ProductException e) {
			menu.displayError("상품 검색 실패, 관리자에게 문의하세요.");
			System.out.println(e.getMessage());
		}
	}

	///////////////////////////////////////////////////////////
	
	public void selectAllIo() { //전체 입출고 내역 조회
		ProductMenu menu = new ProductMenu();
		ArrayList<ProductIO> list;
		
		try {
			list = new ProductService().selectAllIo();
			if(!list.isEmpty()) {
				menu.displayProductIOList(list);
			}else {
				menu.displayNoData();
			}
		} catch (ProductException e) {
			menu.displayError("전체 입출고 내역 조회 실패, 관리자에게 문의하세요.");
			System.out.println(e.getMessage());
		}
		
	}

	public void selectInOut(int i) { //입/출고 내역 조회
		ProductMenu menu = new ProductMenu();
		ArrayList<ProductIO> list;

		try {
			list = new ProductService().selectInOut(i);
			if(!list.isEmpty()) {
				menu.displayProductIOList(list);
			}else {
				menu.displayNoData();
			}		
		} catch (ProductException e) {
			menu.displayError("전체 입출고 내역 조회 실패, 관리자에게 문의하세요.");
			System.out.println(e.getMessage());
		}
		
	}

	public void productInOut(ProductIO p) { //상품 입/출고
		ProductMenu menu = new ProductMenu();
		int result;

		if(p.getStatus() == "입고") {
			try {
				result = new ProductService().ProductInOut(p);

				if(result > 0) {
					new ProductMenu().displaySuccess("성공적으로 입고하였습니다.");
				}
			} catch (ProductException e) {
				menu.displayError("상품 입고 실패, 관리자에게 문의하세요.");
				System.out.println(e.getMessage());
			}
		}else {
			try {
				result = new ProductService().ProductInOut(p);

				if(result > 0) {
					new ProductMenu().displaySuccess("성공적으로 출고하였습니다.");
				}
			} catch (ProductException e) {
				menu.displayError("출고하고자 하는 제품의 재고 수량이 부족합니다.");
			} catch (Exception e) {
				menu.displayError("상품 출고 실패, 관리자에게 문의하세요.");
				System.out.println(e.getMessage());
			}
		}
	}

	public void exitProgram() {
		new ProductService().exitProgram();
	}

}
