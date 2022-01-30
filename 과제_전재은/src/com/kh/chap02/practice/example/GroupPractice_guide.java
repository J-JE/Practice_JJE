package com.kh.chap02.practice.example;

public class GroupPractice_guide {
	
	
	public void teacher_1() {
		
		for(int i=-4; i<=4; i++) {		 // -4 ~ 4까지 반복 (9번 반복)
			
			int k = i < 0 ? -i : i;		 // k 변수에 i의 절대값 대입
			
			for(int j=k; j>0; j--) {	 // 공백을 출력하는 반복문
				System.out.print(" ");
			}
			
			for(int j=1; j<=9-2*k; j++) { // 숫자를 출력하는 반복문
				System.out.print(j);
			}
			
			System.out.println();
		}
		
	}
	
	public void teacher_2() {
		
		for(int i=-2; i<=2; i++) {		// -2 ~ 2 까지 반복 (5번 반복)
			
			int k = i < 0 ? -i : i;		// k 변수에 i 절대값 대입
			
			for(int j=k; j>0; j--) {	// 공백을 출력하는 반복문
				System.out.print(" ");
			}
			
			for(int j=1; j<=5-2*k; j++) { // 별을 출력하는 반복문
				
				if(j==1 || j==5-2*k) {		// 첫번째 열과 마지막 열에만 별 찍히고
					System.out.print("*");
				}else {						// 나머지는 별 찍히게
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
	
	public void teacher_3() {
		
		for(int i=1; i<=5; i++) {		// 5행 반복 (5번 반복)
			
			for(int j=1; j<=10; j++) {	// 10열 반복 (10번 반복)
				
				if(i==1 || i==5) {			// 첫번째 행과 마지막 행에는
					System.out.print("*");	// 모든 열에 다 별 찍히도록
					
				}else {						// 그외의 행에는
					if(j==1 || j==10) {		// 첫번째 열과 마지막 열에만 별찍고
						System.out.print("*");
					}else {					// 그 외의 열에는 공백이 찍히도록
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
}
