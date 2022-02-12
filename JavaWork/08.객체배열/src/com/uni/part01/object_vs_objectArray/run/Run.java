package com.uni.part01.object_vs_objectArray.run;

import java.util.Scanner;

import com.uni.part01.object_vs_objectArray.model.vo.Book;

public class Run {

	public static void main(String[] args) {
		// ObjectTest
		
		Book bk1 =null;
		Book bk2 =null;
		Book bk3 =null;
		
		
		Scanner sc=new Scanner(System.in);//책 정보를 입력 받기 위ㅐ서 for문을 돌릴것
		
		for(int i =0;i<3;i++) {
			System.out.println(i+1+" 번째 도서 정보 입력");
			System.out.println("제목 : ");
			String title =sc.nextLine();
			
			System.out.println("저자 : ");
			String author =sc.nextLine();
			
			System.out.println("가격 : ");
			int price =sc.nextInt();
			sc.nextLine();
			
			System.out.println("출판사 : ");
			String publisher =sc.nextLine();
			
			if(i==0) {
				bk1=new Book(title,author,price,publisher);
			}else if(i==1) {
				bk2=new Book(title,author,price,publisher);
			}else if(i==2){
				bk3=new Book(title,author,price,publisher);
			}
		}
		
		//전체 도서 정보 조회학시
		System.out.println(bk1.information());
		System.out.println(bk2.information());
		System.out.println(bk3.information());
		
		
		//도서 제목 검색
		//일치x "검색되는 도서가 없습니다.
		System.out.println("검색할 도서명 : ");
		String title =sc.nextLine();
		
		if(title.equals(bk1.getTitle())) {
			System.out.println(bk1.information());
			
		}else if(title.equals(bk2.getTitle())) {
			System.out.println(bk2.information());
			
		}else if(title.equals(bk3.getTitle())) {
			System.out.println(bk3.information());
			
		}else {
			System.out.println("일치하는 도서가 없습니다.");
		}
		
	}
	

	
	
	
	
	
	
	
	
	
	
}
