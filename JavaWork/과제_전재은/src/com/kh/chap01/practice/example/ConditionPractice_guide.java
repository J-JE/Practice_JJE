package com.kh.chap01.practice.example;

import java.util.Scanner;

public class ConditionPractice_guide {
	
	
	
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. �Է�");
		System.out.println("2. ����");
		System.out.println("3. ��ȸ");
		System.out.println("4. ����");
		System.out.println("9. ����");
		
		System.out.print("�޴� ��ȣ�� �Է��ϼ��� : ");
		int menu = sc.nextInt();
		
		// 1. if-else if�� �̿��ϴ� ���
		/*
		if(menu == 1) {
			System.out.println("�Է� �޴��Դϴ�.");
		}else if(menu == 2) {
			System.out.println("���� �޴��Դϴ�.");
		}else if(menu == 3) {
			System.out.println("��ȸ �޴��Դϴ�.");
		}else if(menu == 4) {
			System.out.println("���� �޴��Դϴ�.");
		}else if(menu == 9) {
			System.out.println("���α׷��� ����˴ϴ�.");
		}else {
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}
		*/
		
		// 2. switch�� �̿��ϴ� ���
		/*
		switch(menu) {
		case 1 : System.out.println("�Է� �޴��Դϴ�."); break;
		case 2 : System.out.println("���� �޴��Դϴ�."); break;
		case 3 : System.out.println("��ȸ �޴��Դϴ�."); break;
		case 4 : System.out.println("���� �޴��Դϴ�."); break;
		case 9 : System.out.println("���α׷��� ����˴ϴ�."); break;
		default : System.out.println("�߸��Է��ϼ̽��ϴ�."); break;
		}
		*/
		
		
		// 3. switch�� �̿��� �� String ���� �̿��ϴ� ���
		String str = "";
		
		switch(menu) {
		case 1 : str = "�Է�"; break;
		case 2 : str = "����"; break;
		case 3 : str = "��ȸ"; break;
		case 4 : str = "����"; break;
		case 9 : System.out.println("���α׷��� ����˴ϴ�."); return;
		default : System.out.println("�߸��Է��ϼ̽��ϴ�."); return;
		}
		
		System.out.println(str + " �޴��Դϴ�.");
		
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڸ� �� �� �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		
		/*if(num > 0 && num % 2 == 0) {
			System.out.println("¦����.");
		}else if(num > 0 && num % 2 == 1) {
			System.out.println("Ȧ����.");
		}else {
			System.out.println("����� �Է����ּ���.");
		}*/
		
		
		// ��ø if������ �������� ������ �����˻��ϰ�!
		if(num > 0) { 
			if(num % 2 == 0) {
				System.out.println("¦����.");
			}else {
				System.out.println("Ȧ����.");
			}
		}else {
			System.out.println("����� �Է����ּ���.");
		}
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� : ");
		int kor = sc.nextInt();
		System.out.print("���� ���� : ");
		int math = sc.nextInt();
		System.out.print("���� ���� : ");
		int eng = sc.nextInt();
		
		int sum = kor + math + eng;
		double avg = sum / 3.0;
		
		if (kor >= 40 && eng >= 40 && math >= 40 && avg >= 60) {
			System.out.println("���� : " + kor);
			System.out.println("���� : " + math);
			System.out.println("���� : " + eng);
			System.out.println("�հ� : " + sum);
			System.out.println("��� : " + avg);
			System.out.println("�����մϴ�, �հ��Դϴ�!");
		} else {
			System.out.println("���հ��Դϴ�.");
		}
		
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1 ~ 12 ������ ���� �Է� : ");
		int num = sc.nextInt();
		
		// 1. �̷� ���
		/*switch(num) {
		case 12:
		case 1:
		case 2:
				System.out.println(num + "���� �ܿ��Դϴ�.");
				break;
		case 3:
		case 4:
		case 5: 
				System.out.println(num + "���� ���Դϴ�.");
				break;
		case 6:
		case 7:
		case 8:
				System.out.println(num + "���� �����Դϴ�.");
				break;
		case 9:
		case 10:
		case 11:
				System.out.println(num + "���� �����Դϴ�.");
				break;
		default : 
				System.out.println(num + "���� �߸� �Էµ� ���Դϴ�.");
				break;
		}*/
		
