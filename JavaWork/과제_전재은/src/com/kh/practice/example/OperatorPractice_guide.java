package com.kh.practice.example;

import java.util.Scanner;

public class OperatorPractice_guide {
	
	// 실습문제 1
	// 키보드로 입력 받은 하나의 정수가 양수이면 “양수다“, 양수가 아니면 “양수가 아니다“를 출력하세요.
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : " );
		int num = sc.nextInt();
		
		String result = num > 0 ? "양수다." : "양수가 아니다";
		System.out.println(result);
		
	}
	
	// 실습문제 2
	// 키보드로 입력 받은 하나의 정수가 양수이면 “양수다“, 
	// 양수가 아닌 경우 중에서 0이면 “0이다“, 0이 아니면 “음수다”를 출력하세요.
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수  : ");
		int num = sc.nextInt();
		
		String result = num > 0 ? "양수다" : (num < 0 ? "음수다" : "0이다");
		System.out.println(result);
	}
	
	
	// 실습문제 3
	// 키보드로 입력 받은 하나의 정수가 짝수이면 “짝수다“, 짝수가 아니면 “홀수다“를 출력하세요.
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();

		String result = num % 2 == 0 ? "짝수다" : "홀수다";
		System.out.println(result);
	}
	
	
	// 실습문제 4
	// 모든 사람이 사탕을 골고루 나눠가지려고 한다. 인원 수와 사탕 개수를 키보드로 입력 받고 
	// 1인당 동일하게 나눠가진 사탕 개수와 나눠주고 남은 사탕의 개수를 출력하세요.
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int people = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		int candy = sc.nextInt();

		System.out.println("1인당 사탕 개수 : " + candy / people);
		System.out.println("남는 사탕 개수 : " + candy % people);
	}
	
	
	// 실습문제 5
	// 키보드로 입력 받은 값들을 변수에 기록하고 저장된 변수 값을 화면에 출력하여 확인하세요.
	// 이 때 성별이 ‘M’이면 남학생, ‘M’이 아니면 여학생으로 출력 처리 하세요.
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학년(숫자만) : ");
		int grade = sc.nextInt();
		
		System.out.print("반(숫자만) : ");
		int classNum = sc.nextInt();
		
		System.out.print("번호(숫자만) : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		double score = sc.nextDouble();
		
		String student = (gender == 'M') ? "남학생" : "여학생";
	
		System.out.println();
		System.out.println(	grade + "학년 " + classNum + "반 " + num + "번 " 
						+ name + " " + student + "의 성적은 " + score + "이다.");
	}
	
	
	// 실습문제 6
	// 나이를 키보드로 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 
	// 성인(19세 초과)인지 출력하세요.
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		String result = (age <= 13) ? "어린이" : (age <= 19 ? "청소년" : "성인");
		System.out.println(result);
	}
	
	
	// 실습문제 7
	/*
	국어, 영어, 수학에 대한 점수를 키보드를 이용해 정수로 입력 받고, 
	세 과목에 대한 합계(국어+영어+수학)와 평균(합계/3.0)을 구하세요.
	세 과목의 점수와 평균을 가지고 합격 여부를 처리하는데 
	세 과목 점수가 각각 40점 이상이면서 평균이 60점 이상일 때 합격, 아니라면 불합격을 출력하세요
	*/
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		System.out.print("수학 : ");
		int math = sc.nextInt();

		System.out.println();		
		
		int sum = kor + eng + math;
		double avg = sum / 3.0;
		// int / int를 하게되면 그 결과 값이 int로 받게 된다. 소수점 표현이 어려워서 데이터 손실이 발생한다.
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		
		String result = (kor >= 40 && eng >= 40 && math >= 40 && avg >= 60) ? "합격" : "불합격";
		System.out.println(result);
		
	}
	

	// 실습문제 8
	// 주민번호를 이용하여 남자인지 여자인지 구분하여 출력하세요.
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요 (- 포함) :  ");
		String str = sc.nextLine();
		
		char pId = str.charAt(7);
		
		String gender = (pId == '1' || pId == '3') ? "남자 " : 
						(pId == '2' || pId == '4') ? "여자" : "잘못 입력하셨습니다";
		System.out.println(gender);
		
	}
	
	
	// 실습문제 9
	/*
	키보드로 정수 두 개를 입력 받아 각각 변수(num1, num2)에 저장하세요.
	그리고 또 다른 정수를 입력 받아 그 수가 num1 이하거나 num2 초과이면 true를 출력하고
	아니면 false를 출력하세요.
	(단, num1은 num2보다 작아야 함)
	*/
	public void practice9() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수1 : ");
		int num1 = sc.nextInt();

		System.out.print("정수2 : ");
		int num2 = sc.nextInt();

		System.out.print("입력 : ");
		int input = sc.nextInt();
		
		System.out.println((input <= num1) || (input > num2));
	}

	
	// 실습문제 10
	// 3개의 수를 키보드로 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요
	public void practice10() {
		Scanner sc = new Scanner(System.in);

		System.out.print("입력1 : ");
		int num1 = sc.nextInt();

		System.out.print("입력2 : ");
		int num2 = sc.nextInt();

		System.out.print("입력3 : ");
		int num3 = sc.nextInt();

		boolean isTrue = (num1 == num2) && (num2 == num3);
		System.out.println(isTrue);

	}
	

	// 실습문제 11
	/*
	 A, B, C 사원의 연봉을 입력 받고 각 사원의 연봉과 인센티브를 포함한 연봉을 계산하여 출력하고 
	인센티브 포함 급여가 3000만원 이상이면 “3000 이상”, 미만이면 “3000 미만”을 출력하세요.
	(A 사원의 인센티브는 0.4, B 사원의 인센티브는 없으며, C 사원의 인센티브는 0.15)
	*/
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("A사원의 연봉 : ");
		int a = sc.nextInt();
		System.out.print("B사원의 연봉 : ");
		int b = sc.nextInt();
		System.out.print("C사원의 연봉 : ");
		int c = sc.nextInt();

		double aIncen = a * 1.4; // a + a * 0.4 --> a * (1 + 0.4) --> a * 1.4
		double bIncen = b;
		double cIncen = c * 1.15; // --> 문제 결과화면처럼
		
		 //double cIncen = c + c * 0.15;
		/***
		 	float, double는 실수를 부동소수점 방식으로 저장하는데 이 때 근사 값으로 저장
		 		부동소수 2진화 계산법 ==> 소수 같은 경우 x2를 해서 앞이 0.인지 1.인지로 2진수 표현
		 		ex. 0.1234567
		 			x2 = 0.2469134  --- 0
		 			x2 = 0.4938268  --- 0
		 			x2 = 0.9876536  --- 0
		 			x2 = 1.9753072  --- 1
		 			-1 = 0.9753072
		 			x2 = 1.9506144  --- 1 ....
		 	==> 소수점 아래 부분을 이진화 시 딱 떨어지지 않을 경우 
		 	      무한 소수가 되어 가수부를 순서대로 채우다가 가수부의 용량(float : 23bit / double : 52bit)까지만 값을 저장
		 	    --> 이 때 1차적으로 오차 발생
		 	
		 	따라서 float, double 사용 시 표현되는 값은 근사 값으로 표현
		 	
		 	0.15를 double형 변수에 부동소수점 방식으로 저장 시
			[부동 소수점 표현]
				부호 1,         지수 11, 
				  0          011 1111 1100 
				                                            가수 52
				0011 0011 0011 0011 0011 0011 0011 0011 0011 0011 0011 0011
				
				이와같이 표현되고
				
				이걸 다시 실제값으로 변환하면
				
				0.14999999999998858690730685339076
				
				오차가 발생한 것을 확인 가능
				
				double 0.15 실제 값 : 0.1499999999999999944488848768742172978818416595458984375
				double 1.15 실제 값 : 1.149999999999999911182158029987476766109466552734375
			
		 */

		System.out.println();

		String s1 = "3000 이상";
		String s2 = "3000 미만";

		System.out.println("A사원의 인센티브포함 연봉 : " + aIncen);
		System.out.println(aIncen >= 3000 ? s1 : s2);
		
		System.out.println("B사원의 인센티브포함 연봉 : " + bIncen);
		System.out.println(bIncen >= 3000 ? s1 : s2);
		
		System.out.println("C사원의 인센티브포함 연봉 : " + cIncen);
		System.out.println(cIncen >= 3000 ? s1 : s2);

	}

}
