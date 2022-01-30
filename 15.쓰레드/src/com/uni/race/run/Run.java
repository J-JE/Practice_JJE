package com.uni.race.run;

import com.uni.race.model.thread.Heart;
import com.uni.race.model.thread.Star;

public class Run {

	public static int tot1 = 0;
	public static int tot2 = 0;
	
	public static void main(String[] args) {
		
		Heart h = new Heart();
		Star s = new Star();
		
		Thread th1 = new Thread(h);
		Thread th2 = new Thread(s);
		
		try {
			th1.start();
			Thread.sleep(500);
			th2.start();
			
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String str = Run.tot1 > Run.tot2 ? "하트승" : (Run.tot1 < Run.tot2? "별승" : "무승부");
		System.out.println(str);
		
	}

}