		// 2. String ���� ����ؼ� ��¹��� �ѹ���
		String season = null;
		
		switch(num) {
		case 12:
		case 1:
		case 2:
				season = "�ܿ�";
				break;
		case 3:
		case 4:
		case 5: 
				season = "��";
				break;
		case 6:
		case 7:
		case 8:
				season = "����";
				break;
		case 9:
		case 10:
		case 11:
				season = "����";
				break;
		default : 
				season = "�߸� �Էµ� ��";
				break;
		}
		
		System.out.println(num + "���� " + season + "�Դϴ�.");
	}
	
	public void practice5() {
		String userId = "user1";
		String userPwd = "1234";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���̵� : ");
		String id = sc.nextLine();
		
		System.out.print("��й�ȣ : ");
		String pwd = sc.nextLine();
		
		if(userId.equals(id) && userPwd.equals(pwd)) {
			System.out.println("�α��� ����");
		}else if(userId.equals(id)) {
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}else if(userPwd.equals(pwd)) {
			System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
		}
		
		
	}
	
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ Ȯ���ϰ��� �ϴ� ȸ�� ��� : ");
		
		switch(sc.nextLine()) { // �̷��� �ٷ� �Է��ؼ� ���� ����..
		case "������" : System.out.println("ȸ������, �Խñ� ����");
		case "ȸ��"  : System.out.println("�Խñ� �ۼ�, ��� �ۼ�");
		case "��ȸ��" : System.out.println("�Խñ� ��ȸ"); break; // ���⼭ break�ؾ� default������ �Ѿ�� �ʴ´�.
		default : System.out.println("�߸� �Է��ϼ̽��ϴ�."); break;
		}
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Ű(m)�� �Է����ּ��� : ");
		double height = sc.nextDouble();
		
		System.out.print("������(kg)�� �Է����ּ��� : ");
		double weight = sc.nextDouble();
		
		double bmi = weight / (height * height);
		
		System.out.println("BMI ���� : " + bmi);
		
		if(bmi < 18.5) {
			System.out.println("��ü��");
		}else if(bmi < 23) {
			System.out.println("����ü��");
		}else if(bmi < 25) {
			System.out.println("��ü��");
		}else {
			System.out.println("��");
		}
	}
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);

		System.out.print("�ǿ�����1 �Է� : ");
		int num1 = sc.nextInt();
		
		System.out.print("�ǿ�����2 �Է� : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("�����ڸ� �Է�(+,-,*,/,%) : ");
		char ch = sc.nextLine().charAt(0);
		
		//----------------------------------------------------------------------
		
		// ** if-else if�� �̿��ؼ�
		/*if (num1 > 0 && num2 > 0 && ch == '+') {
			System.out.printf("%d %s %d = %d", num1, ch, num2, (num1 + num2));
			
		} else if (num1 > 0 && num2 > 0 && ch == '-') {
			System.out.printf("%d %s %d = %d", num1, ch, num2, (num1 - num2));
			
		} else if (num1 > 0 && num2 > 0 && ch == '*') {
			System.out.printf("%d %s %d = %d", num1, ch, num2, (num1 * num2));
			
		} else if (num1 > 0 && num2 > 0 && ch == '/') {
			System.out.printf("%d %s %d = %d", num1, ch, num2, (num1 / num2));
			
		} else if (num1 > 0 && num2 > 0 && ch == '%') {
			System.out.printf("%d %s %d = %d", num1, ch, num2, (num1 % num2));
			
		} else {
			System.out.println("�߸��Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
		}*/
		
		//----------------------------------------------------------------------
		
		// ** ���� ������ ���׷��̵� (��ø if�� ��� : ����� ������ ���� �˻��ϰ� �����Ѵ�!)
		/*if(num1 > 0 && num2 > 0) { // 1_1. �ΰ��� ���� ��� ����� ���
			
			// 2. �����ȣ�� ������ ��
			if(ch == '+') {
				
			}else if(ch == '-') {
				
			}else if(ch == '*') {
				
			}else if(ch == '/') {
				
			}else if(ch == '%') {
				
			}else { // �ΰ��� ������ ��� ����� ������ �����ȣ�� �߸� �Է����� ���
				
			}
			
		}else {  // 1_2. ����� �ƴ� ���� �Է��� ���
			
		}*/
		
		//----------------------------------------------------------------------
		
		
		// ** ���� ���뿡�� �� ���׷��̵�
		
		int result=0; // �����ȣ�� ���缭 ��� ������ ����� ����� ���� ����!
		
		if(num1 > 0 && num2 > 0) {
			
			// �����ȣ�� ������ ������ϴ� �� switch������ �ٲ۳���
			switch(ch) {
			case '+': result = num1 + num2; break;
			case '-': result = num1 - num2; break;
			case '*': result = num1 * num2; break;
			case '/': result = num1 / num2; break;
			case '%': result = num1 % num2; break;
			default: System.out.println("�����ڸ� �߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�."); return;
			}
			
		}else {
			System.out.println("����� �ƴ� ���� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�."); return;
			
		}
		
		// ��¹��� ���⿡ �� �ѹ��� ����Ҳ���
		System.out.printf("%d %c %d = %d", num1, ch, num2, result);

	}
	
	public void practice9() {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("�߰� ��� ���� : ");
		int midTerm = sc.nextInt();

		System.out.print("�⸻ ��� ���� : ");
		int finalTerm = sc.nextInt();

		System.out.print("����  ���� : ");
		int homework = sc.nextInt();

		System.out.print("�⼮ ȸ�� : ");
		int attendance = sc.nextInt();
		
		double mid = midTerm * 0.2;   // ����ڰ� �Է��� �߰���� ������ 20% �ݿ�
		double fin = finalTerm * 0.3; // ����ڰ� �Է��� �⸻��� ������ 30% �ݿ�
		double hw = homework * 0.3;   // ����ڰ� �Է��� ���������� 30% �ݿ�
		double at = attendance;		  // ����ڰ� �Է��� �⼮ Ƚ���� 100% �ݿ� (��? �⼮Ƚ���� 20ȸ���� �������� �Է��� ���̱� ����!)
		
		double sum = mid + fin + hw + at; // ���� ������ ��� ���ؼ� �� 100�� ���� �������� ����
		
		System.out.println("===========���==========");
		
		if(sum >= 70 && at >= 20 * 0.7) { // 1_1. ������ 70�� �̸鼭 �⼮Ƚ���� 20ȸ ���� �������� 70% �̻��� ���
			System.out.println("�߰� ��� ����(20) : " + mid);
			System.out.println("�⸻ ��� ����(30) : " + fin);
			System.out.println("���� ����       (30) : " + hw);
			System.out.println("�⼮ ����       (20) : " + at);
			
			System.out.println("���� : " + sum);
			System.out.println("PASS");
			
		}else { // 1_2. �װ� �ƴ� ��� (������ ������ ���� �ְ�, �⼮ Ƚ���� ������ ���� �ְ�, �ƴϸ� �Ѵ� ������ ���� ���� ���)
			
			if(at < 20 * 0.7) { // 2. �ٵ� �� �߿����� �⼮Ƚ���� ������ ��� 
				System.out.println("FAIL [�⼮ Ƚ�� ����] (" + attendance + "/20)");
			}
			
			// ���Ʒ� �ΰ��� ���ǹ� ���� ����  --> ���� �Ѵ� ������ ��� �� �� ����ɰ�!
			
			if(sum < 70) { // 3. �ٵ� �� �߿����� ������ ������ ���
				System.out.println("FAIL [���� �̴�] (���� " + sum + ")");
			}
		}
		
	}
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);

		System.out.println("������ ����� �����ϼ���.");
		System.out.println("1. �޴� ���");
		System.out.println("2. ¦��/Ȧ��");
		System.out.println("3. �հ�/���հ�");
		System.out.println("4. ����");
		System.out.println("5. �α���");
		System.out.println("6. ���� Ȯ��");
		System.out.println("7. BMI");
		System.out.println("8. ����");
		System.out.println("9. Pass/Fail");

		System.out.print("���� : ");
		int menu = sc.nextInt();
		
		switch (menu) { 

		case 1:	practice1(); break;
		case 2:	practice2(); break;
		case 3:	practice3(); break;
		case 4:	practice4(); break;
		case 5:	practice5(); break;
		case 6:	practice6(); break;
		case 7:	practice7(); break;
		case 8:	practice8(); break;
		case 9:	practice9(); break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
	

}
