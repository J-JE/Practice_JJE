package com.uni.chap02.loop;

import java.util.Scanner;

public class A_For {
	/*
	 * 반복문 : 프로그램의 수행흐름을 제어하는 제어문중 하나, 어떤 실행코드를 반복적으로 수행시켜준다.
	 * 
	 * for문/while문( do- while문)
	 * 
	 * *for문
	 * 
	 * for(초기식;조건식;증감식){//반복 횟수를 지정하기위해서 제시하는것들 ..반복적으로 실행시키고자 하는 실행 구문..
	 * 
	 * }
	 * 
	 * -초기식 : 반복문이 수행될때 "단 한번만 실행되는 구문" 
	 * 			(보통 반복문 안에서 사용될 변수를 선언하고 초기값을 대입하는 구문) 
	 * -조건식 : "반복문이 수행될 조건" 을 작성하는 구문 
	 * 			조건식이 true일 경우 해당 실행 구문을 실행 
	 * 			조건식이 false일 경우 반복을 멈추고 빠져나옴 (보통 초기식에서 사용된 변수를 가지고 조건식을 작성) 
	 * -증감식 : 반복문을 제어하는 변수값을 증감시키는 부분 
	 * 			(주로 초기식에 제시한 변수를 가지고 증감 연산자 사용)
	 * 
	 * 
	 * for문 초기식--> 조건식 검사 -> true일 경우 실행구문을 실행 --> 증감식 
	 * 			 --> 조건식 검사 -> true일 경우 실행구문을 실행 --> 증감식 
	 * 			 --반복-- 
	 * 			 --> 조건식 검사 -> false일 경우 실행구문을 실행 하지 않음 --> 반복문을 빠져나옴
	 * 
	 * * 알아둘것 ~
	 *   for 문안에 있는 초기식, 조건식, 증감식은 모두 생략 가능 하긴 함(하지만 ; 은 반드시 필수 작성)
	 *   즉,for() 안에서만 생략 될뿐 모두 필요한 요소임.  
	 */
	
	public void method1() {
		// "안녕하세요"를 5번 반복해서 출력 하고자 할때 
		/*	System.out.println("안녕하세요");
			System.out.println("안녕하세요");
			System.out.println("안녕하세요");
			System.out.println("안녕하세요");
			System.out.println("안녕하세요");
		*/
/*
		for(int i =1; i<=5;i++) {
			System.out.println("안녕하세요"i);
		}
*/	
		for(int i =0; i<5;i++) {
			System.out.println("안녕하세요"+i);
		}
	}
	
	public void method2() {
		//1 2 3 4 5
		for(int i = 1; i<=5; i++) {
			System.out.print(i+ " ");
		}
		//5 4 3 2 1
		for(int i = 5; i>=1; i--) {
			System.out.print(i+ " ");
		}
		/*	증감연산자 : ++,--

        ++ 연산자 : 단독 사용시에는 변수 앞/뒤 구분없이 1씩증가 , 다른 식이나 문장의 일부로 사용시 앞에 사용되면                                 
            선증가 후처리, 변수 뒤에 사용되면 선처리 후증가의 의미를 가진다.
        -- 연산자 : 단독 사용시에는 변수 앞/뒤 구분없으나, 다른 식이나 문장의 일부로 사용시 앞에 사용되면
            선감소 후처리, 변수 뒤에 사용되면 선처리 후감소의 의미를 가진다.

		*/

	}
	
