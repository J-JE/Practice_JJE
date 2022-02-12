package com.uni.chap03_char.run;

import com.uni.chap03_char.model.dao.FileChatTest;

public class Run {

	public static void main(String[] args) {
		
		FileChatTest f = new FileChatTest();
		f.fileSave();
		f.fileOpen();
	}

}
