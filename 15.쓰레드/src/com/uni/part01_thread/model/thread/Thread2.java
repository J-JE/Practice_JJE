package com.uni.part01_thread.model.thread;

//2. Runnable 인터페이스 구현하기
public class Thread2 implements Runnable{

	@Override
	public void run() {
		
		for(int i =1;i <=10;i++) {
			System.out.println("스레드 2[ " + i + " ]####");
		}
		
	}

}
