package mvc.view;

import java.util.Scanner;

import mvc.controller.LibraryManager;
import mvc.model.vo.AniBook;
import mvc.model.vo.Book;
import mvc.model.vo.CookBook;
import mvc.model.vo.Member;

public class LibraryMenu {

	private LibraryManager lm = new LibraryManager();
	private Scanner sc = new Scanner(System.in);
	
	
	/*프로그램 실행 시 가장 먼저 호출되는 메소드로 회원 이름, 나이, 성별을 입력 받아 Member객체 생성 후
	 * 해당 객체를 LibraryManager의 insertMember 메소드로 전달
	 * 무한 반복 메뉴를 출력하여 각 메뉴 버튼 선택 시 해당 메소드 호출 (클래스 구조 참고)*/
	public void mainMenu() {
		
		// 이름, 나이, 성별을 키보드로 입력 받은 후 Member 객체 생성
		// LibraryManager의 insertMember() 메소드에 전달
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("성별 : ");
		char gender = sc.nextLine().charAt(0);
		
		Member mem =new Member(name, age, gender);
		lm.insertMember(mem);
		
		/* ==== 메뉴 ==== // 무한 반복 실행
		1. 마이페이지 // LibraryManager의 myInfo() 호출한 후 그 결과값 출력
		2. 도서 전체 조회 // LibraryMenu의 selectAll() 호출
		3. 도서 검색 // LibraryMenu의 searchBook() 호출
		4. 도서 대여하기 // LibraryMenu의 rentBook() 호출
		0. 프로그램 종료하기*/
		
		while(true) {
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("0. 프로그램 종료하기");
			System.out.println("메뉴 선택 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
			case 1 :
				lm.insertMember(mem);
				System.out.println(lm.myInfo());
				break;
			case 2 :
				selectAll();
				break;
			case 3 :
				searchBook();
				break;
			case 4 :
				rentBook();
				break;
			case 0 :
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
	
	
	/*LibraryManager의 selectAll 메소드호출
	 * -> 결과 값을 Book[] 자료형으로 받아준 뒤 for문을 통해 도서 전체 목록 출력*/
	public void selectAll() {
		
		// LibraryManager의 selectAll() 메소드 호출하여 결과 값 Book[] 자료형에 담기
		Book[] bList = lm.selectAll();
		
		// for문 이용하여 bList의 모든 도서 목록 출력
		// 단, i를 이용하여 인덱스도 같이 출력  대여할 때 도서번호를 알기 위해
		// ex ) 0번도서 : 백종원의 집밥 / 백종원 / tvN / true
		for(int i =0; i<bList.length;i++) {
			System.out.println(i+"번도서 : "+bList[i].toString());
		}
	}
	
	
	/*검색할 제목 “키워드”를 입력 받고 그 키워드를 LibraryManager의 searchBook 메소드로 전달
	 * -> 결과 값을 Book[] 자료형으로 받아준 뒤 향상된 for문을 이용하여 출력*/
	public void searchBook() {
		
		// “검색할 제목 키워드 : “ >> 입력 받음 (keyword : String)
		System.out.println("검색할 제목 키워드 : ");
		String keyword =sc.nextLine();
		
		// LibraryManager의 searchBook() 메소드에 전달
		// 그 결과 값을 Book[] 자료형으로 받기
		Book[] searchList = lm.searchBook(keyword);
		
		// for each문(향상된 for문)을 이용하여 검색 결과의 도서 목록 출력
		// NullPointerException 발생 시 오류 해결하시오 ㅎㅎ
		//오류?
		for(Book b:searchList) {
			if(b!=null) {
				if(b instanceof AniBook) {
					System.out.println(((AniBook)b).toString());
				}else {
					System.out.println(((CookBook)b).toString());
				}
			}
		}
	}
	
	
	/*대여할 도서 인덱스를 입력 받아 LibraryManager의 rentBook 메소드로 전달
	 * ->결과 값을 result로 받아 result가 0일 경우, 1일 경우, 2일 경우 각각에 해당하는 출력문 출력*/
	public void rentBook() {
		
		// 도서 대여를 위해 도서번호를 알아야 된다.
		// selectAll() 메소드 호출을 통해 도서 리스트 한번 출력 해주고
		selectAll();
		
		// “대여할 도서 번호 선택 : ” >> 입력 받음 (num : int)
		System.out.println("대여할 도서 번호 선택 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		// LibraryManager의 rentBook(num) 메소드에 전달
		// 그 결과 값을 result로 받고 그 result가
		int result = lm.rentBook(num);
		
		// 0일 경우  “성공적으로 대여되었습니다.” 출력
		// 1일 경우  “나이 제한으로 대여 불가능입니다.” 출력
		// 2일 경우  “성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었습니다. -> 마이페이지를 통해 확인하세요” 출력
		switch (result) {
		case 0:
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 1:
			System.out.println("나이 제한으로 대여 불가능입니다.");
			break;
		case 2:
			System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었습니다. -> 마이페이지를 통해 확인하세요");
			break;
		}
	}
}
