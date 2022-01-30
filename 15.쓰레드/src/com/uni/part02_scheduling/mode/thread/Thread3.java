package com.uni.part02_scheduling.mode.thread;

public class Thread3 implements Runnable{

	/*코어: 중앙 처리 장치의 역할을 하는 블록으로 
	 *  ㅡ싱글 코어 환경:한번에 두가지 작업을 동시에 처리할 수있다 CPU 코어가 한개면 싱글, 두개면 듀얼, 네개면 쿼드라고 하며,
	 *  코어 수가 많을수록 한번에 여러가지 일을 동시에 진행하여 처리 속도가 빠르다 
	 * 싱글 코어 환경에서 우선순위 방식을 사용하면
	 * 우선 순위가 높은 스레드 일수록 더 많은 양의 실행 시간이 주어진다.
	 * (멀티 코어 환경에서는 우선순위에 따른 차이가 거의 나타나지 않음)
	 */
	
	@Override
	public void run() {
		
		for(int i =0; i<Integer.MAX_VALUE;i++) {//delay코드 (지연시키기위한 코드)
			for(int j =0; j<Integer.MAX_VALUE;j++) {
				
			}
		}
		
		System.out.println(Thread.currentThread().getName());
	}
	
}
