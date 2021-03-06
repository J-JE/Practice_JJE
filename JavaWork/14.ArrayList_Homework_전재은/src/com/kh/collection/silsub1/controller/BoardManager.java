package com.kh.collection.silsub1.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import com.kh.collection.silsub1.model.comparator.AscBoardDate;
import com.kh.collection.silsub1.model.comparator.AscBoardNo;
import com.kh.collection.silsub1.model.comparator.AscBoardTitle;
import com.kh.collection.silsub1.model.comparator.DescBoardDate;
import com.kh.collection.silsub1.model.comparator.DescBoardNo;
import com.kh.collection.silsub1.model.comparator.DescBoardTitle;
import com.kh.collection.silsub1.model.dao.BoardDao;
import com.kh.collection.silsub1.model.vo.Board;

public class BoardManager {
	private BoardDao bd = new BoardDao();
	private Scanner sc = new Scanner(System.in);
	public BoardManager() {}//기본생성자

	public void writeBoard() {//키보드 입력을 통해 새로운 게시글을 입력 받음BoardDao의 writeBoard() 메소드로 해당 게시글 전달
		System.out.println("새 게시글 쓰기입니다.");
		System.out.print("글제목 : ");//공백포함
		String title = sc.nextLine();
		
		System.out.print("작성자 : ");//공백 없이
		String writer = sc.nextLine();
		
		String w = "";//공백을 제거한 값을 받는 String
		for(int i=0; i < writer.length(); i++) {
			char ch = writer.charAt(i);//한글자씩
			if(ch != ' ') {//공백이 아닌 경우만
				w += ch;
			}
		}
		
		Date today = new Date();// 작성날짜는 현재 날짜로 처리함
		
		System.out.println("글 내용 : ");//여러 줄로 입력 받음, "exit" 입력하면 입력종료
		String contents =null;
		while(true) {
			String str = sc.nextLine();
			if(str.equals("exit")) {
				break;
			}
			contents+= str;
		}
		// BoardDao의 getLastBoardNo() 메소드를 통해 게시글의 마지막 번호를 알아옴
		// Board 객체 생성시 초기값으로 사용함
		try {
			bd.writeBoard(new Board(bd.getLastBoardNo() + 1, title, writer, today, contents));
		}catch(IndexOutOfBoundsException e ) {//파일이 비어있으 오류남
			bd.writeBoard(new Board(1, title, writer, today, contents));//게시글이 없는 상태면 1번에 값 넣기
		}
	}
	
	public void displayAllList() {//BoardDao의 displayAllList() 메소드를 통해 list를 전달받고Iterator를 이용하여 전체 리스트 출력
		Iterator i = bd.displayAllList().iterator();
		while(i.hasNext()) {//i에 값이 없을 때 까지 출력
			System.out.println(i.next());
		}
	}
	
	public void displayBoard() {//키보드를 통해 조회할 글 번호를 입력 받고 BoardDao의displayBoard() 메소드로 전달결과 값으로 해당 글 번호의 게시글을 전달받고 출력
								//조회수를 올리기위해 BoardDao의 upReadCount() 메소드를 호출
		System.out.print("조회할 글 번호 : ");
		int no = sc.nextInt();
		Board board = bd.displayBoard(no);
		
		if(board == null) {
			System.out.println("조회된 글이 없습니다.");
		}else{
			System.out.println(board);//출력
			bd.upReadCount(no);//조회수+1
		}
	}
	
	public void modifyTitle() {//키보드를 통해 수정할 글 번호와 수정할 제목을 입력 받고BoardDao의 modifyTitle() 메소드로 해당 글 번호와 수정할 제목 값을 전달
		System.out.print("수정할 글 번호 : ");
		int no = sc.nextInt();
		Board board = bd.displayBoard(no);
		
		if(board == null) {
			System.out.println("조회된 글이 없습니다.");
		}else {
			System.out.print("변경할 제목 : ");
			String title = sc.nextLine();
			bd.modifyTitle(no, title);
		}
	}
	
	public void modifyContent() {//키보드를 통해 수정할 글 번호와 수정할 내용을 입력 받고BoardDao의 modifyContent() 메소드로 글 번호와 수정할 내용 값을 전달
		System.out.print("수정할 글 번호 : ");
		int no = sc.nextInt();
		Board board = bd.displayBoard(no);
		
		if(board == null) {
			System.out.println("조회된 글이 없습니다.");
		}else {
			System.out.print("변경할 내용 : ");
			String content = sc.nextLine();
			bd.modifyTitle(no, content);
		}
	}
	
	public void deleteBoard() {//키보드를 통해 삭제할 글 번호를 입력 받고 BoardDao의deleteBoard() 메소드로 전달
		System.out.print("삭제할 글 번호 : ");
		int no = sc.nextInt();
		Board board = bd.displayBoard(no);
		
		if(board == null) {
			System.out.println("조회된 글이 없습니다.");
		}else {
			System.out.println("정말 삭제하시겠습니까? (y/n)");
			char result = sc.nextLine().toUpperCase().charAt(0);//대문자로 바꿔서
			if(result == 'Y') {
				bd.deleteBoard(no);
				System.out.println(no + "번 글이 삭제되었습니다.");
			}
		}
	}
	
	public void searchBoard()  {//키보드를 통해 검색할 제목을입력 받고 BoardDao의searchBoard() 메소드로 전달,결과 값을 list로 받고 출력
		System.out.print("검색할 제목 : ");
		String title = sc.nextLine();
		ArrayList<Board> board = bd.searchBoard(title);
		
		if(board.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			for(Board b : board) {
				System.out.println(b);
			}
		}
	}
	
	public void  saveListFile()  {//BoardDao의 saveListFile() 메소드 호출
		bd.saveListFile();
	}
	
	public void sortList(int item, Boolean isDesc)  {//BoardDao의 displayAllList() 메소드를 통해 전체 리스트를 전달 받고 이 전체 리스트를 전달받은 item과 isDesc를 가지고 6개의 정렬 방법 구현
		ArrayList<Board> list = bd.displayAllList();
		
		switch (item) {
		case 1:
			if (isDesc) {
				list.sort(new DescBoardNo());
			}else {
				list.sort(new AscBoardNo());
			}break;
		case 2:
			if (isDesc) {
				list.sort(new DescBoardDate());
			}else {
				list.sort(new AscBoardDate());
			}break;
		case 3:
			if (isDesc) {
				list.sort(new DescBoardTitle());
			}else {
				list.sort(new AscBoardTitle());
			}break;
		}
		
		for (Board l:list) {
			System.out.println(l);
		}
	}
	
}
