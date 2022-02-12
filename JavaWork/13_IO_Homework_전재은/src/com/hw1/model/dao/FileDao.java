package com.hw1.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDao {
	
	Scanner sc = new Scanner(System.in);
	
	public FileDao() {
	}
	
	
	public void fileSave() {
		
		StringBuilder sb = new StringBuilder(); //입력값을 추가로 받아야 하기 때문에 수정이 불가능한 String 대신 StringBuilder
		
		// “파일에 저장할 내용을 반복해서 입력하시오("exit"을 입력하면 내용 입력 끝) :”
		System.out.println("파일에 저장할 내용을 반복해서 입력하시오(\"exit\"을 입력하면 내용 입력 끝) : ");
		
		while(true) {
			String input =sc.nextLine();
			
			if(input.equals("exit")) {// 값을 Scanner로 입력 받고 해당 입력 값이 “exit”일 경우 반복문 빠져나감
				break;
			}else {
				sb.append(input+"\n");// 아닐 경우 sb에 추가
			}
		}
		
		System.out.println("저장하시겠습니까? (y/n)");// “저장하시겠습니까? (y/n)”
		char yn = sc.nextLine().charAt(0);
		
		if(String.valueOf(yn).equalsIgnoreCase("y")) {// 입력 받은 값이 대문자이든 소문자이든 상관없이 “y”이면,
			
			System.out.println("저장할 파일명을 입력하시오 : ");// 저장할 파일명을 입력 받음
			String title = sc.nextLine();
//			title +=".txt";
			
			
			// “입력받은 파일명.txt 파일에 성공적으로 저장하였습니다.” 콘솔창 출력
			BufferedWriter bw =null;
			try {
				bw =new BufferedWriter(new FileWriter(title+".txt"));// BufferedWriter와 FileWriter 스트림 사용
				//보조 스트림은 단독 사용불가. 기반 스트림 필수
				
				bw.write(sb.toString()); // “입력받은 파일명.txt” 파일에 해당 sb 데이터출력
				//fw.write(sb); -> sb를 String타입으로 변환해야함
				
				System.out.println(title+".txt 파일에 성공적으로 저장하였습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(bw != null)
					try {
						bw.close();// 열었던 스트림 close
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			
		}else {
			System.out.println("다시 메뉴로 돌아갑니다.");// 입력 받은 값이 y가 아니면 “다시 메뉴로 돌아갑니다.” 출력하고 메뉴로..
		}
	}
	
	
	public void fileOpen() {
		System.out.println("열기 할 파일명 : ");
		String title = sc.nextLine();// 파일명을 Scanner로 입력 받아, BufferedReader와 FileReader 스트림 사용
		
		BufferedReader br =null;
		try {
			br = new BufferedReader(new FileReader(title+".txt"));
		
			String temp =null;
			while((temp = br.readLine()) != null) {
				System.out.println(temp);// try구문 안에서 readLine()메소드를 통해 한줄씩 콘솔로 입력받은 값 출력
			}
			
		}catch( FileNotFoundException e ) {
			System.out.println("존재하는 파일이 없습니다.");// 존재하지 않은 파일 명 입력했을 때 해당 예외처리구문이 실행됨
		}catch( IOException e ) {
		e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();// 열었던 스트림 close
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public void fileEdit() {

		StringBuilder sb = new StringBuilder();

		System.out.println("수정 할 파일명 : ");
		String title = sc.nextLine();

		// 파일명을 입력받아 BufferedReader와 BufferedWriter, FileReader와 FileWriter 
		// 스트림 사용

		BufferedReader br =null;
		BufferedWriter bw =null; //try문 안에 있으면 finally로 닫을 수 없음
		try {
			br = new BufferedReader(new FileReader(title+".txt"));

			String temp =null;
			while((temp = br.readLine()) != null) {
				System.out.println(temp);// try구문 안에서 readLine()메소드를 통해 한줄씩 콘솔로 입력받은 값 출력
			}

			System.out.println("파일에 추가할 내용을 입력하시오 : ");

			while(true) {
				String edit =sc.nextLine(); //whil문 밖에 있으면 안됨.
				if(edit.equals("exit")) {
					break;
				}else {
					sb.append(edit+"\n");
				}
			}

			System.out.println("변경된 내용을 파일에 추가하시겠습니까? (y/n)");
			char yn = sc.nextLine().charAt(0);

			if(String.valueOf(yn).equalsIgnoreCase("y")) {
				bw =new BufferedWriter(new FileWriter(title+".txt",true));//true를 넣어서 덮어씌우기 아닌 추기
				bw.write(sb.toString());
				
				System.out.println(title+".txt 파일의 내용이 변경되었습니다.");
			}else {
				System.out.println("다시 메뉴로 돌아갑니다.");
			}

		}catch( FileNotFoundException e ) {
			System.out.println("존재하는 파일이 없습니다.");
		}catch( IOException e ) {
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();// 열었던 스트림 close
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bw != null) {
				try {
					bw.close();// 열었던 스트림 close
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
