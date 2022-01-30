package com.kh.chap02.practice.example;

import java.util.Scanner;

public class LoopPractice {
	
	public void practice1() {
		Scanner sc =new Scanner(System.in);
		System.out.println("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num>=1) {
			for(int i=1;i<=num;i++) {
				System.out.print(i+" ");
			}
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	public void practice2() {
		Scanner sc =new Scanner(System.in);
		System.out.println("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		for(int i=1;num<1;i++) {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("1이상의 숫자를 입력하세요 : ");
			num = sc.nextInt();
		}
		
		if(num>=1) {
			for(int i=1;i<=num;i++) {
				System.out.print(i+" ");
			}
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	public void practice3() {
		Scanner sc =new Scanner(System.in);
		System.out.println("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();

		if(num>=1) {
			for(int i=num;i>0;i--) {
				System.out.print(i+" ");
			}
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	public void practice4() {
		Scanner sc =new Scanner(System.in);
		System.out.println("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		for(int i=1; num<1; i++) {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("1이상의 숫자를 입력하세요 : ");
			num = sc.nextInt();
		}
		if(num>=1) {
			for(int i=num; i>0; i--) {
				System.out.print(i+" ");
			}
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
			
	}
	public void practice5() {
		Scanner sc =new Scanner(System.in);
		System.out.println("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		int sum=num;
		for(int i=1;i<num;i++) {
			System.out.print(i+" + ");
			sum += i;
		}
		System.out.print(num+ " = "+sum);
	}
	public void practice6() {
		Scanner sc =new Scanner(System.in);

		System.out.println("첫 번쩨 숫자 : ");
		int num1 = sc.nextInt();
		System.out.println("두 번쩨 숫자 : ");
		int num2 = sc.nextInt();
		
		int num3 = 0;
		int num4 = 0;
		
		if(num1>0&&num2>0) {
			if(num1>num2) {
				num3 = num1;
				num4 = num2;
			}else if(num2>num1) {
				num3 = num2;
				num4 = num1;
			}
			for(int i=num4;i<=num3;i++) {
				System.out.print(i+" ");
			}
		}else {
			System.out.println("1이상의 숫자만을 입력해주세요.");
		}
	}
	public void practice7() {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("첫 번쩨 숫자 : ");
		int num1 = sc.nextInt();
		System.out.println("두 번쩨 숫자 : ");
		int num2 = sc.nextInt();
		
		int num3 = 0;
		int num4 = 0;
		
		for(; num1<=0||num2<=0;) {
			System.out.println("1이상의 숫자만을 입력해주세요.");
			System.out.println("첫 번쩨 숫자 : ");
			num1 = sc.nextInt();
			System.out.println("두 번쩨 숫자 : ");
			num2 = sc.nextInt();
		}
		
		if(num1>0&&num2>0) {
			if(num1>num2) {
				num3 = num1;
				num4 = num2;
			}else if(num2>num1) {
				num3 = num2;
				num4 = num1;
			}
			for(int i=num4;i<=num3;i++) {
				System.out.print(i+" ");
			}
		}else {
			System.out.println("1이상의 숫자만을 입력해주세요.");
		}
		
	}
	public void practice8() {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("숫자 : ");
		int num = sc.nextInt();
		
		System.out.println("==== "+num+"단 ====");
		for(int i = 1; i < 10; i++) {
			System.out.println(num+" * "+i+" = "+ num*i);
		}
		
	}
	public void practice9() {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("숫자 : ");
		int num = sc.nextInt();
		
		
		if(num>1&&num<10) {
			for(int i = num; i < 10; i++) {
				System.out.println("==== "+i+"단 ====");
				for(int j =1; j<10; j++) {
					System.out.println(i+" * "+j+" = "+ i*j);
				}
			}
		}else {
			System.out.println("2~9 사이의 숫자만 입력해주세요.");
		}
		
	}
	public void practice10() {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("숫자 : ");
		int num = sc.nextInt();
		
		for(;num<2||num>9;) {
			System.out.println("2~9 사이의 숫자만 입력해주세요.");
			System.out.println("숫자 : ");
			num = sc.nextInt();
		}
		
		if(num>1&&num<10) {
			for(int i = num; i < 10; i++) {
				System.out.println("==== "+i+"단 ====");
				for(int j =1; j<10; j++) {
					System.out.println(i+" * "+j+" = "+ i*j);
				}
			}
		}else {
			System.out.println("2~9 사이의 숫자만 입력해주세요.");
		}
		
	}
	public void practice11() {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("시작 숫자 : ");
		int num1 = sc.nextInt();
		System.out.println("공차 : ");
		int num2 = sc.nextInt();
		
		int sum = 1;
		for(int i = num1; sum<11;i+=num2) {
			sum +=1;
			System.out.print(i+" ");
		}

	}
	public void practice12() {
		Scanner sc =new Scanner(System.in);

		System.out.println("연산자(+,-,*,/,%) : ");
		String str =sc.nextLine();

		for(;!str.equals("exit");) {
			System.out.println("정수1 : ");
			int num1 = sc.nextInt();
			System.out.println("정수2 : ");
			int num2 =sc.nextInt();
			sc.nextLine();

			if(num1>1&&num2>1) {
				if(str.equals("+")) {
					System.out.printf("%d %s %d = %d\n\n",num1,str,num2,(num1+num2));
				}else if(str.equals("-")) {
					System.out.printf("%d %s %d = %d\n\n",num1,str,num2,(num1-num2));
				}else if(str.equals("*")) {
					System.out.printf("%d %s %d = %d\n\n",num1,str,num2,(num1*num2));
				}else if(str.equals("/")) {
					System.out.printf("%d %s %d = %d\n\n",num1,str,num2,(num1/num2));
				}else if(str.equals("%")) {
					System.out.printf("%d %s %d = %d\n\n",num1,str,num2,(num1%num2));
				}else {
					System.out.println("없는 연산자입니다. 다시 입력해주세요.");
					System.out.println();
				}
			}else if(num1==0||num2==0) {
				System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
				System.out.println();
			}
			System.out.println("연산자(+,-,*,/,%) : ");
			str =sc.nextLine();

		}
		System.out.println("프로그램을 종료합니다.");
	}

	public void method15() {
		Scanner sc =new Scanner(System.in);
		System.out.println("숫자 : ");
		int num1 = sc.nextInt();
		
		int num2 = 0;
		
		if(num1>=2) {
			for(int i = 1; i < num1; i++) {
				if(num1%i == 0) {
					num2++;
				}
			}
			if(num2==1) {
				System.out.println("소수 입니다.");
			}else {
				System.out.println("소수가 아닙니다.");
			}
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	public void method16() {
		Scanner sc =new Scanner(System.in);
		
		for(;;) {
			System.out.println("숫자 : ");
			int num1 = sc.nextInt();
			
			int num2 = 0;
			if(num1>=2) {
				
				for(int i = 1; i < num1; i++) {
					if(num1%i == 0) {
						num2++;
					}
				}
				if(num2==1) {
					System.out.println("소수 입니다.");
					break;
				}else {
					System.out.println("소수가 아닙니다.");
					break;
				}
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		
	}
	public void method17() {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("숫자 : ");
		int num = sc.nextInt();
		
		
		if(num>=2) {
			int count =0;
			for(int i=2; i<=num; i++) {
				int j;
				for(j = 2; j<=i; j++) {
					if(i%j==0) {
						break;
					}
				}
				if(i == j) {
					count += 1; 
					System.out.print(i+" ");
				}
			}
			System.out.println();
			System.out.println("2부터 "+num+"까지 소수의 개수는 "+count+"개입니다.");
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	public void method18() {
		Scanner sc =new Scanner(System.in);
		System.out.println("자연수 하나를 입력하세요 : ");
		int num = sc.nextInt();

		int count =0;
		for(int i=2; i<=num; i++) {
			if(i%2==0) {
				System.out.print(i+" ");
			}
			if(i%3==0) {
				System.out.print(i+" ");
			}
			if(i%6==0) {
				count +=1;
			}
		}
		System.out.println();
		System.out.println("count : "+count);
	}
	public void method19() {
		Scanner sc =new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
				
		for(int i=1; i<=num; i++) {
			for(int j=1;j<=num-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void method20() {
		Scanner sc =new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i=1;i<=num ;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1;i<=num ; i++) {
			for(int j=1;j<=num-i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void method21() {
		Scanner sc =new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			for(int j=1;j<=num-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			for(int j=1;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void method22() {
		Scanner sc =new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			System.out.print("*");
			for(int j=1;j<=num-2;j++) {
				if(i==1||i==num) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("*");
		}
	}

	public void 다중for문1() {
		
		for(int i=1;i<=9;i++) { //1~9까지
			if(i%2==1){	//홀수인 경우
				for(int j=0;j<=9-i;j++) {//9-i만큼 공백 -> 이등변 삼각형 모양
					if(j%2==1){
						System.out.print(" ");
					}
				}
				for(int j=1; j<=i;j++) {
					System.out.print(j);
				}
				System.out.println();
			}
		}
		
		for(int i=1;i<=9;i++) {//1~9까지 숫자중
			if(i%2==0) {//짝수인 경우
				for(int j=1;j<=i;j++) {
					if(j%2==1) {
						System.out.print(" ");
					}
				}
				for(int j=1;j<=9-i;j++) {
					System.out.print(j);
				}
				System.out.println();
			}
		}
	}
	public void 다중for문2() {
		
		for(int i=1;i<=5;i++) {
			if(i%2==1){	
				for(int j=0;j<=5-i;j++) {
					if(j%2==1){
						System.out.print(" ");
					}
				}
				for(int j=1; j<=i;j++) {
					if(i==5&&j==3) {
						System.out.print(" ");
					}else if(j==1||j==3||j==5) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
				System.out.println(" ");
			}
		}
		
		for(int i=1;i<=5;i++) {
			if(i%2==0) {
				for(int j=1;j<=i;j++) {
					if(j%2==1) {
						System.out.print(" ");
					}
				}
				for(int j=1;j<=5-i;j++) {
					if(j==1||j==3||j==5) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
	}
	public void 다중for문3() {
		
		for(int i=1; i<=5; i++) {
			System.out.print("*");
			for(int j=1;j<=10-2;j++) {
				if(i==1||i==5) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("*");
		}
	}
	
	
	
	
}
