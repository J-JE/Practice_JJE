package com.uni.chap01_inet.sample;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetSample {
	// 1. 네트워크(Network)란?
	// -> net + work 의 합성어 : net(그물) + work(일)
	// -> 단일로 쓰여진 매체를 통신이라는 매개체를 통하여 서로 연결되어 있는 환경
	
	// 2. 네트워킹(Networking) 이란?
	// -> 두 대 이상의 컴퓨터를 케이블로 연결하여 네트워크(Network)를 구성하는 작업
	
	// 3. 네트워킹의 목적
	// -> 여러 개의 통신기기(컴퓨터,휴대폰 등) 들을 서로 연결하여 데이터를 손쉽게 주고 받거나 또는
	// 		자원 (프린터 등) 등을 공유하기 위함
	// -> 추가적으로 빠른 데이터 교환 목적도 있음
	
	// -> 자바에서 제공하는 java.net 패키지를 사용하면 어플리케이션끼리 데이터 통신을 할 수 있다.
	
	// 4. 네트워크에서 필요한 개념
	// 서버(Server) : 서비스를 제공하는 컴퓨터
	// 클라이언트(Client) : 서비스를 사용하는(제공받는) 컴퓨터
	// -> 서비스를 제공(서버)하려면 서버용 프로그램이 있어야 하며 서비스를 이용(클라이언트)하려면
	// 		클라이언트용 프로그램이 각 각 있어야 한다.
	
	// 5. 네트워크 통신흐름(소켓통신)
	// (서버 -> 클라이언트로 갈 때)
	// 서버 -> 소켓 -> 포트 -> IP -> 네트워크 -> IP -> 포트 -> 소켓 -> 클라이언트의 프로세스

	public void isSample() {
		try {
			InetAddress localIp = InetAddress.getLocalHost();
			System.out.println("내파일명 : "+localIp.getHostName());
			System.out.println("내IP : "+localIp.getHostAddress());
			
			InetAddress naverIP = InetAddress.getByName("www.naver.com");
			System.out.println("네이버서버명 : "+naverIP.getHostName());
			System.out.println("네이버IP : "+naverIP.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
