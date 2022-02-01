package com.uni.chap02_soket.part02_chat.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import com.uni.chap02_soket.part02_chat.thread.Receiver;
import com.uni.chap02_soket.part02_chat.thread.Sender;

public class chatClientManager {

	public void startClient() {
		String name = "Client";
		
		int port = 8500;
		String serverIp = null;
		
		try {
			serverIp = InetAddress.getLocalHost().getHostAddress();
			
			System.out.println("Client Start!! ");
			
			Socket socket = new Socket(serverIp, port);

//			Socket socket = new Socket("192.168.43.203","port);//평가에 나오나?
			
			Sender sender = new Sender(socket, name);
			Thread sth = new Thread(sender);
			
			Receiver receiver = new Receiver(socket);
			Thread rth = new Thread(receiver);
			
			sth.start();
			rth.start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
