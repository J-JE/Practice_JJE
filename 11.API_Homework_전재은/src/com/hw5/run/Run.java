package com.hw5.run;

import java.util.Scanner;

import com.hw5.controller.NumberOk;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		NumberOk no = new NumberOk();

		while(true) {
			no.numGame();
			System.out.println("계속 하시겠습니까?(y/n) : ");
			char ch = sc.nextLine().charAt(0);
			
			if("n".equalsIgnoreCase(String.valueOf(ch))) {
				System.out.println("게임을 종료합니다.");
				return;
			}else {
				System.out.println("새로운 게임을 시작합니다!!");
			}
		}
		
		
		// NumberOk 객체를 이용하여 메소드 실행
		// String의 equalsIgnoreCase() 메소드로 계속하는지 판단하는 y,n입력값 판단하기
	}

}
