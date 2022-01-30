package com.hw2.controller;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SpaceUpper {
	
	public SpaceUpper() {
	}
	
	public void spaceToUpper() {
		// 영문을 입력 받는다.
		Scanner sc = new Scanner(System.in);
		System.out.println("영어를 입력하시오(띄어쓰기 포함): ");
		String str = sc.nextLine();

		// StringTokenizer를 통해 띄어쓰기를 기준으로 토큰 단위로 나온 것을 연산하는 메소드를 구성
		StringTokenizer st = new StringTokenizer(str, " ");
		
		while(st.hasMoreTokens()) {
			String nstr =st.nextToken();
			
			char ch = nstr.toUpperCase().charAt(0);

			StringBuilder sb = new StringBuilder(String.valueOf(ch));
			sb.append(nstr);
			sb.delete(1, 2);
			System.out.print(sb+" ");
		}
		// 띄어쓰기 이후 첫 글자는 대문자로 되게 하고 그 외에 나머진 소문자로 해서 StringBuilder에 담아 출력
		
		
	}
}
