package com.uni.array;

import java.util.Arrays;
import java.util.Scanner;

public class A_Array {

	public void method1() {
		//일반 변수 선언
		int i; //메모리 공간에 값을 기록해 놓기 위한 공간.-->그 메모리 중에 기본자료형은 stack 영역에 할당 되는 것.
		
		//1.배열선언
		int[] iArr; //배열을 선언하게 되면 변수 선언과 마찬가지로 stack 영역에 박스가 생김, 이 박스는 실제 값을 담기위한 용도가 아니고 '주소를 보관하는 공간'
		
		double[] dArr;
		
		/*
		 * 
		 * 따라서 값을 담는 변수는 그냥 변수라고 하고
		 * 주소값을 담는 변수는 레퍼런스 변수(참조 변수)라고 표현한다.
		 * 
		 * 기본 자료형(boolean, char, byte, short, int, long, float, double) 로 선언한 변수
		 * ->> 진짜 값(리터럴)을 담는 변수--> 변수
		 * 
		 * 
		 * 그 외 자료형(String, int[], char[]....)
		 * --> 주소값을 담는 변수--> 레퍼런스 변수(참조변수)
		 * 
		 */
		
		/* 2. 배열 할당
		 * 배열에 담을 값들이 몇개 들어갈지 배열 할당으로 크기를 반드시 미리 지정해두어야 한다.
		 * iArr = new int[] <--크기를 지정하지 않으면 에러발생
		 * 
		 * 
		 */
		iArr = new int[5]; //<--크기를 지정하지 않으면 에러발생
		dArr = new double[10];
		//new 연산자를 통해서 배열을 할당하게되면 메모리의 heap 영역에 해당배열의 크기만큼 공간이 만들어지고
		//그때 이 해당공간에 고유한 주소값도 같이 부여 되고, 이 주소값을 stack 영역의 레퍼런스 변수에 저장하게 된다.
		//따라서 해당 배열에 값을 넣거나 수정할 때 해당 주소를 사용하게 된다.
		
		//배열선언과 할당을 동시에
		
		int[] iArr2 =new int[5];
		double[] dArr2 = new double[10];
		
		System.out.println("iArr "+iArr);
		System.out.println("iArr2 "+iArr2);
		System.out.println("dArr "+dArr);
		System.out.println("dArr2 "+dArr2); //주소값 출력
		
	}
	
	public void method2() {
		double[] dArr = new double[3];
		int[] iArr = new int[5];
		
		for(int i = 0; i<dArr.length;i++) {
			System.out.println(dArr[i]);
		}
		
		System.out.println("=======");
		
		for(int i = 0; i<iArr.length;i++) { //참조변수의 길이보다 하나 작은 수 만큼 출력해야함
			System.out.println(iArr[i]);
		}
		
		// 배열을 따로 초기화 하지않는다면 JVM 이 지정한 자료형의 기본값으로 배열을 초기화한다. 
		// heap 영역에는 값이 없는 공간이 존재할 수 없다. --> JVM 이 자동으로 초기값 부여 
		
		//문자열 길이 : length()
		//배열의 길이 : length
		System.out.println("dArr길이 "+ dArr.length);
		System.out.println("iArr길이 "+ iArr.length);

	}
	
	public void method3() {
		int[] iArr = new int[5];
		
//		//인덱스를 이용한 초기화
//		iArr[0] =1;
//		iArr[1] =2;
//		iArr[2] =3;
//		iArr[3] =4;
//		iArr[4] =5;
		
		//반복문을 통해서
		for(int i=0; i<iArr.length;i++) {
			iArr[i]=i+1;
		}
		
		
		for(int i = 0; i<iArr.length;i++) {
			System.out.println("iArr [ "+i+" ] "+ iArr[i]);
		}
		System.out.println("iArr : "+ iArr);
		System.out.println("iArr의 해쉬코드 : "+ iArr.hashCode());//주소값의 10진수 값
	}
	
