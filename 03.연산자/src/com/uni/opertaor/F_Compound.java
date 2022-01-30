package com.uni.opertaor;

public class F_Compound {
	/*
	 * * 복합 대입 연산자 : 산술연산자와 대입연산자를 함께 사용하는 연산자
	 * 				  연산처리 속도가 훨씬 빠르므로 사용을 권장한다. 
	 * 
	 * +=, -=, *=, /=, %=
	 * 
	 * a = a + 3;	=>   a += 3;
	 * a = a - 3;	=>	 a -= 3;
	 * a = a * 3;	=>	 a *= 3;
	 * a = a / 3;	=> 	 a /= 3;
	 * a = a % 3;	=> 	 a %= 3;
	 * 
	 * 
	 * 	증감 연산자(++ --)와 비슷해 보이지만 증감연산자는 값을 1씩만 증감이 된다.
	        하지만 복합 대입 연산자는 내가 원하는 숫자만큼 증감을 시킬 수 있다.
	 */
	public void method() {
		int num =12;
		System.out.println("num : " + num); //12
		
		//num을 3증가시키기
		num = num+3;
		System.out.println("3증가시킨 num : "+num);//15
		
		// num을 3 증가 시키기
		num +=3;
		System.out.println(num);
		// num 을 5 감소 시키기 
		num -=5;
		System.out.println(num);
		// num 을 6배 증가 
		num *=6;
		System.out.println(num);
		// num 을 2배 감소
		num /= 2;
		System.out.println(num);
		// num 을 4로 나눴을때 나머지
		num %= 4;
		System.out.println(num);
		
		String str = "Hello";
		System.out.println(str);
		
		str += "World";
		System.out.println(str);
		
		str += 1;
		System.out.println(str);
		
	}
}
