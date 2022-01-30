package com.uni.Test.controller;

import java.util.ArrayList;

import com.uni.Test.model.vo.Book;

public class BookManager {

	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	public BookManager() {}
	
	public void insertBook(Book book) {
		int lastNo = 0;
		
		try {
			lastNo = bookList.get(bookList.size()-1).getbNo() + 1;// 마지막 도서 번호+1
			//bookList.get() -> 리스트 불러오기
			//bookList.get(bookList.size()-1) -> 마지막 리스트
			//bookList.get(bookList.size()-1).getbNo() + 1 -> 마지막 리스트의 도서번호 +1 -> 현재 도서의 다음 번호
			
		}catch(IndexOutOfBoundsException e){ //인덱스에 값이 없음 -> 앞에 책이 없어서 인덱스가 -1이기 때문
			lastNo=1; //앞에 도서가 없으면 1번 도서로 등록
		}
		
		book.setbNo(lastNo);
		bookList.add(book);
	}
	
	public int deleteBook(int bNo) {
		for(Book b : bookList) {
			if(b.getbNo() == bNo) {//i인덱스의 도서 번호가 일치하면
				bookList.remove(b);
				return 1;
			}
		}
		return 0;
	}
	
	public ArrayList<Book> searchBook(String title){
		ArrayList<Book> searchList = new ArrayList<Book>();
		
		for(Book b : bookList) {
			if(b.getTitle().equals(title)) {
				searchList.add(b);
			}
		}
		return searchList;
	}
	
	public ArrayList<Book> selectList(){
		
		return bookList;
	}
	
	
	
	
}
