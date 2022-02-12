package com.uni.Test.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.uni.Test.controller.BookManager;
import com.uni.Test.model.vo.Book;

public class BookMenu {

	private Scanner sc = new Scanner(System.in);
	private BookManager bm = new BookManager();
	
	public BookMenu() {
	}
	
	public void mainMenu() {
		while(true) {
			System.out.println("*** 도서 관리 프로그램 ***");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 삭제 ");
			System.out.println("3. 도서 검색 출력");
			System.out.println("4. 전체 출력");
			System.out.println("0. 끝내기");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case  1 :
				insertBook();
				break;
			case  2 :
				deleteBook();
				break;
			case  3 :
				searchBook();
				break;
			case  4 :
				selectList();
				break;
			case 0 :
				System.out.println("종료합니다.");
				return;
			}
		}
		
	}
	
	public void insertBook() {// 도서 추가
		System.out.println("도서 제목 : ");
		String title = sc.nextLine();
		System.out.println("도서 장르 (1:인문 / 2:자연과학 / 3:의료 / 4:기타) : ");
		int category = sc.nextInt();
		sc.nextLine();
		System.out.println("도서 저자 : ");
		String author = sc.nextLine();
		
		Book book = new Book(title, category, author);
		bm.insertBook(book);
	}
	
	public void deleteBook() {// 도서 삭제
		System.out.println("도서 번호");
		int bNo = sc.nextInt();
		sc.nextLine();
		
		int result = bm.deleteBook(bNo);
		
		if(result ==1) {
			System.out.println("성공적으로 삭제");
		}else {
			System.out.println("삭제할 도서가 존재하지 않습니다.");
		}
	}
	
	public void searchBook() {// 도서 검색
		System.out.println("도서 제목 : ");
		String title = sc.nextLine();

		ArrayList<Book> searchList =bm.searchBook(title);
		if(searchList.isEmpty()) {//boolean타입 반환
			System.out.println("검색 결과가 존재하지 않습니다.");
		}else {
			for(Book b : searchList) {//for문으로 바꾸기
				System.out.println(b);
			}
		}
	}
	
	public void selectList() {// 전체 조회
		ArrayList<Book> bookList = bm.selectList();
		if(bookList.isEmpty()) {
			System.out.println("도서 목록이 존재하지 않습니다.");
		}else {
			for(Book b : bookList) {
				System.out.println(b);
			}
		}
	}
	
}
