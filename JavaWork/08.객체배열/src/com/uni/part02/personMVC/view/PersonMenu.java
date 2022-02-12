package com.uni.part02.personMVC.view;

import java.util.Scanner;

import com.uni.part02.personMVC.controller.PersonController;
import com.uni.part02.personMVC.model.vo.Person;

public class PersonMenu {
	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();
	
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("=====메뉴=====");
			System.out.println("1.회원추가");
			System.out.println("2.회원 전체조회");
			System.out.println("3.회원 이름검색");
			System.out.println("4.회원 평균재산조회");
			System.out.println("9.프로그램종료");
			System.out.println("메뉴선택 : ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 :
				insertPerson();
				break;
			case 2 :
				printPerson();
				break;
			case 3 :
				searchPerson();
				break;
			case 4 :
				System.out.println("평균 재산 : "+pc.getWealth());
				
				break;
			case 9 :
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				return;
			}
			
			
			
		}
	}


	private void searchPerson() {
		System.out.println("===회원 이름 검색===");
		
		System.out.println("검색할 이름 : ");
		String search = sc.nextLine();
		
		Person searchP =pc.serchPerson(search);
		
		if(searchP==null) {
			System.out.println("검색된 사람이 없습니다.");
		}else {
			System.out.println(searchP.information());
		}
		
	}


	private void printPerson() {
		System.out.println("===회원 정보 조회===");
		int cnt = pc.getCount();
		
		if(cnt==0) {
			System.out.println("현재 추가된 회원이 없습니다.");
		}else {
			Person[] peo =pc.getPeople();
			
			for(int i =0; i<cnt;i++) { //들어있는 회원의 수보다 작을 때 까지 돌리는 것
				System.out.println(peo[i].information());	
			}
			
//			for(Person p : peo) {
//				if(p != null) { //peo에 회원이 없을 수 있기 때문에
//					System.out.println(p.information());
//				}
//			}
			
		}
	}


	public void insertPerson() {
		
		System.out.println("===회원 정보 입력===");
		System.out.println("이름 : ");
		String name =sc.nextLine();
		System.out.println("나이 : ");
		int age =sc.nextInt();
		System.out.println("재산 : ");
		int wealth =sc.nextInt();
		sc.nextLine();
		
		boolean a = pc.insertPerson(name, age, wealth); //반환된 true/false값을 담을 변수 생성
		if(!a) {
			System.out.println("더이상 추가할 수 없습니다.");
		}
	}

	
	
	
	
	
	
	
}
