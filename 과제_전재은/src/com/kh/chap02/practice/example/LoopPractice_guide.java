package com.kh.chap02.practice.example;

import java.util.Scanner;

public class LoopPractice_guide {
	
	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int user = sc.nextInt();

		if (user >= 1) { // 1_1. 잘 입력했을 경우 	
			
			for (int i = 1; i <= user; i++) {
				System.out.print(i + " ");
			}
			
		} else { // 1_2. 그게 아닐 경우 (잘못 입력햇을 경우)
			System.out.println("1 이상의 숫자를 입력해주세요.");
			
		}
	}

	public void practice2() {
		
		Scanner sc = new Scanner(System.in);

		// 우선 무한 반복 돌려놓고
		while (true) {
			
			System.out.print("1이상의 숫자를 입력하세요 : ");
			int user = sc.nextInt();
			
			if (user >= 1) { // 1_1. 잘 입력했을 경우 		=> 정상적인 결과 출력 후 반복문 종료
				
				for (int i = 1; i <= user; i++) {
					System.out.print(i + " ");
				}
				break;
				
			} else { // 1_2. 그게 아닐 경우 (잘못 입력햇을 경우) => 다시 반복문 실행
				System.out.println("1 이상의 숫자를 입력해주세요.");
				
			}
		}
	}

	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int user = sc.nextInt();

		if (user >= 1) { // 1_1. 잘 입력했을 경우
			
			for (int i = user; i >= 1; i--) {
				System.out.print(i + " ");
			}
			
		} else {// 1_2. 그게 아닐 경우 (잘못 입력햇을 경우)
			System.out.println("1 이상의 숫자를 입력해주세요.");
			
		}
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);

		// 우선 무한 반복 돌려놓고
		while (true) {
			
			System.out.print("1이상의 숫자를 입력하세요 : ");
			int user = sc.nextInt();
			
			if (user >= 1) { // 1_1. 잘 입력했을 경우 		=> 정상적인 결과 출력 후 반복문 종료
				
				for (int i = user; i >= 1; i--) {
					System.out.print(i + " ");
				}
				break;
				
			} else { // 1_2. 그게 아닐 경우 (잘못 입력햇을 경우) => 다시 반복문 실행
				System.out.println("1 이상의 숫자를 입력해주세요.");
				
			}
		}
	}
	
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();
		
		int sum = 0;
		
		for(int i=1; i<=num; i++) { // i값이 1에서부터 사용자가 입력한 수까지 1씩 증가하는 동안 반복
			
			// 매번 sum 변수에 누적해서 더해줌
			sum += i; 
			
			// 뿐만아니라 출력도 해줄꺼임 .. 근데 문제에서 요구한 대로 출력하고자 한다면
			if(i < num) { // i 값이 num보다 작을 때 까지는 해당 숫자 뒤에 + 붙여가면서 출력
				System.out.print(i + " + ");
			}else { // 그게 아닐 경우(즉, i값이 num이 될 경우 그땐 마지막으로 = 붙여서 출력
				System.out.print(i + " = ");
			}
		}
		
	}
	
	public void practice6() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		if(num1 >= 1 && num2 >= 1) { // 1_1. 두 수 모두 잘 입력했을 경우 
			
			int min = Math.min(num1, num2);	// 두 수 중 작은 값 담기
			int max = Math.max(num1, num2); // 두 수 중 큰 값 담기
			
			for(int i = min; i <= max; i++) { // i가 min에서부터 max까지 1씩 증가하는동안 반복
				System.out.print(i + " ");
			}	
			
		} else { // 1_2. 그게 아닐 경우 (잘못입력했을 경우)
			System.out.println("1 이상의 숫자를 입력해주세요.");
			
		}
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		
		// 우선 무한 반복 돌려놓고
		while(true) {
			
			System.out.print("첫 번째 숫자 : ");
			int num1 = sc.nextInt();
			
			System.out.print("두 번째 숫자 : ");
			int num2 = sc.nextInt();
			
			if(num1 >= 1 && num2 >= 1) { // 1_1. 두 수 모두 잘 입력했을 경우 	=> 정상적인 결과 출력 후 반복문 빠져나감
				
				int min = Math.min(num1, num2);	// 두 수 중 작은 값 담기
				int max = Math.max(num1, num2); // 두 수 중 큰 값 담기
				
				for(int i = min; i <= max; i++) {
					System.out.print(i + " ");
				}	
				
				break; 
				
			} else {// 1_2. 그게 아닐 경우 (잘못입력했을 경우) => 다시 반복문 수행
				System.out.println("1 이상의 숫자를 입력해주세요.");
				
				
			}
		}
	}
	
	public void practice8() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		System.out.println("===== " + num + "단 =====");
		
		for(int i = 1; i < 10; i++) {			
			System.out.printf("%d * %d = %d\n", num, i, num * i);
		}
		
	}
	
	public void practice9() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		if(num >= 2 && num <= 9) { // 1_1. 잘 입력했을 경우 => 사용자가 입력한 단에서부터 9단까지 출력
			
			
			for(int i = num; i < 10; i++) {						// 단을 지정하는 for문	(사용자가 입력한 수부터 9까지 1씩 증가)
				System.out.printf("===== %d단 =====\n", i);
				
				for(int j = 1; j <= 9; j++) {					// 곱해지는 수를 지정하는 for문	
					System.out.printf("%d * %d = %d\n", i, j, (i * j));
				}
				
				System.out.println();
			}		
			
			
		} else { // 1_2. 그게 아닐 경우 (즉, 잘못입력했을 경우)
			System.out.println("2~9사이의 숫자만 입력해주세요.");
			
		}
	}
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		
		// 우선 무한 반복 돌려놓고
		while(true) {			
			
			System.out.print("숫자 : ");
			int num = sc.nextInt();
			
			if(num >= 2 && num <= 9) { // 1_1. 잘 입력했을 경우 => 사용자가 입력한 단에서부터 9단까지 출력
				
				for(int i = num; i <= 9; i++) {					// 단을 지정하는 for문
					System.out.printf("===== %d단 =====\n", i);
					
					for(int j = 1; j <= 9; j++) {				// 곱해지는 수를 지정하는 for문
						System.out.printf("%d * %d = %d%n", i, j, (i * j));
					}
					
					System.out.println();
				}	
				break;
				
			} else { // 1_2. 그게 아닐 경우 (즉, 잘못입력했을 경우)
				System.out.println("2~9 사이의 숫자만 입력해주세요.");
			}
		}
	}
	
	public void practice11() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시작 숫자 : ");
		int start = sc.nextInt();
		
		System.out.print("공차 : ");
		int num = sc.nextInt();
		
		for(int i=1; i<=10; i++) { // 10번은 무조건 반복시키겠다!!
			
			System.out.print(start + " "); // 현재의 start값 출력 후
			
			start += num; // start값 공차만큼 증가
			
		}
	}
	
	
	
	
	public void practice12() {
		
		Scanner sc = new Scanner(System.in);
		
		// 연산자 입력 받고
		// 		해당 연산기호가 exit일 경우 (조건문) --> 프로그램 종료 (반복문 종료)
		// 정수 두개를 입력받고
		// 		연산기호가 / 면서 두번째 정수가 0일 경우 (조건문) --> 오류문구 출력 (반복문 다시 시작)
		// 연산기호에 따라 해당 결과 출력문 출력
		//		단, 다른 연산기호일 경우 반복문 다시 시작
		
		while(true) {
			
			// 1. 연산자 입력받기
			System.out.print("연산자(+, -, *, /, %) : ");
			String op = sc.nextLine();		// 연산기호 뿐만 아니라 exit이라는 문자열이 들어올 수도 있으므로 String 변수에 기록
			
			// 2. 먼저 정수값 입력받기 전 연산자 입력시 exit을 입력했는지 비교하기
			// => exit을 입력했을 경우 종료하겠다는 의사를 밝힌것이므로 무한반복문 빠져나가게끔
			if(op.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break; // 반복문을 빠져나감
			}
			
			// 3. 정수 입력받기
			System.out.print("정수1 : ");
			int num1 = sc.nextInt();
			
			System.out.print("정수2 : ");
			int num2 = sc.nextInt();
			sc.nextLine();	// 반복문 다시 실행하게 되면 sc.nextLine()이 올 수 있으므로 버퍼 비워주기
			
			// 4. 연산하기 전 사용자가 입력한 연산자가 /이면서 두번째 정수가 0인지 비교하기
			if(op.equals("/") && num2 == 0) {
				System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.\n");
				continue; // 뒤의 내용들은 실행하지 않고 바로 반복문의 위로 올라감 (다시 입력받아야되기 때문에)
			}
			
			// 5. 산술연산 후 결과 출력하기
			int result = 0;
			
			switch(op) {
			case "+": result = num1 + num2; break;
			case "-": result = num1 - num2; break;
			case "*": result = num1 * num2; break;
			case "/": result = num1 / num2; break;
			case "%": result = num1 % num2; break;
			default: System.out.println("없는 연산자입니다. 다시 입력해주세요.\n"); continue; // 연산자를 잘못 입력시 아래의 내용은 실행하지 않고 반복문의 위로 올라감 (다시 입력받아야되기 때문에)
			}
			
			System.out.printf("%d %s %d = %d\n", num1, op, num2, result);
			System.out.println();
		}
	}
	
	///////////////////////////////////////////////////////
	

	public void practice15() {
		// 나누어 떨어지는 수가 1과 자기자신 밖에 없는 수 --> 소수
		// 예를 들면 4의 경우
		// 4 % 1 == 0
		// 4 % 2 == 0
		// 4 % 3 == 1
		// 4 % 4 == 0
		// 4라는 숫자는 나누어떨어지는 수가 1과 자기 자신 말고도 2가 있다. --> 소수 X
		
		// 예를 들면 5의 경우
		// 5 % 1 == 0
		// 5 % 2 == 1
		// 5 % 3 == 2
		// 5 % 4 == 1
		// 5 % 5 == 0
		// 5라는 숫자는 나누어 떨어지는 수가 1과 자기 자신 밖에 없음 --> 소수 O
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		boolean flag = true; // 소수인지 아닌지 논리값을 담을 flag 변수 
		
		if(num >= 2) {	
			
			for(int i = 2; i < num; i++) { // 2 ~ num-1 까지 반복 (즉, 1과 자기 자신을 빼고)
				
				if(num % i == 0) {	// 2 ~ num-1 까지 한번씩 나눠볼 때 나누어떨어지는 순간이 한번이라도 나오면
					
					flag = false;	// num은 소수가 아니라는 소리 --> false로 바꿔버림
					break; 			// 더이상 실행해볼 가치 없어서 break 받고 반복문 빠져 나감
				}
			}
			
			if(flag) { // flag 값이 true일 경우
				System.out.println("소수입니다.");
			} else {
				System.out.println("소수가 아닙니다.");
			}
			
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void practice16() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("숫자 : ");
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
					System.out.println("소수입니다.");
				} else {
					System.out.println("소수가 아닙니다.");
				}
				
				break;
				
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}	
		}
	}
	
	public void practice17() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		boolean flag = true;
		int count = 0; // 소수 갯수 증가 시킬 변수
		
		if(num >= 2) {
			for(int i = 2; i <= num; i++) {		
				
				for(int j = 2; j < i; j++) {
					
					if(i % j == 0) {
						flag = false;
						break;
					}
				}
				
				if(flag) { // 소수일 경우 
					System.out.print(i + " ");
					count++;
				}
				
				flag = true; // 다시 true로 초기화
			}
			
			System.out.println();
			System.out.println("2부터 " + num + "까지 소수의 개수는 " + count + "개입니다.");
			
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}	
	}
	
	public void practice18() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("자연수 하나를 입력하세요 : ");
		int user = sc.nextInt();
		int count = 0;
		
		for(int i = 1; i <= user; i++) {   // 1부터 사용자가 입력한 수까지
			
			if(i % 2 == 0 || i % 3 == 0) { // 2로 나누어떨어지거나 3으로 나누어떨어지면 : 2의 배수이거나 3의 배수이면 출력
				System.out.print(i + " ");
			}
			
			if(i % 2 == 0 && i % 3 == 0) { // 2로도 나누어떨어지고 3으로도 나누어떨어지면 : 2와 3의 공배수일때 count 증가
				count++;
			}
		}
		System.out.println();
		System.out.println("count : " + count);
	}
	
	public void practice19() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int user = sc.nextInt();
		
		for(int i=user; i>=1; i--) {
			
			// 공백 먼저 출력
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
		
		System.out.print("정수 입력 : ");
		int user = sc.nextInt();
		
		// 위쪽 삼각형 (사용자가 입력한 정수줄까지)
		for(int i=0; i<user; i++) {
			
			for(int j = 0; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		// 아래쪽 삼각형
		for(int i=user-1; i>0; i--) {
			
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice21() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int user = sc.nextInt();
		
		int num = 1; // "*"출력할때 사용할 변수
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
		
		System.out.print("정수 입력 : ");
		int user = sc.nextInt();
		
		for(int i = 0 ; i < user ; i++) {
			
			for(int j = 0; j < user ; j++) {
				
				// 첫 번째 줄과 마지막 줄은 모두 "*" 출력
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
