package com.kh.hw1.controller;

public class TokenController {
	
	
	public String afterToken(String str) {
		//공백을 토큰으로 처리한 글자 반환
		String[] after = str.split(" ");
		String result = "";
		
		for(String s:after) {
			result +=s;
		}
		
		return result;
	}
	
	public String firstCap(String input) {
		//매개변수로 받은 문자열의 첫 번째 글자를 대문자로 바꾼 문자열 반환
		
		char ch = input.toUpperCase().charAt(0);
		String result = String.valueOf(ch);
		for(int i=1; i<input.length();i++) {
			result +=input.charAt(i);
		}
		return result;
	}
	
//	public String firstCap_백지우(String input) {
//        // String 첫 글자만 대문자로 출력 / 참고 : apthow.com
//        String input1 = input.substring(0, 1).toUpperCase() + input.substring(1);
//        return input1;
//    }
	
	public void findChar(String input, char one) {
		//매개변수로 받은 문자열 중에서 매개변수로 들어온 문자가 몇 개 존재 하는지 개수를 반환
		int count =0;
		for(int i =0;i<input.length();i++) {
			if(input.charAt(i) == one) {
				count++;
			}
		}
		System.out.println(one+" 문자가 들어간 개수 :"+count);
	}
}
