package com.uni.part01_thread.model.thread;

//스레드 생성
//1. Thread 상속받기
public class Thread1 extends Thread{

	@Override
	public void run() {
		
		for(int i =1;i <=10;i++) {
			System.out.println("스레드 1[ " + i + " ]");
		}
		
	}
	
}
