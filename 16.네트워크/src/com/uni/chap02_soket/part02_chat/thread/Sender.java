package com.uni.chap02_soket.part02_chat.thread;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
//데이터 풀력 작업을 처리하는 Thread 구현
public class Sender implements Runnable{
	
	private String name;//데이터를 보내는 사용자명
	private DataOutputStream out;//데이터 출력용 스트림
	
	private Scanner sc;
	// Sender 객체 생성시 매개변수로 socket과  name을 받아온다
	// server에서 생성 : 요청을 수락한 Client의 소켓, 서버명을 받아 올 것이다.
	// client에서 생성 ㅣ 연결된 server의 소켓, 클라이언트 명을 받아 올 것이다.
	public Sender(Socket socket, String name) {
		
		this.name = name;
		try {
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		sc = new Scanner(System.in);
		
		while(true) {
			try {
				out.writeUTF(name+" > "+ sc.nextLine());
			} catch (IOException e) {
//				e.printStackTrace();
				break;
			}
		}
		
	}

}
