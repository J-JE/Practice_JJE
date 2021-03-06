package com.kh2.collection.silsub1.controller;

import java.util.Date;
import java.util.Scanner;

import com.kh2.collection.silsub1.model.dao.BoardDao;

public class BoardManager {
	private BoardDao bd = new BoardDao();
	private Scanner sc = new Scanner(System.in);
	
	public BoardManager() { }
	
	public void writeBoard() {
		// "새 게시글 쓰기 입니다." 출력
		System.out.println("새 게시글 쓰기입니다.");
		
		// "글 제목 : " >> 입력 받음 (공백 포함)
		System.out.print("글제목 : ");
		String title = sc.nextLine();
		
		// "작성자 : " >> 입력 받음 (공백 없이)
		System.out.print("작성자 : ");
		String writer = sc.nextLine();

		String str=null;
		for(int i=0; i < writer.length(); i++) {
			char ch = writer.charAt(i);
			if(ch != ' ') {
				str += ch;
			}
		}
		// 작성날짜는 현재 날짜로 처리함
		Date today = new Date();
		
		// "글 내용 : " >> 여러 줄로 입력 받음 >>"exit" 입력하면 입력종료
		System.out.println("글 내용 : ");
		
		String contents=null;
		while(true) {
			String str2=sc.nextLine();
			if(str2.equals("exit")) {
				break;
			}
			contents+=str2;
		}
		// BoardDao의 getLastBoardNo() 메소드를 통해 게시글의 마지막 번호를 알아옴
		
		// Board 객체 생성시 초기값으로 사용함
		
		// BoardDao의 writeBoard() 메소드 호출 시 해당 Board 전달
		
		// 파일이 존재하지 않을 경우, 즉 첫 글 등록일 경우 예외 발생
		// ->어떤 예외처리가 발생하는지 알아보고 try catch문을 이용하여 오류 해결

	}
	public void displayAllList(){
		
	}
	public void displayBoard(){
		
	}
	public void modifyTitle(){
		
	}
	public void modifyContent(){
		
	}
	public void deleteBoard(){
		
	}
	public void searchBoard(){
		
	}
	public void saveListFile(){
		
	}
	public void sortList(int item, Boolean isDesc) {
		
	}
}
