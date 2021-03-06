package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.ProductController;
import com.kh.model.dto.Product;
import com.kh.model.vo.ProductIO;

public class ProductMenu {
	private static Scanner sc = new Scanner(System.in);
	private ProductController pController = new ProductController();

	public void mainMenu() {
		int menu;
		
		do {
			System.out.println("\n=== 상품 관리 프로그램 ===");
			System.out.println("1. 전체 조회");
			System.out.println("2. 상품 추가");
			System.out.println("3. 상품 수정");
			System.out.println("4. 상품 삭제");
			System.out.println("5. 상품 검색");
			System.out.println("6. 상품 입출고 메뉴");
			System.out.println("9. 프로그램 종료하기");
			System.out.println("번호선택 : ");
			
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				pController.selectAll(); //전체 조회
				break;
			case 2 :
				pController.insertProduct(inputProduct()); //상품 추가
				break;
			case 3:
				pController.updateProduct(updateProduct()); //상품 수정
				break;
			case 4 :
				pController.deleteProduct(inputPid()); //상품 삭제
				break;
			case 5 :
				pController.searchProduct(inputPname()); //상품 검색
				break;
			case 6 :
				subMenu();
				break;
			case 9 :
				System.out.println("정말로 끝내시겠습니까?(Y/N)");
				if('Y' == sc.next().toUpperCase().charAt(menu)) {
					pController.exitProgram();
					return;
				}
			default :
				System.out.println("번호를 잘못 입력하였습니다.");
				break;
			}
			
		}while(true);
		
	}

	private Product inputProduct() { //상품 정보 입력
		Product p = new Product();
		
		System.out.println("새로운 상품 정보를 입력하세요 >>");
		System.out.println("상품ID : ");
		p.setProductId(sc.next());
		System.out.println("상품명 : ");
		p.setpName(sc.next());
		System.out.println("가격 : ");
		p.setPrice(sc.nextInt());
		sc.nextLine();
		System.out.println("부가설명 : ");
		p.setProductId(sc.next());
		return p;
	}
	
	private Product updateProduct() {
		Product p = new Product();
		
		System.out.println("수정할 상품 정보를 입력하세요 >>");
		System.out.println("상품ID : ");
		p.setProductId(sc.next());
		System.out.println("상품명 : ");
		p.setpName(sc.next());
		System.out.println("가격 : ");
		p.setPrice(sc.nextInt());
		sc.nextLine();
		System.out.println("부가설명 : ");
		p.setProductId(sc.next());
		return p;
	}

	private String inputPid() { //상품 id 입력
		System.out.println("상품 id 입력 : ");
		return sc.next();
	}
	
	private String inputPname() { //상품 이름 입력
		System.out.println("상품 이름 입력 : ");
		return sc.next();
	}
	
	public void displayProductList(ArrayList<Product> list) { //상품 리스트 출력
		System.out.println("====================== 상품 리스트 ======================");
		System.out.println("상품ID\t상품명\t가격\t부가설명\t재고수량");
		
		for(Product p : list) {
			System.out.println(p);
		}
	}

	///////////////////////////////////////////////////////////////////////////////////

	public void subMenu() { //6번 메뉴
		
		int menu;
		
		do {
			System.out.println("\n=== 입출고 메뉴 ===");
			System.out.println("1. 전체 입출고 내역 조회");
			System.out.println("2. 입고 내역 조회");
			System.out.println("3. 출고 내역 조회");
			System.out.println("4. 상품 입고");
			System.out.println("5. 상품 출고");
			System.out.println("9. 메인 메뉴로 돌아가기");
			System.out.println("번호선택 : ");
			
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				pController.selectAllIo();
				break;
			case 2 :
				pController.selectInOut(0);
				break;
			case 3:
				pController.selectInOut(1);
				break;
			case 4 :
				pController.productInOut(productInOut(0));
				break;
			case 5 :
				pController.productInOut(productInOut(1));
				break;
			case 9 :
				return;
			default :
				System.out.println("번호를 잘못 입력하였습니다.");
				break;
			}
			
		}while(true);
		
	}

	private ProductIO productInOut(int i) { //상품 아이디 입력
		ProductIO p = new ProductIO();
		System.out.println("상품 아이디 : ");
		p.setProductId(sc.next());
		if(i == 0) {
			System.out.println("입고 수량 : ");
			p.setAmount(sc.nextInt());
			p.setStatus("입고");
		}else if (i == 1) {
			System.out.println("출고 수량 : ");
			p.setAmount(sc.nextInt());
			p.setStatus("출고");
		}
		
		return p;
	}

	public void displayProductIOList(ArrayList<ProductIO> list) {
		System.out.println("====================== 입출고 리스트 ======================");
		System.out.println("입출고번호\t상품ID\t상품명\t입출고일\t\t입출고수량\t입출고상태");
		
		for(ProductIO p : list) {
			System.out.println(p);
		}
	}

	//////////////////////////////////////////////////////////////////////////
	
	public void displayError(String message) {
		System.out.println("서비스 요청 실패 : "+message);
	}

	public void displaySuccess(String message) {
		System.out.println("서비스 요청 성공 : " + message);
	}

	public void displayNoData() {
		System.out.println("조회된 결과가 없습니다.");
	}

}
