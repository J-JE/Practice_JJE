package com.uni.part01.object_vs_objectArray.run;

import java.util.Scanner;

import com.uni.part01.object_vs_objectArray.model.vo.Book;

public class ObjectArrayTest {

	public static void main(String[] args) {
		
		//1. 기본 자료형 배열
		int[] arr =new int [3]; //레퍼런스 변수, 참조변수
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
			
//		System.out.println(arr);
//		System.out.println(arr[1]);//실제 값을 가지는 변수
		
		//arr의 자료형 :int[] -->arr은 레퍼런스 변수 == 주소값을 가지는 변수
		//arr[index]의 자료형 : int --> 일반변수 == 실제 값을 가지는 변수
		
		//2. 객체들을 여러개 담을 때 객체 배열을 사용
		Book[] books =new Book[3];
		
		//books의 자료형 : Book[] -->레퍼런스 변수 == 주소값을 갖는 변수
		//book[index] 의 자료형 : Book -->레퍼런스 변수 == 주소값을 가지는 변수

		
		//books[index] = 객체생성;
		
		books[0] =new Book();
		books[1] =new Book();
		books[2] =new Book();
		
		System.out.println(books);
		System.out.println(books[0]);
		
		//실제 값이 들어가 있는 곳은? books[index] 객체의 각 필드로 접근
		System.out.println(books[0].getPrice());//books[0].getPrice()의 자료형 int -->실제값을 가지고있다.
		
		
		//=================================
		
		Scanner sc=new Scanner(System.in);//책 정보를 입력 받기 위ㅐ서 for문을 돌릴것
		
		for(int i =0;i<books.length;i++) { //books 배열의 길이[3] 만큼
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
			
			
			books[i]=new Book(title,author,price,publisher); //i가 증가하고 있음 쉽게 입력 가능함
		
		}
		
		//전체 도서 정보 조회학시
		for(int i =0; i<books.length;i++) {
			System.out.println(books[i].information());
				}
		
		//일반 for문 -->for loop문
		System.out.println("검색할 도서명 : ");
		String title =sc.nextLine();
		
		for(int i =0; i<books.length;i++) {
			if(title.equals(books[0].getTitle())) {
				System.out.println(books[0].information());
			}else {
				System.out.println("일치하는 도서가 없습니다.");
			}
			
		}
		
		//향산된 for문 --> for each문 //0번 인덱스부터 마지막 인덱스까지 알아서 돌아감
		
		for(int num:arr) {
			System.out.println(num);
		}
		
		for(Book b:books) {
			System.out.println(b.information());
		}
	}

	
	
	
}
