package com.uni.chap02_soket.part02_chat.thread;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

//데이터 입력 작업을 처리하는 Thread
public class Receiver implements Runnable{

	private DataInputStream in;
	
	public Receiver(Socket socket) {
		try {
			in = new DataInputStream(socket.getInputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println(in.readUTF());//sender에서 출력한 값을 화면에 출력한다
			} catch (IOException e) {
//				e.printStackTrace();
				break;
			}
		}
		
	}

}
