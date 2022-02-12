package mvc.view;

import java.util.Scanner;

import mvc.controller.MemberController;

public class MemberView {
	
	MemberController mc = new MemberController();
	
	Scanner sc=new Scanner(System.in);
	
	public MemberView() { //기본생성자
		// TODO Auto-generated constructor stub
	}
	
	public void mainMenu() {
		/*
		 로그인을 위해 아이디와 비밀번호를 sc를 통해 입력 받고
		로그인 성공하면 회원 프로그램에 해당하는 메인 메뉴 출력(메인 메뉴는 반복출력),
		각 메뉴를 선택했을 때 해당하는MemberController 클래스의 메소드 및 MemberView 클래스의메소드 실행
		 */
		System.out.println("아이디 입력하시오 :");
		String id =sc.nextLine();
		System.out.println("비밀번호 입력하시오 :");
		String pwd =sc.nextLine();
		
		// 입력받은 아이디, 비밀번호 값을
		// MemberController 클래스의 login 메소드에 전달하고
		// 그 결과값을 result변수에 받는다.
		//MemberController mc = new MemberController();
		int result =mc.login(id, pwd); //logint은 String값을 받고 int값 반환함
		
		// 성공적으로 로그인 했을 경우 => 즉, result 변수 값이 1일 경우 아래의 메뉴출력
		if(result ==1) {
			/*
			=== 회원 프로그램 ===
			1. 내 정보 보기 // MemberController의 readInfo() 호출
			2. 내 나이 조회하기 // MemberController의 readAge() 호출
			3. 키 수정하기 // MemberView의 updateHeight() 호출
			9. 프로그램 종료하기 // “프로그램을 종료합니다” 출력 후 종료
			메뉴 번호 선택 : >> 입력 받음
			 */
			// 위의 메뉴 무한 반복 실행
			while(true) {
				System.out.println("=== 회원 프로그램 ===");
				System.out.println("1. 내 정보 보기");
				System.out.println("2. 내 나이 조회하기");
				System.out.println("3. 키 수정하기");
				System.out.println("4. 프로그램 종료하기");
				System.out.print("메뉴 번호 선택 : ");
				int num = sc.nextInt();
				sc.nextLine();
				
				switch(num) {
				case 1:
					System.out.println(mc.readInfo().information());
					//redInfo는 Member에서 호출됨. Member의 information도 호출 가능...중요
					break;
				case 2:
					System.out.println(mc.readAge()+"살");
					
					break;
				case 3:
					updateHeight();
					break;
				case 4:
					System.out.println("프로그램을 종료합니다");
					return;
				}
			}
		}else {
			// 로그인에 실패 했을 경우 => 즉, result 변수 값이 0일 경우 => 프로그램 종료
			System.out.println("프로그램을 종료합니다");
			return;
		}
		
	}

	public void updateHeight() {
		//메인 메뉴에서 3번을 입력 받으면 실행되는 메소드
		//“수정할 키를 입력하시오 : “ >> 입력 받음 (height : double)
		System.out.println("수정할 키를 입력하시오 : ");
		double height =sc.nextDouble();
		
		//MemberController mc = new MemberController(); ->여기 있으면 값이 제대로 안들어감. 왜그런지 모르겠음
		
		mc.updateHeight(height);
		// 입력 받은 키 값을
		// MemberController 클래스의 updateHeight() 메소드에 전달
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
