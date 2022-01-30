package com.uni.part03_control.model.thread;

public class Thread4 implements Runnable{

	@Override
	public void run() {
		
		for(int i =1; i<=10;i++) {
			
			try {
				Thread.sleep(1000); //1000->1초 (1=1/1000), 지정된 시간만큼 스레드를 정지시키는 메소드
				
				System.out.println(i+"초");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
