package com.method.hw1.controller;

public class NonStaticSample {

	//매개변수없고 반환값도 없는 메소드
	public void printLottoNumbers() { 
		
		// 1~45까지의 임의의 정수 6개가 중복되지 않게 발생시켜 출력하는 메소드
		int[] num = new int[6];
		
		for(int i =0; i<num.length; i++) {
			num[i] =(int)(Math.random()*45+1);
			for(int j =0; j<i;j++) {
				if(num[i]==num[j]) {
					i--;
				}
			}
		}
		
		// 응용 --> 오름차순 정렬로 출력
		for(int i=0; i<num.length; i++) {
			for(int j=i+1; j<num.length; j++) {
				if(num[i] > num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		
		//출력
		for(int i=0; i<num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
	
	//매개변수 있고 반환값이 없는 메소드
	public void outputchar(int num, char c) {
		// 매개변수로 전달받은 문자 c를 전달받은 num 갯수 만큼 출력하는 메소드
		for(int i=0; i<num;i++) {
			System.out.print(c+" ");
		}
	}
	
	//매개변수 없고 반환값이 있는 메소드
	public char alphabette() {
		// 알파벳 범위의 임의의 영문자를 하나 발생시켜 리턴하는 메소드
		// 주의! 소문자 대문자 모두 포함

		
		char alphabette=' ';
		
		while(true) {
			char  random=(char)(Math.random()*58+65); //A=65, z=122
			if(random>=65&&random<=90) { //Z=90, a=97
				alphabette=random;
			}else if(random>=97&&random<=122){
				alphabette=random;
			}else {
				break;
			}
		}
		return (char)alphabette;
	}
	
	//매개변수가 있고 반환값도 있는 메소드
	public String mySubstring(String str, int index1, int index2){
		// 매개변수로 문자열과 시작 인덱스, 끝 인덱스를 전달 받고
		// 해당 인덱스 범위의 문자열을 추출하여 리턴
		// 단, 전달받은 문자열은 반드시 값이 있어야 한다. --> 없으면 null 리턴
		
		char[] arr = new char[str.length()];

		for(int i =0;i<arr.length;i++) {
			arr[i]=str.charAt(i);
		}

		String result=" ";
		System.out.println(result);

		for(int i =0;i<index2;i++) {
			if(index1<=i) {
				result+=arr[i];
			}
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
