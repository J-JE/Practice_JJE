package com.uni.dimension;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DimensionalArray {

	// 이차원 배열 : 일차원 배열 여러개를 하나로 묶은것
	public void method1() {
		/*
		 * 1. 이차원 배열 선언
		 *    자료형 배열명[][];
		 *    자료형[] 배열명[];
		 *    자료형[][] 배열명;
		 * */

		int arr1[][];
		int[] arr2[];
		int[][] arr;
		
		/*
		 * 2. 이차원 배열 할당
		 * 배열명 = new 자료형[행크기][열크기];
		 * 
		 * */

		arr = new int [3][5]; //할당을 하게 되면, heap 영역에 해당 크기만큼 공간이 할당된다.
		
		int[][] arr3 = new int[3][];
		//행의 길이
//		System.out.println("행의 길이"+arr.length);
//		System.out.println("열의 길이"+arr[0].length);
//		System.out.println("열의 길이"+arr[1].length);
//		System.out.println("열의 길이"+arr[2].length);
		
		//*****
		//*****
		//*****
		
		//바깥쪽 for문 -> 행의 개수만큼 반복
		//안쪽 for문 -> 열의 개수만큼 반복
		
		for(int i=0; i<3;i++) {
			for(int j=0; j<5;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void method2() {
		int arr[][] =new int[3][5];
		// 1 2 3 4 5
		// 6 7 8 9 10
		// 11 12 13 14 15

		
		//1.인덱스에 접근하여 값기록
		arr[0][0] =1;
		arr[0][1] =2;
		arr[0][2] =3;
		arr[0][3] =4;
		arr[0][4] =5;
		
		arr[1][0] =6;
		arr[1][1] =7;
		arr[1][2] =8;
		arr[1][3] =9;
		arr[1][4] =10;
		
		arr[2][0] =11;
		arr[2][1] =12;
		arr[2][2] =13;
		arr[2][3] =14;
		arr[2][4] =15;
		
		
		//2. 중첩for문을 이용해서 값기록
		int value =1;
		
		for(int i=0; i<arr.length;i++) {
			
			for(int j=0; j<arr[i].length;j++) {
				
				arr[i][j]=value++;
			}
		}
		
		for(int i=0; i<arr.length;i++) {

			for(int j=0; j<arr[i].length;j++) {
				System.out.printf("%2d ",arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void method3() {
		//이차원 배열의 할당과 동시에 초기화
		
		int[][] arr ={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
		
		for(int i=0; i<arr.length;i++) {

			for(int j=0; j<arr[i].length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public void method4() {
		//가변배열
		//행은 정해졌으나 각 행에 대한 열의 갯수가 정해지지않은 상태 
		//자료형이 같은 1차원 배열 여러개를 하나로 묶은게 --> 2차원배열 
		//묶여있는 1차원 배열의 길이가 꼭 같을 필요는 없다.

		int[][] arr =new int[3][]; //가변 배열 할당(행의 크기는 3)
		
		arr[0] =new int[2];
		arr[1] =new int[1];
		arr[2] =new int[3];
		
		//1.인덱스로 접근
//		arr[0][0] =1;
//		arr[0][1] =2;
//		
//		arr[1][0] =3;
//		
//		arr[2][0] =4;
//		arr[2][1] =5;
//		arr[2][2] =6;
		
		//2.중첩for문으로 접근
		int value=1;
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr[i].length;j++) {
				arr[i][j] =value++;
			}
		}
		
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void method5() {
		int[][] arr ={{1,2},{3},{4,5,6}};
		
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	public void method6() {
		//Scanner 이용해서 국어 점수와 영어점수를 3번 찍어서 각각 평균을 구하시오
		double[][] arr =new double[2][4];
		Scanner sc=new Scanner(System.in);
		
		int arrILgth =0; //인덱스 길이를 담을 변수 선언, 초기화
		
		for(int i=0;i<arr.length;i++) { //2번 반복됨
			arrILgth = arr[i].length -1; //i행의 인덱스 길이-1 는 3이다. 마지막 열은 비워두고 값을 받기 위함이다.
			double sum = 0; //각 과목의 점수를 합산하기 위한 변수
			for(int j=0;j<arr[i].length-1;j++) { //마지막 열을 제외한 길이만큼 반복해서 값을 받겠다.
				if(i==0) { //0번째 행에서는 국어점수 값만 받는다.
					System.out.println("국어 점수 : ");
//					arr[i][j]=sc.nextDouble();//각각 받아도 되고 두번째 for문 끝에서 받아도 됨. i열의j행을 받을것이기 때문
				}else {
					System.out.println("영어 점수 : ");
//					arr[i][j]=sc.nextDouble();
				}
				
				arr[i][j]=sc.nextDouble();
				sum += arr[i][j];
			}
			arr[i][arrILgth]=sum;
		}
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr[i].length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("국어점수평균 : "+arr[0][arrILgth]/arrILgth);
		System.out.println("영어점수평균 : "+arr[1][arrILgth]/arrILgth);
		
		DecimalFormat f1 =new DecimalFormat("0.00");
		
		System.out.println("영어점수평균 : "+f1.format(arr[1][arrILgth]/arrILgth)); //string형으로 반환하는 포멧
		
//뭐가 잘못된건지...모르겠으요
//		for(int i=0;i<arr.length;i++) {
//
//			if(i==0) {
//				for(int j=0;j<arr.length-1;j++) {	
//					System.out.println("국어 점수 : ");
//					double score = sc.nextDouble();
//					arr[i][j]=score;
//				}
//			}else {
//				for(int j=0;j<arr.length-1;j++) {
//					System.out.println("영어 점수 : ");
//					double score = sc.nextDouble();
//					arr[i][j]=score;
//				}
//			}
//			int j=3;
//			while(j==arr.length) {
//				double avg =(arr[i][0]+arr[i][1]+arr[i][2])/3;
//				arr[i][j]=avg;
//			}
//		}
//		System.out.println("국어 : "+arr[0][3]);
//		System.out.println("영어 : "+arr[1][3]);
		
		
	}
	
	public void method7() {
		//1부터 10사이의 랜덤값을 3행 3열에 값을 넣으려고 한다.
		//중복제거해서 넣어보세요
		
		//1. 일차원 배열을 이용해서 먼저 중복 제거
		int[] arr =new int[9]; //인덱스 9개를 받을것
		
		for(int i=0; i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10+1); //1~10까지의 랜덤한 9개의 숫자
			
			for(int j=0; j<i;j++) {
				if(arr[i] ==arr[j]) { //중복된다면
					i--;              //i값을 실행 전으로 돌리고
					break;			  //두번째 for문 다시 시작해서 랜덤값 새로 받기
				}
			}
		}
		
		//2. 이차원배열을 3행 3열로 담기
		int[][] newArr =new int[3][3]; //3행 3열의 인덱스를 생성
		
		int index =0; //9행 인덱스 값을 3행3열 인덱스에 옮기는데 쓸 변수
		
		for(int i=0; i<newArr.length;i++) { //new인덱스의 행의 길이만큼 반복
			for(int j=0; j<newArr[i].length; j++) { //nwe인덱스의 열의 길이만큼 반복
				newArr[i][j] = arr[index++]; //i행j열에 arr인덱스의 값을 담는데, arr 인덱스의 값을 순차적으로 담기 위해 index++을 써준다.
			}
			
		}
		
		for(int i=0; i<newArr.length;i++) {
			for(int j=0; j<newArr[i].length; j++) {
				System.out.print(newArr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	//빙고
	
	public void bingo() {
		Scanner sc=new Scanner(System.in);
		
		//1차원 배열로 중복제거된 25개 값을 구해놓고 이차원 배열에 대입
		int[] arr =new int[25];
		
		for(int i=0; i<arr.length;i++) {
			arr[i]= (int)(Math.random()*25+1);

			for(int j=0; j<i;j++) { //중복 제거 시키기
				if(arr[i] ==arr[j]) {
					i--;
					break;
				}
			}
		}
		
		int[][] bingo = new int[5][5];
		int index = 0;
		
		for(int i=0;i<bingo.length;i++) {
			for(int j=0; j<bingo[i].length;j++) {
				bingo[i][j] = arr[index++];
			}
		}
		for(int i=0;i<bingo.length;i++) { 
			for(int j=0; j<bingo[i].length;j++) {
				System.out.printf("%-4d",bingo[i][j]);
			}
			System.out.println();
		}
		
		int count = 0;
		System.out.println("=====빙고게임 시작=====");
		
		while(true) {
			
			System.out.println("정수값을 입력하세요 ");
			int num=sc.nextInt();
			sc.nextLine();
			
			count++;
			
			for(int i=0;i<5;i++) {
				for(int j=0; j<5;j++) {
					
					if(bingo[i][j] == num) {
						
						bingo[i][j] = 0;
						
					}
					System.out.printf("%-4d ",bingo[i][j]);
				}
				System.out.println();
			}
			
			System.out.println("게임을 끝내시겠습니까? (y/n) : ");
			char ch =sc.nextLine().toUpperCase().charAt(0);
			
			if(ch=='Y') {
				break;
			}
		}
		System.out.println(count);
	}
	
	
}
