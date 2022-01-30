package com.uni.myException.run;

import java.util.Scanner;

import com.uni.myException.exception.MyException;

public class Run {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 하나를 입력하세요 ");
		
		int num = sc. nextInt();
		
		try {
			checkNum(num);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void checkNum(int num) throws MyException {
		if(num<10) {
			throw new MyException(num + "은(는) 10보다 작은수입니다.");
		}else {
			System.out.println("10보다 크거나 같은 수이구나~~");
		}
		
	}

}
