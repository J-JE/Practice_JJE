package com.uni.chap02_soket.part01_tcp.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer {
	
	public void serverStart() {
		//1. 서버의 포트번호 정함
		int port = 8500;

		//2. 서버용 소켓 객체 생성
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			//3.클라이언트 쪽에서 접속 요청이 오길 기다림
			System.out.println("클라이언트의 요청을 기다리고 있습니다.");

			//4.접속 요청이 오면 요청 수락 후 해당 클라이언트에 대한 소켓 객체 생성
			Socket client = server.accept();

			String clientIp = client.getInetAddress().getHostAddress();
			System.out.println(clientIp+"가 연결을 요청함");

			//5.연결된 클라이언트와 입출력 스트림 생성

			InputStream input = client.getInputStream(); 
			OutputStream output = client.getOutputStream();

			//6.보조 스트림을 통해 성능 개선

			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			PrintWriter pw = new PrintWriter(output);

			//7.스트림을 통해 읽고 쓰기

			String message = br.readLine();
			System.out.println(clientIp+"가 보낸메세지 : "+message);

			pw.println("만나서 반갑습니다.");
			pw.flush(); //현재 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 비운다.

			//8.통신 종료
			pw.close();//스트림 닫기
			br.close();
			server.close();//소켓반납
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
