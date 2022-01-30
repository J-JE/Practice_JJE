package com.uni.chap08_mvc.view;

import java.util.Scanner;

import com.uni.chap08_mvc.controller.ProductController;

//mvc 패턴중 view 패키지 : 사용자가 보게될 화면을 담당하는 부분 , 사용자가 보게되면 (print구문)은 반드시 view 패키지 내에서만 작성.
//scanner 사용도 view 패키지 안에서만 작성

public class ProductMenu {
	private Scanner sc =new Scanner(System.in);
	private ProductController pc = new ProductController();
	
	
	//1. 프로그램 시작핮마자 실행될 메인메뉴
	public void mainMenu() {
		
		System.out.println("제품명 : ");
		String name = sc.nextLine();
		
		System.out.println("브랜드명 : ");
		String brand =sc.nextLine();
		
		System.out.println("가격 : ");
		int price =sc.nextInt();
		
		pc.insertProduct(name, brand, price);
		
		while(true) {
			System.out.println("====메인메뉴====");
			System.out.println("1.제품정보조회");
			System.out.println("2.제품정보수정");
			System.out.println("9.프로그램 종료");
			
			int num =sc.nextInt();
			sc.nextLine();
			
			switch(num) {
			case 1 :
				System.out.println(pc.selectProduct().information());
				break;
			case 2 :
				updatePrice();
				break;
			case 9 : 
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("메뉴를 다시 선택해주세요.");
				break;
			}
		}
	}


	private void updatePrice() {
		System.out.println("수정할 가격을 입력해주세요 : ");
		int nPrice = sc.nextInt();
		pc.updatePrice(nPrice);
	}

}
