package com.kh.chap02.practice.example;

public class GroupPractice_guide {
	
	
	public void teacher_1() {
		
		for(int i=-4; i<=4; i++) {		 // -4 ~ 4���� �ݺ� (9�� �ݺ�)
			
			int k = i < 0 ? -i : i;		 // k ������ i�� ���밪 ����
			
			for(int j=k; j>0; j--) {	 // ������ ����ϴ� �ݺ���
				System.out.print(" ");
			}
			
			for(int j=1; j<=9-2*k; j++) { // ���ڸ� ����ϴ� �ݺ���
				System.out.print(j);
			}
			
			System.out.println();
		}
		
	}
	
	public void teacher_2() {
		
		for(int i=-2; i<=2; i++) {		// -2 ~ 2 ���� �ݺ� (5�� �ݺ�)
			
			int k = i < 0 ? -i : i;		// k ������ i ���밪 ����
			
			for(int j=k; j>0; j--) {	// ������ ����ϴ� �ݺ���
				System.out.print(" ");
			}
			
			for(int j=1; j<=5-2*k; j++) { // ���� ����ϴ� �ݺ���
				
				if(j==1 || j==5-2*k) {		// ù��° ���� ������ ������ �� ������
					System.out.print("*");
				}else {						// �������� �� ������
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
	
	public void teacher_3() {
		
		for(int i=1; i<=5; i++) {		// 5�� �ݺ� (5�� �ݺ�)
			
			for(int j=1; j<=10; j++) {	// 10�� �ݺ� (10�� �ݺ�)
				
				if(i==1 || i==5) {			// ù��° ��� ������ �࿡��
					System.out.print("*");	// ��� ���� �� �� ��������
					
				}else {						// �׿��� �࿡��
					if(j==1 || j==10) {		// ù��° ���� ������ ������ �����
						System.out.print("*");
					}else {					// �� ���� ������ ������ ��������
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
}
