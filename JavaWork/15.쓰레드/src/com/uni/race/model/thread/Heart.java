package com.uni.race.model.thread;

import com.uni.race.run.Run;

public class Heart implements Runnable{

	@Override
	public void run() {
		
		int ran =0;
		try {
			for(int i =0; i<10;i++) {
				for(int k =0; k<30;k++) {
					System.out.println(); //개행을 위한 for문
				}
				//처음 출력시
				if(i == 0) {
					System.out.println(" 준비 ");
					System.out.println("♡");
					System.out.println("★");

				}else {
					ran =(int)(Math.random()*5)+1;
					Run.tot1 +=ran;//랜덤값 누적시키기

					//생성되서 누적된 수만큼 -로 표시
					//-출력 후 하트 출력
					for(int j =0; j<Run.tot1;j++) { //랜덤값만큼 증가한 막대기 끝에 하트 ---♡
						System.out.print("-");
					}
					System.out.println("♡");

					//별출력
					for(int j =0; j<Run.tot2;j++) { 
						System.out.print("-");
					}
					System.out.println("★");

				}

				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