	public void method3() {
		//1부터 10 사이의 홀수만 출력
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 1) {
				System.out.print(i+ " ");
			}
		}
	}
	
	public void method4() {
		//1 2 3 4 ...8 9 10
		for (int i = 0; i <= 9; i++) {
				System.out.print(i+1+" ");
		}
	}
	
	public void method5() {
		//1부터 10까지의 정수의 합계
		//sum = 1+2+3..
		
				/*sum += 1;
				 *sum += 2;
				 *sum += 3;
				 *
				 * 
				 * 
				 * */

		
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			System.out.println("i"+i);
//			sum = sum +i;
			sum += i;
			System.out.println("sum"+sum);
		}
		
		System.out.println("총합계"+sum);
	}
	
	public void method6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
		
		//1부터 num 담겨있는 값까지의 정수 합계
				/* sum += 1;
				 * sum += 2;
				 * .
				 * .
				 * sum += num;
				  
		*
		*/
		
		int sum =0;
		for(int i =1; i <= num; i++) {
			sum += i;
		}
		System.out.println("총합계"+sum);
	}
	
	public void method7() {
		// 사용자한테 문자열을 입력받아서 각인덱스 별로 문자를 각각 추출 하시오

		/* String str = "apple"   
		 * a  -> str.charAt(0) 
		 * p  -> str.charAt(1)
		 * p  -> str.charAt(2)
		 * l  -> str.charAt(3)
		 * e  -> str.charAt(4)
		 * 
		 * apple 의 문자열의 길이 :5
		 * 01234
		 * 
		 * 마지막인덱스는 항상 문자열 길이 -1
		 * */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력 : ");
		String str = sc.nextLine();
		
		System.out.println("문자열 길이 "+str.length());
		
//		for(int i = 0; i <= str.length()-1 ; i++) { //아래 문장과 같다
		for(int i = 0; i < str.length() ; i++) {
			System.out.println(str.charAt(i));
		}
	}
	
	public void method8 () {
		//2단출력하기
		//2 * 1 = 2
		//2 * 2 = 4
		//2 * 3 = 6
		//.
		//.
		//.
		//2 * 9 = 18
		
		for(int i = 1; i <= 9; i++) {
			System.out.println("2 * "+ i +" = "+(2*i));
		}
	}
	
	public void method9 () {
		//사용자가 입력한 단 출력하기
		Scanner sc = new Scanner(System.in);
		System.out.println("단수(2~9) 입력 : ");
		int dan = sc.nextInt();
		
		/* dan * 1 = 
		 * dan * 2 = 
		 * dan * 3 = 
		 * ...
		 * dan * 9 = 
		 * 
		 * */

		if(dan > 1 && dan < 10) {

			for(int i = 1; i < 10; i++) {
				System.out.printf("%d * %d = %d\n", dan, i, dan*i);
			}
		}else {
			System.out.println("반드시 2~9 사이의 양수를 입력해야합니다.");
		}
	}
	
	public void method10() {
		//1부터 어떤 랜덤값 (1~10사이의 랜덤한 숫자 ) 까지의 합계 
		/*
		  java.lang.Math 클래스에서 제공하는 random()메소드를 사용해서 랜덤값 발생시킬 수 있다. 
		  
		  Math.random() 호출시 --> 0.0 ~ 0.999999 사이의 랜덤값 발생 시켜줌 (0.0 <= 랜덤값  < 1.0)
		 */

		//int random = Math.random(); // double형이라서 안됨
		// 			0.0 <=   < 1.0		--> 0.0 ~ 0.99999...

		//int random = Math.random() * 10;
		//			0.0 <=   < 10.0		--> 0.0 ~ 9.99999...

		//int random = Math.random() * 10 + 1;
		//			1.0 <=   < 11.0		--> 1.0 ~ 10.9999...

		int random = (int)(Math.random()*10+1); //먼저 곱하고 형변환하기~
		
		int sum = 0;
		for(int i = 1; i <= random ; i++) {
			sum += i;
		}
		System.out.println("1부터 "+ random +"까지의 합 : "+ sum);
	}
	
	public void method11() {
		//2부터 9 사이의 랜덤단을 출력하기
		int random = (int)(Math.random()*8+2); // 0*8 = 0 , 0+2 = 2 / 0.900...*8 = 7.992... , 7.9+2 = 9 / 2~9
		
		System.out.println("=== "+random+"단 ===");
		
		for(int i = 1 ; i <10; i++) {
//			System.out.printf("%d * %d = %d\n", random, i, random*i);
			System.out.println(random + " * " + i + " = " + random*i);
		}
	}
	
	// 중첩 for문
		/*
		 * for(초기식1; 조건식1; 증감식1) {
		 * 		수행할 문장 1;
		 * 	
		 * 		for(초기식2; 조건식2; 증감식2){
		 * 			수행할 문장 2;
		 * 		}
		 * 
		 * 		수행할 문장 3;
		 * }
		 * 
		 */
	
	public void method12() {
		//1부터 5까지 연이어서 출력되는 문장을 3줄 출력 
		//1 2 3 4 5
		//1 2 3 4 5
		//1 2 3 4 5
		
		/**
		 * i=1 true 
		 * 			j=1 true 1출력 j++
		 * 			j=2 true 2출력 j++
		 * 			...
		 * 			j=5 true 5출력 j++
		 * 			j=6 false 반복문나감
		 * 			개행 출력 i++
		 * 
		 * i=2 true
		 * 			j=1 true 1출력 j++
		 * 			j=2 true 2출력 j++
		 * 			...
		 * 			j=5 true 5출력 j++
		 * 			j=6 false 반복문나감
		 * 			개행 출력 i++
		 * 
		 * i=3 true
		 * 			j=1 true 1출력 j++
		 * 			j=2 true 2출력 j++
		 * 			...
		 * 			j=5 true 5출력 j++
		 * 			j=6 false 반복문나감
		 * 			개행 출력 i++
		 * 
		 * i=4 false 반복문 나감
		 * 
		 */

		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.printf(j+" ");
			}
			System.out.println();
		}
	}
	public void method13() {
		//2단부터 9단까지 출력 
				//단 		 2~9 까지 1씩 증가 ,--> 바깥 for문
				//곱해지는수    매단마다 1부터 9까지 1씩 증가, -->안쪽 for 문으로 해결 가능
				

				// == 2단 ==
				// 2 * 1 = 2
				// 2 * 2 = 4
				// 2 * 3 = 6
				//  ...
				// 2 * 9 = 18
				
				// == 3단 ==
				// 3 * 1 = 3
				// 3 * 2 = 6
				// 3 * 3 = 9
				// ...
				// 3 * 9 = 27

		for(int dan =2; dan<=9; dan++) {
			System.out.println("===="+dan+"단====");
			for(int su =1; su<=9; su++) {
				System.out.println(dan+" * "+su+" = "+ (dan*su));
			}
			System.out.println();
		}
	}
	public void method14() {
		//*****
		//*****
		//*****
		//*****
		//행이 1~4 까지 반복 (4번) -->바깥쪽 for문
		//열이 1~5 까지 반복 (5번) -->안쪽 for문
		
		for(int i =1; i <= 4; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}

	public void method15() {
		//1***
		//*2**
		//**3*
		//***4

		//행이 1~4 까지 반복 (4번) -->바깥쪽 for문
		//열이 1~4 까지 반복 (4번) -->안쪽 for문
		
		for(int i =1; i <= 4; i++) {
			for(int j = 1; j <= 5; j++) {
				if(i == j) {
					System.out.print(i);
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	public void method16() {
		// *
		// **
		// ***
		// ****
		// *****

		for(int i =1; i <= 5; i++) {
			int j;
			for(j = 1; j <= i; j++) {
//				System.out.print(" i " + i+" ");
//				System.out.print(" j1 : " + j+" ");
				System.out.print("*");
			}
			System.out.println();
		}

	}
	
}
