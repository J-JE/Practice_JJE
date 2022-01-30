package com.hw2.run;

import java.util.Scanner;

import com.hw2.model.vo.Student;

public class Run {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		// 최대 10명의 학생 정보를 기록할 수 있게 배열을 할당한다.
		Student[] std =new Student[10];
		
		int count = 0; // 학생 수를 나타내는 변수  한 명 추가 시 1씩 증가시켜줄꺼임

		// while(true)을 사용하여 학생들의 정보를 계속 입력 받고
		while(true) {
			System.out.println("학년 : ");
			int grade = sc.nextInt();
			System.out.println("반 : ");
			int classroom= sc.nextInt();
			sc.nextLine();
			System.out.println("이름 : ");
			String name =sc.nextLine();
			System.out.println("국어점수 : ");
			int kor= sc.nextInt();
			System.out.println("영어점수 : ");
			int eng= sc.nextInt();
			System.out.println("수학점수 : ");
			int math= sc.nextInt();
			sc.nextLine();
			
			// 입력 받은 정보들을 가지고 배열의 count 인덱스에 매개변수 생성자를 통해 객체 생성
			// 한 명씩 추가 되었기 때문에 count 1증가
			std[count++] =new Student(grade, classroom, name, kor, eng, math); //new 빼먹지 말것.
			
			// 계속 추가할 것인지 물어보고, ‘n’ 입력 시 반복문 빠져나감
			System.out.println("계속 추가할 것입니까? (y/n)");
			char ch =sc.next().charAt(0);
			
			if(ch=='n') {
				break;
			}
		}
		
		// 현재 배열에 담겨있는
		// 학생들의 정보를 모두 출력
		for(int i =0; i<count;i++) {
			System.out.println(std[i].information());
		}
	}

}
