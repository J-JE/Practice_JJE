package com.kh.chap01.practice.example;

import java.util.Scanner;

public class ConditionPractice {

	public void practice1(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("9. 종료");
		System.out.println("메뉴 번호를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num == 1) {
			System.out.println("입력 메뉴입니다.");
		}
		if(num == 2) {
			System.out.println("수정 메뉴입니다.");
		}
		if(num == 3) {
			System.out.println("조회 메뉴입니다.");
		}
		if(num == 4) {
			System.out.println("삭제 메뉴입니다.");
		}
		if(num == 9) {
			System.out.println("프로그램이 종료됩니다.");
		}
	}
	public void practice2(){
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num>=0&&num%2==0) {
			System.out.println("짝수다");
		}else if (num>=0&&num%2==1){
			System.out.println("홀수다");
		}else {
			System.out.println("양수만 입력해주세요.");
		}
	}
	public void practice3(){
		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수 : ");
		int kor =sc.nextInt();
		System.out.println("수학점수 : ");
		int math =sc.nextInt();
		System.out.println("영어점수 : ");
		int eng =sc.nextInt();
		
		int sum = kor+math+eng;
		double avg = sum/3;

		if(kor>=40 && math>=40 && eng>=40 && avg>=60) {
			System.out.println("국어 : "+kor);
			System.out.println("수학 : "+math);
			System.out.println("영어 : "+eng);
			System.out.println("합계 : "+sum);
			System.out.println("평균 : "+avg);
			System.out.println("축하합니다, 합격입니다!");
		}else {
			System.out.println("불합격입니다.");
		}
		
			
		System.out.println("");
	}
	public void practice4(){
		Scanner sc = new Scanner(System.in);
		System.out.println("1~12 사이의 정수 입력 : ");
		int month =sc.nextInt();
		
		String season ="";
		switch(month) {
		case 12:
		case 1:
		case 2:
			System.out.println(month+"월은 겨울입니다.");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println(month+"월은 봄입니다.");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println(month+"월은 여름입니다.");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println(month+"월은 가을입니다.");
			break;
		default :
			System.out.println(month+"월은 잘못 입력된 달입니다.");
		}
		
	}
	public void practice5(){
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 : ");
		String id =sc.nextLine();
		System.out.println("비밀번호 : ");
		String pw =sc.nextLine();
		
		if(id.equals("user1")&&pw.equals("1234")) {
			System.out.println("로그인 성공");
		}else if (id.equals(id)){
			System.out.println("비밀번호가 틀렸습니다.");
		}else if (pw.equals(pw)){
			System.out.println("아이디가 틀렸습니다.");
		}
	}
	public void practice6(){
		Scanner sc = new Scanner(System.in);
		System.out.println("권한을 확인하고자 하는 회원 등급 : ");
		String str = sc.nextLine();
		
		String s1 ="회원관리";
		String s2 ="게시글 관리";
		String s3 ="게시글 작성";
		String s4 ="댓글 작성";
		String s5 ="게시글 조회";
		
		if(str.equals("관리자")) {
			System.out.printf("%s, %s%n%s, %s%n%s%n",s1,s2,s3,s4,s5);
		}else if (str.equals("회원")) {
		System.out.printf("%s, %s%n%s",s3,s4,s5);
		}else if (str.equals("비회원")) {
			System.out.printf("%s",s5);
		}else {System.out.println("잘못 입력했습니다.");
		}
	}
	public void practice7(){
		Scanner sc = new Scanner(System.in);
		System.out.println("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		System.out.println("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		double bmi = weight/(height*height);
		
		System.out.println("BMI 지수 : "+bmi);
		if (bmi<18.5) {
			System.out.println("저체중");
		}else if (bmi<23){
			System.out.println("정상체중");
		}else if(bmi<25) {
			System.out.println("과체중");
		}else if(bmi<30) {
			System.out.println("비만");
		}else {
			System.out.println("고도 비만");
		}
	}
	public void practice8(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("피연산자1 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("피연산자2 입력 : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		System.out.println("연산자를 입력(+.-,*,/,%) : ");
		char ch = sc.nextLine().charAt(0);

		if(num1>=0&&num2>=0) {
			if(ch=='+') {
				System.out.printf("%d %c %d = %d%n",num1,ch,num2,(num1+num2));
			}else if(ch=='-') {
				System.out.printf("%d %c %d = %d%n",num1,ch,num2,(num1-num2));
			}else if(ch=='*') {
				System.out.printf("%d %c %d = %d%n",num1,ch,num2,(num1*num2));
			}else if(ch=='/') {
				System.out.printf("%d %c %d = %d%n",num1,ch,num2,(num1/num2));
			}else if(ch=='%') {
				System.out.printf("%d %c %d = %d%n",num1,ch,num2,(num1%num2));
			}else {
				System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			}
		}else {
			System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
		}
	}
	public void practice9(){
		Scanner sc = new Scanner(System.in);
		System.out.println("중간 고사 점수 : ");
		double num1 =(sc.nextInt())*0.2;
		System.out.println("기말 고사 점수 : ");
		double num2 =(sc.nextInt())*0.3;
		System.out.println("과제 점수 : ");
		double num3 =(sc.nextInt()*0.3);
		System.out.println("출석 회수 : ");
		int num4 =sc.nextInt();
		
		double sum =num1+num2+num3+num4;

		/*
		if(sum>=70) {
			if(num4>=15) {
				System.out.println("중간 고사 점수(20) : "+num1);
				System.out.println("기말 고사 점수(30) : "+num2);
				System.out.println("과제 점수(30) : "+num3);
				System.out.println("출 점수(20) : "+num4);
				System.out.println("PASS");
			}else{
				System.out.println("FAIL [출석 횟수 부족] "+"("+num4+"/20)");
			}
		}else if(num4>=15) {
			System.out.println("FAIL [점수 미달] (총점 "+sum+")");
		}else {
			System.out.println("FAIL [출석 횟수 부족] "+"("+num4+"/20)");
			System.out.println("FAIL [점수 미달] (총점 "+sum+")");
		}
		*/
		
		if(sum>=70 && num4>=14) {
			System.out.println("중간 고사 점수(20) : "+num1);
			System.out.println("기말 고사 점수(30) : "+num2);
			System.out.println("과제 점수(30) : "+num3);
			System.out.println("출 점수(20) : "+num4);
			System.out.println("총점 : " + sum);
			System.out.println("PASS");
		}else if(num4>=15) {
			System.out.println("FAIL [점수 미달] (총점 "+sum+")");
		}else if(sum>=70){
			System.out.println("FAIL [출석 횟수 부족] "+"("+num4+"/20)");
		}else {
			System.out.println("FAIL [출석 횟수 부족] "+"("+num4+"/20)");
			System.out.println("FAIL [점수 미달] (총점 "+sum+")");
		}
	}
	public void practice10(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 메뉴 출력");
		System.out.println("2. 짝수/홀수");
		System.out.println("3. 합격/불합격");
		System.out.println("4. 계절");
		System.out.println("5. 로그인");
		System.out.println("6. 권한 확인");
		System.out.println("7. BMI");
		System.out.println("8. 계산기");
		System.out.println("9. Pass/Fail");
		System.out.println("선택 : ");
		int num = sc.nextInt();
		
		ConditionPractice a = new ConditionPractice();
		
		/*	
		switch (num) {
		case 1 :
			a.practice1();
			break;
		case 2 :
			a.practice2();
			break;
		case 3 :
			a.practice3();
			break;
		case 4 :
			a.practice4();
			break;
		case 5 :
			a.practice5();
			break;
		case 6 :
			a.practice6();
			break;
		case 7 :
			a.practice7();
			break;
		case 8 :
			a.practice8();
			break;
		case 9 :
			a.practice9();
			break;
		}
		 */
		
		if(num==1) {
			a.practice1();
		}else if (num==2) {
			a.practice2();
		}else if (num==3) {
			a.practice3();
		}else if (num==4) {
			a.practice4();
		}else if (num==5) {
			a.practice5();
		}else if (num==6) {
			a.practice6();
		}else if (num==7) {
			a.practice7();
		}else if (num==8) {
			a.practice8();
		}else if (num==9) {
			a.practice9();
		}
		
	}
}
