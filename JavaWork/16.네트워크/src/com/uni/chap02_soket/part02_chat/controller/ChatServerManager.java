package com.uni.chap02_soket.part02_chat.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.uni.chap02_soket.part02_chat.thread.Receiver;
import com.uni.chap02_soket.part02_chat.thread.Sender;

public class ChatServerManager {
	
	public void startSever() {
		
		//서버이름정하기
		String name = "Sever";
		//1.포트번호
		int port = 8500;
		
		//2. 서버용 소켓객체 생성후 포트와 결합
		
		try {
			ServerSocket server = new ServerSocket(port);
			
			//3. 클라이언트 접속 요청이 오길 기다림
			//4. 접속 요청 오면 수락후 클라이언트에 대한 소켓 객체생성
			
			Socket client = server.accept();
			System.out.println("클라이언트와 연결이 됐습니다.");
			
			//송수신 작업용 스레드 만들기 
			//: 채팅프로그램은 무전기처럼 송신을 받고 수신을 하는것이 아니라 전화기처럼 송신을 받으면서 동시에 수신도 할수있어야 
			// 하기때문에 이를 위해 송신과 수신을 별도의 스레드로 처리하면 동시에 처리가 가능하다.
			
			//5. 서버가 사용할 송수신 작업용 스레드 생성후 start()
			Sender sender = new Sender(client, name);
			Thread sth = new Thread(sender);
			
			Receiver receiver = new Receiver(client);
			Thread rth = new Thread(receiver);
			
			sth.start();
			rth.start();
			
			server.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
