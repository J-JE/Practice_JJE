package com.uni.chap03.branch;

public class B_Contine {
	//continue : 반복문 안에서만 사용 가능 하며 continue 를 만나게 되면 그다음 구문은 
	//			 실행하지 말고 가장 가까운 반복문으로 올라가라는 의미

	
	public void method1() {
		//1~10까지의 홀수 출력
		for(int i =1; i<=10; i++) {
			if(i%2==1) {
				System.out.print(i+" ");
			}
		}
		
		
		for(int i =1; i<=10; i++) {
			if(i%2==0) {
				continue;
			}
			System.out.print(i+" ");
		}
		
	}
	
	
	public void method2() {
		//1부터 100까지의 정수들의 합 출력
		//단, 6의 배수는 제외하고 덧셈연산 계산

		int sum = 0;
		
		for(int i = 1; i<=100; i++) {
			if(i%6==0) {
				continue;
			}
			sum+= i;
		}
		System.out.println(sum);
	}
	
	public void method3() {
		//2~9 단까지의 구구단 출력 중
		// 4의 배수 단을 빼고 출력하시오~

		for(int dan = 2; dan < 10; dan++) {
			if(dan%4==0) {
					continue;
			}
			System.out.println("==== "+dan+"단 ====");
			for(int su =1; su<10; su++) {
				System.out.println(dan+" * "+su+" = "+ dan*su);
			}
		}

	}
	
	public void method4() {
		//2~9 단 까지의 구구단을 출력 할 건데 단 * 수에서 수가 짝수인것을 제외하고 출력하세요~
		
		for(int dan = 2; dan < 10; dan++) {
			System.out.println("==== "+dan+"단 ====");
			for(int su =1; su<10; su++) {
				if(su%2==1) {
					continue;
				}
				System.out.println(dan+" * "+su+" = "+ dan*su);
			}
		}
	}

}