	public void method4() {
		//사용자가 입력한 값으로 배열의 길이를 지정
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("새로 할당할 배열의 길이 : ");
		int i=sc.nextInt();
		
		double[] dArr = new double[i];
		
		System.out.println(dArr);
		System.out.println("배열의 길이 : "+dArr.length);
		
	}
	
	public void method5() {
		//배열선언과 할당 동시에 초기화하기
		
		int[] arr1 = {1,2,3,4};//중괄호 블럭을 사용하는 경우에 new 연산자를 사용하지 않아도 값의 개수만큼 자동으로 크기가 할당된다.
		
		int[] arr2 = new int[] {1,2,3,4};
		
		System.out.println("arr1의 길이 : "+arr1.length);
		System.out.println("arr2의 길이 : "+arr2.length);
		
		System.out.println(arr1==arr2); //arr1, arr2는 값은 같지만 레퍼런스 변수(참조변수)이기 때문에 다른 주소값을 담고 있다.
		
	}
	
	public void method6() {
		String[] sArr = new String[5];
		
		for(int i=0;i<sArr.length;i++) { //참조자료형 String의 JVM이 부여하는 초기값은 null
			System.out.println(sArr[i]);
		}
		
		Scanner sc = new Scanner(System.in);
		
		for(int i =0; i<sArr.length;i++) {
			System.out.println("과일 : ");
			sArr[i] =sc.nextLine();
		}
		
		for(int i =0; i<sArr.length;i++) {
			System.out.println(sArr[i]);
		}
		
		
	}
	
	public void method7() {
		//크기가 10짜리 정수형 배열 을 만들고 , 랜덤값(1~100까지)을 발생시켜서 담아서 출력하도록~
		int[] arr = new int[10];
		
		
		for(int i =0; i<arr.length;i++) {
			arr[i] =(int)(Math.random()*100+1);
			System.out.println(arr[i]);
		}
	}
	
	public void method8() {
		//정수배열 크기 5 , 1~10 사이의 짝수 (2,4,6,8,10) 담기
		int[] iArr = new int[5];
		
		int num=0;
	
		for(int i =0;i<iArr.length;i++) {
		iArr[i]=num+=2; //2씩 늘어나는 num을 인덱스i에 넣는다.
		}
		
		System.out.println(Arrays.toString(iArr));
		
		System.out.println("iArr 길이 "+iArr.length);
		System.out.println("iArr 해쉬코드 "+iArr.hashCode());
		
//		iArr[5];=12l//배열의 인덱스를 벗어나면 오류 발생
		
		iArr = new int[10]; //new int[5]는 (처음만들었던 배열) heap에 있는 공간과 연결고리가 끊어지고 후에 가비지컬렉터가 지워줌
		System.out.println("크기 변경 후");
		System.out.println(Arrays.toString(iArr));
		System.out.println("iArr 길이 "+iArr.length);
		System.out.println("iArr 해쉬코드 "+iArr.hashCode());
		
		iArr=null; //iArr에 null을 대입하면 주소값이 null로 바뀌고 [10]과의 연결고리가 끊어짐
		
		//레퍼런스(참조)변수에 null값이 들어가게되면 주소값이 null 바뀌고 
		//참조하고있는 주소가 없다는 말임. -> heap과의 연결고리가 끊어짐.
	    //heap에서는 참조 되는 연결고리가 끊어져서 일정 시간이 지난후에 
        //더이상 쓸모없다고 판단이되면 가비지 컬렉터가 삭제 해준다.

		System.out.println("===삭제한 후===");
		System.out.println("iArr 길이 "+iArr.length);
		System.out.println("iArr 해쉬코드 "+iArr.hashCode());
		// NullPointerException 발생
		// 아무것도 참조하지 않고 null이라는 특수한 값을 참조하고 있을 때 발생

	}
	
	
	
	
}
