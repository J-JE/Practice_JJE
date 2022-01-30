package com.kh.chap02.practice.example;

import java.util.Scanner;

public class LoopPractice_guide {
	
	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		int user = sc.nextInt();

		if (user >= 1) { // 1_1. �� �Է����� ��� 	
			
			for (int i = 1; i <= user; i++) {
				System.out.print(i + " ");
			}
			
		} else { // 1_2. �װ� �ƴ� ��� (�߸� �Է����� ���)
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
			
		}
	}

	public void practice2() {
		
		Scanner sc = new Scanner(System.in);

		// �켱 ���� �ݺ� ��������
		while (true) {
			
			System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
			int user = sc.nextInt();
			
			if (user >= 1) { // 1_1. �� �Է����� ��� 		=> �������� ��� ��� �� �ݺ��� ����
				
				for (int i = 1; i <= user; i++) {
					System.out.print(i + " ");
				}
				break;
				
			} else { // 1_2. �װ� �ƴ� ��� (�߸� �Է����� ���) => �ٽ� �ݺ��� ����
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
				
			}
		}
	}

	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		int user = sc.nextInt();

		if (user >= 1) { // 1_1. �� �Է����� ���
			
			for (int i = user; i >= 1; i--) {
				System.out.print(i + " ");
			}
			
		} else {// 1_2. �װ� �ƴ� ��� (�߸� �Է����� ���)
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
			
		}
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);

		// �켱 ���� �ݺ� ��������
		while (true) {
			
			System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
			int user = sc.nextInt();
			
			if (user >= 1) { // 1_1. �� �Է����� ��� 		=> �������� ��� ��� �� �ݺ��� ����
				
				for (int i = user; i >= 1; i--) {
					System.out.print(i + " ");
				}
				break;
				
			} else { // 1_2. �װ� �ƴ� ��� (�߸� �Է����� ���) => �ٽ� �ݺ��� ����
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
				
			}
		}
	}
	
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �ϳ� �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		int sum = 0;
		
		for(int i=1; i<=num; i++) { // i���� 1�������� ����ڰ� �Է��� ������ 1�� �����ϴ� ���� �ݺ�
			
			// �Ź� sum ������ �����ؼ� ������
			sum += i; 
			
			// �Ӹ��ƴ϶� ��µ� ���ٲ��� .. �ٵ� �������� �䱸�� ��� ����ϰ��� �Ѵٸ�
			if(i < num) { // i ���� num���� ���� �� ������ �ش� ���� �ڿ� + �ٿ����鼭 ���
				System.out.print(i + " + ");
			}else { // �װ� �ƴ� ���(��, i���� num�� �� ��� �׶� ���������� = �ٿ��� ���
				System.out.print(i + " = ");
			}
		}
		
	}
	
	public void practice6() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù ��° ���� : ");
		int num1 = sc.nextInt();
		
		System.out.print("�� ��° ���� : ");
		int num2 = sc.nextInt();
		
		if(num1 >= 1 && num2 >= 1) { // 1_1. �� �� ��� �� �Է����� ��� 
			
			int min = Math.min(num1, num2);	// �� �� �� ���� �� ���
			int max = Math.max(num1, num2); // �� �� �� ū �� ���
			
			for(int i = min; i <= max; i++) { // i�� min�������� max���� 1�� �����ϴµ��� �ݺ�
				System.out.print(i + " ");
			}	
			
		} else { // 1_2. �װ� �ƴ� ��� (�߸��Է����� ���)
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
			
		}
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		
		// �켱 ���� �ݺ� ��������
		while(true) {
			
			System.out.print("ù ��° ���� : ");
			int num1 = sc.nextInt();
			
			System.out.print("�� ��° ���� : ");
			int num2 = sc.nextInt();
			
			if(num1 >= 1 && num2 >= 1) { // 1_1. �� �� ��� �� �Է����� ��� 	=> �������� ��� ��� �� �ݺ��� ��������
				
				int min = Math.min(num1, num2);	// �� �� �� ���� �� ���
				int max = Math.max(num1, num2); // �� �� �� ū �� ���
				
				for(int i = min; i <= max; i++) {
					System.out.print(i + " ");
				}	
				
				break; 
				
			} else {// 1_2. �װ� �ƴ� ��� (�߸��Է����� ���) => �ٽ� �ݺ��� ����
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
				
				
			}
		}
	}
	
	public void practice8() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		System.out.println("===== " + num + "�� =====");
		
		for(int i = 1; i < 10; i++) {			
			System.out.printf("%d * %d = %d\n", num, i, num * i);
		}
		
	}
	
	public void practice9() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		if(num >= 2 && num <= 9) { // 1_1. �� �Է����� ��� => ����ڰ� �Է��� �ܿ������� 9�ܱ��� ���
			
			
			for(int i = num; i < 10; i++) {						// ���� �����ϴ� for��	(����ڰ� �Է��� ������ 9���� 1�� ����)
				System.out.printf("===== %d�� =====\n", i);
				
				for(int j = 1; j <= 9; j++) {					// �������� ���� �����ϴ� for��	
					System.out.printf("%d * %d = %d\n", i, j, (i * j));
				}
				
				System.out.println();
			}		
			
			
		} else { // 1_2. �װ� �ƴ� ��� (��, �߸��Է����� ���)
			System.out.println("2~9������ ���ڸ� �Է����ּ���.");
			
		}
	}
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		
		// �켱 ���� �ݺ� ��������
		while(true) {			
			
			System.out.print("���� : ");
			int num = sc.nextInt();
			
			if(num >= 2 && num <= 9) { // 1_1. �� �Է����� ��� => ����ڰ� �Է��� �ܿ������� 9�ܱ��� ���
				
				for(int i = num; i <= 9; i++) {					// ���� �����ϴ� for��
					System.out.printf("===== %d�� =====\n", i);
					
					for(int j = 1; j <= 9; j++) {				// �������� ���� �����ϴ� for��
						System.out.printf("%d * %d = %d%n", i, j, (i * j));
					}
					
					System.out.println();
				}	
				break;
				
			} else { // 1_2. �װ� �ƴ� ��� (��, �߸��Է����� ���)
				System.out.println("2~9 ������ ���ڸ� �Է����ּ���.");
			}
		}
	}
	
	public void practice11() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� : ");
		int start = sc.nextInt();
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		for(int i=1; i<=10; i++) { // 10���� ������ �ݺ���Ű�ڴ�!!
			
			System.out.print(start + " "); // ������ start�� ��� ��
			
			start += num; // start�� ������ŭ ����
			
		}
	}
	
	
	
	
	public void practice12() {
		
		Scanner sc = new Scanner(System.in);
		
		// ������ �Է� �ް�
		// 		�ش� �����ȣ�� exit�� ��� (���ǹ�) --> ���α׷� ���� (�ݺ��� ����)
		// ���� �ΰ��� �Է¹ް�
		// 		�����ȣ�� / �鼭 �ι�° ������ 0�� ��� (���ǹ�) --> �������� ��� (�ݺ��� �ٽ� ����)
		// �����ȣ�� ���� �ش� ��� ��¹� ���
		//		��, �ٸ� �����ȣ�� ��� �ݺ��� �ٽ� ����
		
		while(true) {
			
			// 1. ������ �Է¹ޱ�
			System.out.print("������(+, -, *, /, %) : ");
			String op = sc.nextLine();		// �����ȣ �Ӹ� �ƴ϶� exit�̶�� ���ڿ��� ���� ���� �����Ƿ� String ������ ���
			
			// 2. ���� ������ �Է¹ޱ� �� ������ �Է½� exit�� �Է��ߴ��� ���ϱ�
			// => exit�� �Է����� ��� �����ϰڴٴ� �ǻ縦 �������̹Ƿ� ���ѹݺ��� ���������Բ�
			if(op.equals("exit")) {
				System.out.println("���α׷��� �����մϴ�.");
				break; // �ݺ����� ��������
			}
			
			// 3. ���� �Է¹ޱ�
			System.out.print("����1 : ");
			int num1 = sc.nextInt();
			
			System.out.print("����2 : ");
			int num2 = sc.nextInt();
			sc.nextLine();	// �ݺ��� �ٽ� �����ϰ� �Ǹ� sc.nextLine()�� �� �� �����Ƿ� ���� ����ֱ�
			
			// 4. �����ϱ� �� ����ڰ� �Է��� �����ڰ� /�̸鼭 �ι�° ������ 0���� ���ϱ�
			if(op.equals("/") && num2 == 0) {
				System.out.println("0���� ���� �� �����ϴ�. �ٽ� �Է����ּ���.\n");
				continue; // ���� ������� �������� �ʰ� �ٷ� �ݺ����� ���� �ö� (�ٽ� �Է¹޾ƾߵǱ� ������)
			}
			
			// 5. ������� �� ��� ����ϱ�
			int result = 0;
			
			switch(op) {
			case "+": result = num1 + num2; break;
			case "-": result = num1 - num2; break;
			case "*": result = num1 * num2; break;
			case "/": result = num1 / num2; break;
			case "%": result = num1 % num2; break;
			default: System.out.println("���� �������Դϴ�. �ٽ� �Է����ּ���.\n"); continue; // �����ڸ� �߸� �Է½� �Ʒ��� ������ �������� �ʰ� �ݺ����� ���� �ö� (�ٽ� �Է¹޾ƾߵǱ� ������)
			}
			
			System.out.printf("%d %s %d = %d\n", num1, op, num2, result);
			System.out.println();
		}
	}
	
	///////////////////////////////////////////////////////
	

	public void practice15() {
		// ������ �������� ���� 1�� �ڱ��ڽ� �ۿ� ���� �� --> �Ҽ�
		// ���� ��� 4�� ���
		// 4 % 1 == 0
		// 4 % 2 == 0
		// 4 % 3 == 1
		// 4 % 4 == 0
		// 4��� ���ڴ� ����������� ���� 1�� �ڱ� �ڽ� ���� 2�� �ִ�. --> �Ҽ� X
		
		// ���� ��� 5�� ���
		// 5 % 1 == 0
		// 5 % 2 == 1
		// 5 % 3 == 2
		// 5 % 4 == 1
		// 5 % 5 == 0
		// 5��� ���ڴ� ������ �������� ���� 1�� �ڱ� �ڽ� �ۿ� ���� --> �Ҽ� O
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		boolean flag = true; // �Ҽ����� �ƴ��� ������ ���� flag ���� 
		
		if(num >= 2) {	
			
			for(int i = 2; i < num; i++) { // 2 ~ num-1 ���� �ݺ� (��, 1�� �ڱ� �ڽ��� ����)
				
				if(num % i == 0) {	// 2 ~ num-1 ���� �ѹ��� ������ �� ����������� ������ �ѹ��̶� ������
					
					flag = false;	// num�� �Ҽ��� �ƴ϶�� �Ҹ� --> false�� �ٲ����
					break; 			// ���̻� �����غ� ��ġ ��� break �ް� �ݺ��� ���� ����
				}
			}
			
			if(flag) { // flag ���� true�� ���
				System.out.println("�Ҽ��Դϴ�.");
			} else {
				System.out.println("�Ҽ��� �ƴմϴ�.");
			}
			
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
	
	public void practice16() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("���� : ");
			int num = sc.nextInt();
			
			boolean flag = true;
			
			if(num >= 2) {			
				for(int i = 2; i < num; i++) {
					if(num % i == 0) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					System.out.println("�Ҽ��Դϴ�.");
				} else {
					System.out.println("�Ҽ��� �ƴմϴ�.");
				}
				
				break;
				
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}	
		}
	}
	
	public void practice17() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		boolean flag = true;
		int count = 0; // �Ҽ� ���� ���� ��ų ����
		
		if(num >= 2) {
			for(int i = 2; i <= num; i++) {		
				
				for(int j = 2; j < i; j++) {
					
					if(i % j == 0) {
						flag = false;
						break;
					}
				}
				
				if(flag) { // �Ҽ��� ��� 
					System.out.print(i + " ");
					count++;
				}
				
				flag = true; // �ٽ� true�� �ʱ�ȭ
			}
			
			System.out.println();
			System.out.println("2���� " + num + "���� �Ҽ��� ������ " + count + "���Դϴ�.");
			
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}	
	}
	
	public void practice18() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ڿ��� �ϳ��� �Է��ϼ��� : ");
		int user = sc.nextInt();
		int count = 0;
		
		for(int i = 1; i <= user; i++) {   // 1���� ����ڰ� �Է��� ������
			
			if(i % 2 == 0 || i % 3 == 0) { // 2�� ����������ų� 3���� ����������� : 2�� ����̰ų� 3�� ����̸� ���
				System.out.print(i + " ");
			}
			
			if(i % 2 == 0 && i % 3 == 0) { // 2�ε� ����������� 3���ε� ����������� : 2�� 3�� ������϶� count ����
				count++;
			}
		}
		System.out.println();
		System.out.println("count : " + count);
	}
	
	public void practice19() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int user = sc.nextInt();
		
		for(int i=user; i>=1; i--) {
			
			// ���� ���� ���
			for(int j=1; j<=i-1; j++) {
				System.out.print(" ");
			}
			
			for(int k=1; k<=user-i+1; k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public void practice20() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int user = sc.nextInt();
		
		// ���� �ﰢ�� (����ڰ� �Է��� �����ٱ���)
		for(int i=0; i<user; i++) {
			
			for(int j = 0; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		// �Ʒ��� �ﰢ��
		for(int i=user-1; i>0; i--) {
			
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice21() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int user = sc.nextInt();
		
		int num = 1; // "*"����Ҷ� ����� ����
		for(int i=user; i>0; i--) {
			
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			
			for(int k=0; k<num; k++) {
				System.out.print("*");
			}
			
			num += 2;
			System.out.println();
			
		}
		
	}
	
	public void practice22() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int user = sc.nextInt();
		
		for(int i = 0 ; i < user ; i++) {
			
			for(int j = 0; j < user ; j++) {
				
				// ù ��° �ٰ� ������ ���� ��� "*" ���
				if(i == 0 || i == user-1) {
					System.out.print("*");
				}
				else{
					if(j == 0 || j == user-1) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
}
