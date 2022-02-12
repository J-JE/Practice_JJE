package com.method.hw2.run;

import com.method.hw2.controller.NonStaticSample;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NonStaticSample sample =new NonStaticSample();
		
		//1.
		
		//2.
		System.out.print("크기가 5인 배열의 랜덤값 : ");
		int[] arr=sample.intArrayAllocation(5);
		sample.display(arr);
		
		//3.
		
		//4.
		System.out.print("내림차순 출력 : ");
		sample.sortDescending(arr);
		
		//5.
		System.out.print("오름차순 출력 : ");
		sample.sortAscending(arr);
		System.out.println();
		
		//6.
		System.out.println("apple 문자열에 p의 갯수 : "+sample.countChar("apple", 'p'));
		
		//7.
		System.out.println("13과 7사이 정수들의 합계 : "+sample.totalValue(13, 7));
	
		//8.
		System.out.println("programming문자열의 3번 인덱스 문자 : "+sample.pCharAt("programming", 3));
		
		//9.
		System.out.println("JAVA와 programming을 합친 문자열 : "+sample.pConcat("JAVA", "programming"));
	}

}
