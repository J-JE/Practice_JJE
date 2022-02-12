package com.uni.chap02_soket.part01_tcp.run;

import com.uni.chap02_soket.part01_tcp.sample.TCPServer;

public class ServerRun {

	public static void main(String[] args) {
		
		TCPServer ts = new TCPServer();
		ts.serverStart();
	}

}
