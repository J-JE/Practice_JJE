package com.uni.chap02_soket.part02_chat.run;

import com.uni.chap02_soket.part02_chat.controller.chatClientManager;

public class ClientRun {

	public static void main(String[] args) {

		chatClientManager s = new chatClientManager();
		s.startClient();

	}

}
