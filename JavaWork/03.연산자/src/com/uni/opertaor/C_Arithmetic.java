package com.uni.opertaor;

public class C_Arithmetic {

	public void method1() {
		
		int num1 = 10;
		int num2 = 3;
		
		
		System.out.println("num1 + num2 = "+ (num1 + num2));
		System.out.println("num1 - num2 = "+ (num1 - num2));
		System.out.println("num1 * num2 = "+ (num1 * num2));// 곱하기
		System.out.println("num1 / num2 = "+ (num1 / num2));// 나누기의 몫
		System.out.println("num1 % num2 = "+ (num1 % num2));// 나누기의 나머지

		
		//값 % 2 == 0 ->짝수
		//값 % 2 == 1 ->홀수
		
		//값 % 5 == 5 ->5의 배수

	}
	
	
	public void method2() {
		double a = 35;
		double b = 10;
		
		System.out.println("a = "+ a);
		System.out.println("b = "+ b);
		
		double sum = a + b; 
		System.out.println("a + b = "+ sum);
		
		
		double sub = a - b; 
		System.out.println("a - b = "+ sub);
		
		
		double mul = a * b; 
		System.out.println("a * b = "+ mul);
		
		
		double div = a / b; 
		System.out.println("a / b = "+ div);
		
		
		double mod = a % b;
		System.out.println("a % b = " + mod);

		
		int c = 27;
		System.out.println("c = "+ c);
		
		double result = a + a * b % c -a / b;
		
		/* 1. a *b = 350
		 * 2. 350 % 27 = 26.0
		 * 3. a / b = 3.5
		 * 4. a+ 26.0 - 3.5 = 57.5
		 * */
		
		System.out.println(result); //57.5
		
	}
	
	public void method3() {
		//test
//		int a = 5; //a=5 //a=7
//		int b = 10; //b=10 //b=9
//		int c = (++a) + b; //a=6, 6+10=16, c=16// c=15
//		int d = c / a; // 16/6, d=2 //d=1
//		int e = c % a; //e=4 // e=6
//		int f = e++; //f=4(5) //f=4
//		int g = (--b) + (d--); // 9+2(1)=11, g=11 //g=10
//		int h = 2; //h=2 // h=2
//		int i = a++ + b / (--c / f) * (g-- - d) % (++e + h); //i=12
//		/* 1. --c / f -> 15/4 -> 3
//		 * 2. g-- - d -> 11(10)-1 -> 10
//		 * 3. ++e + h -> 5+2 ->7
//		 * 4. a++ + b / 3 * 9 % 7
//		 * 5. b / 3 -> 9/3 -> 3
//		 * 6. 3 * 9 -> 27
//		 * 7. 27 % 7 -> 6
//		 * 8. a++ + 6 -> 6(7)+6 ->12
//		 * */
		//답
		int a = 5;
		int b = 10;
		int c = (++a) + b;     //a=6, b=1-, c=16
		int d = c / a;         //a=6, b=1-, c=16, d=2
		int e = c % a;         //a=6, b=1-, c=16, d=2, e=4
		int f = e++;           //a=6, b=1-, c=16, d=2, e=4(5), f=4
		int g = (--b) + (d--); //a=6, b=1-, c=16, d=2, e=5   , f=4, g=11
		int h = 2;             //a=6, b=1-, c=16, d=2, e=5   , f=4, g=11, h=2
		int i = a++ + b / (--c / f) * (g-- - d) % (++e + h);
		//    = 6   + 1 / (15  / 4) * (11(10)-2)% (  6 + 2)
		//    = 12
	

	}
	
}
