package com.method.hw2.controller;

public class NonStaticSample {

	//1. 전달받은 정수 (length) 만큼 int 배열을 할당
	public int[] intArrayAllocation(int length) {
		int[] arr=new int[length];
		
		for(int i =0; i<arr.length;i++) {
			int n =(int) (Math.random()*100+1);
			arr[i]=n;
		}
		
		// 임의의 1부터 100까지의 값으로 값을 기록하고 배열 주소 리턴
		return arr;
	}
	
	//2.전달받은 배열 출력
	public void display(int[] arr) {
		
		
		for(int i =0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	//3. 전달받은 배열의 각각의 인덱스 값을 교환
	public void swap(int[] arr, int idx1, int idx2) {
		
		int temp =0;
		temp=arr[idx1]; //arr의 인덱스 값으로 넣어야함... 그냥 바꾸면 안됨
		arr[idx1]=arr[idx2];
		arr[idx2]=temp;
		
	}
	
	//4.위의 swap 메소드를 이용하여 전달받은 배열을 내림차순 적용 
	// 위의 display 메소드를 이용하여 출력
	public void sortDescending(int[] arr) {
		
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<i;j++) {
				if(arr[i]>arr[j]) {
					swap(arr, i, j);
				}
			}
		}
		display(arr);//for문 안에 있으면 안됨
		
	}
	
	//5. 위의 swap 메소드를 이용하여 전달받은 배열을 오름차순 적용
	// 위의 display 메소드를 이용하여 출력
	public void sortAscending(int[] arr) {
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<i;j++) {
				if(arr[i]<arr[j]) {
					swap(arr, i, j);
				}
			}
		}
		display(arr);
	}
	
	//6. 문자열과 문자 하나를 전달받아 문자열에 포함된 문자의 갯수 리턴
	public int countChar(String str, char c) {
		
		int count =0;
		
		for(int i=0; i<str.length();i++) {
			if(str.charAt(i)=='p') {
				count++;
			}
		}
		
		return count;
	}
	
	//7. 정수 두 개를 전달받아 두 수 중 작은 값에서 큰 값 사이의 정수들의 합계를 리턴
	// (단, 전달받은 두 정수는 포함되지 않아야된다.)
	public int totalValue(int num1, int num2) {
		
		int result =0;
		if(num1>num2) { //num1이 num2보다 크면
			for(int i=num2+1; i<num1;i++) { //num2+1부터 num1 전까지
				result+=i;
			}
		}else if(num1<num2) { //num2가 num1보다 크면
			for(int i=num1+1; i<num2;i++) { //num1+1부터 num2 전까지
				result+=i;
			}
		}
		
		return result;
	}
	
	//8. 전달받은 문자열의 인덱스를 통해 해당 인덱스의 문자 리턴
	public char pCharAt(String str, int index) {
		
		char[] arr= new char[str.length()];
		char ch =' ';

		for(int i=0; i<str.length();i++) {
			arr[i]=str.charAt(i);
			if(i==index) {
				ch=arr[i];
			}
		}
		return ch;
	}
	
	public String pConcat(String str1, String str2) {
		String sum =" ";
		sum=""+str1+str2;
		return sum;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
