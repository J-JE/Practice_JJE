package com.uni.chap02.soket.part01_tcp.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public void ClientStart() {
		//1.서버의 Ip주소와 서버가 정한 포트번호를 먼저 알아야함.
		int port = 8500;
		String serverIp = null;
		try {
			serverIp = InetAddress.getLocalHost().getHostAddress();
		
			//2.서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
			Socket server = new Socket(serverIp, port);//연결에 실패할경우 null 반환 (소켓 객체가 생성이 안됨)
			// 서버 IP : 172.30.1.28
			System.out.println("서버와 연결이 되었습니다");
			//3.서버와의 입출력 스트림 오픈
			if(server != null) {
				//4.보조 스트림을 통해 성능 개선
				BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
				PrintWriter pw = new PrintWriter(server.getOutputStream());
				//5.스트림을 통해 읽고 쓰기


				pw.println("반가워요.");
				pw.flush();

				String message = br.readLine();
				System.out.println("서버가 보낸메세지 : "+message);
				
				//6.통신 종료
				pw.close();//스트림 닫기
				br.close();
				
			}
			
			server.close();//소켓반납
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
