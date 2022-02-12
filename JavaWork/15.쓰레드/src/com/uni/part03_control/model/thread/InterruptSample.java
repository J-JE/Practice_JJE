package com.uni.part03_control.model.thread;

import java.util.Scanner;

public class InterruptSample {

	public void sleepInterrupt() {
		
		Thread5 th5 = new Thread5();
		Thread thread = new Thread(th5);
		
		thread.start();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아무 값이나 입력하세요.");
		
		String in = sc.nextLine();
		System.out.println("입력한값 : "+in);
		
		thread.interrupt();
	}
}
