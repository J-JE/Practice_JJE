package com.uni.array;

import java.util.Arrays;

public class B_ArrayCopy {
	/*배열의 복사 
	 * -얕은복사 : 배열의 주소만을 복사
	 * -깊은복사 : 동일한 배열을 하나더 생성해서 실제 내부값들을 복사
	 */

	public void method1() {
		
		//얕은 복사
		int[] origin = {1,2,3,4,5};
		System.out.println("원본 배열 출력");
		for(int i =0; i<origin.length;i++) {
			System.out.println(origin[i]);
		}
		
		int[] copy = origin;
		System.out.println("복사본 배열 출력");
		for(int i =0; i<copy.length;i++) {
			System.out.println(copy[i]);
		}
		
		//복사본 copy에 2번 인덱스에 99로 변경
		copy[2] =99;
		
		System.out.println("원본 배열 출력");
		for(int i =0; i<origin.length;i++) {
			System.out.println(origin[i]);
		}
		System.out.println("복사본 배열 출력");
		for(int i =0; i<copy.length;i++) {
			System.out.println(copy[i]);
		}
		System.out.println("origin 주소값"+origin.hashCode());
		System.out.println("copy 주소값"+copy.hashCode());
	}
	public void method2() {
		//깊은복사
		//1.for문 활용 - 새로운 배열을 생성하고 반복문을 통해 실제 값을 넣어주는 방법
		//인덱스			0 1 2 3 4
		int[] origin = {1,2,3,4,5};
		
		int[] copy = new int[5];//크기가 5인 빈 배열을 만듦, 다 0으로 초기화 된 상태
		
		for(int i =0; i<origin.length;i++) {
			copy[i] =origin[i];
		}
		copy[2] =99;
		System.out.println("원본 배열 출력");
		for(int i =0; i<origin.length;i++) {
			System.out.println(origin[i]);
		}
		System.out.println("복사본 배열 출력");
		for(int i =0; i<copy.length;i++) {
			System.out.println(copy[i]);
		}
		System.out.println("origin 주소값"+origin.hashCode());
		System.out.println("copy 주소값"+copy.hashCode());
	}
	
	
	public void method3() {
		//2.arraycopy() 메소드를 
		int[] origin = {1,2,3,4,5};
		
		int[] copy = new int[10];
		
		//System.arraycopy(원본배열명, 복사시작할 인덱스, 복사본 배열명, 복사본 배열의 복사될 시작위치, 복사길이)
		System.arraycopy(origin, 0, copy, 2, origin.length);
		
		System.out.println("복사본 배열 출력");
		for(int i =0; i<copy.length;i++) {
			System.out.print(copy[i]);
		}
		System.out.println();
		System.out.println("origin 길이"+origin.length);
		System.out.println("copy 길이"+copy.length);
		System.out.println("origin 주소값"+origin.hashCode());
		System.out.println("copy 주소값"+copy.hashCode());
	}
	
	public void method4() {
		//3.Arrays 클래스의 copyOf() 메소드를 이용한 복사
		 
		int[] origin = {1,2,3,4,5};
		
		//Arrays.copyOf(원본배열명, 복사할길이 (원본보다 길어도됨, 길면 자동으로 0으로 초기화되어 들어간다) 
		//내가 지정한 길이만큼 무조건 할당
		
		int[] copy = Arrays.copyOf(origin, 8); //초기화 한 다음에는 못하나?
		
//		int[] copy=new;
//		copy = Arrays.copyOf(origin, 8); //초기화 한 다음에는 못하나? 다시 함 해보기
		
		System.out.println("복사본 배열 출력");
		for(int i =0; i<copy.length;i++) {
			System.out.print(copy[i]);
		}
		System.out.println();
		System.out.println("origin 길이"+origin.length);
		System.out.println("copy 길이"+copy.length);
		System.out.println("origin 주소값"+origin.hashCode());
		System.out.println("copy 주소값"+copy.hashCode());
	}
	
	/* System.arraycopy() 메소드는 내가 복사 하고자할때 인덱스와 갯수를 지정하고 싶을때 사용, 복사본 배열의 크기가 그대로 유지 
	 * copy = Arrays.copyOf() 메소드는 내가 복사하고자 하는 것을 복사 하고 크기도 다시 지정 하고 싶을때 사용 
	 * 
	 * */

	
	public void method5() {
		//4.clone()
		
		int[] origin = {1,2,3,4,5};
		
		int[] copy = origin.clone();
		
		copy[2] =99;
		System.out.println("원본 배열 출력");
		for(int i =0; i<origin.length;i++) {
			System.out.print(origin[i]);
		}
		System.out.println();
		System.out.println("복사본 배열 출력");
		for(int i =0; i<copy.length;i++) {
			System.out.print(copy[i]);
		}
		System.out.println();
		System.out.println("origin 주소값"+origin.hashCode());
		System.out.println("copy 주소값"+copy.hashCode());
		
	}
	
}
