package com.kh.dimension.practice;

import java.util.Scanner;

public class DimensionPractice {

	 public void practice1() {
		 int[][] arr =new int[4][4];
		 int value=1;
		 
		 for(int i=0; i<arr.length;i++) {
			 for(int j=0; j<arr[i].length;j++) {
				 arr[i][j] = value++;
			 }
		 }
		 
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf("%2d ",arr[i][j]);
			}
			System.out.println();
		}
	 }
	 
	 public void practice2() {
		 int[][] arr =new int[4][4];
		 int value=16;
		 
		 for(int i=0; i<arr.length;i++) {
			 for(int j=0; j<arr[i].length;j++) {
				 arr[i][j] = value--;
			 }
		 }
		 
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf("%2d ",arr[i][j]);
			}
			System.out.println();
		}
	 }
	 
	 public void practice3() {
		 String[][] arr = new String[3][3];
		 String[] sArr= new String[] {"0","1","2"};

		 for(int i=0; i<arr.length;i++) {
			 for(int j=0; j<arr[i].length;j++) {
				 arr[i][j] = "("+sArr[i]+", "+sArr[j]+")";
			 }
		 }
		 
		 for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[i].length;j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
		 }
	 }
	 
	 public void practice4() {
		 int[][] arr = new int[4][4]; 
		 
		 int sum=0;
		 for(int i=0; i<arr.length-1;i++) { //0~3행까지 값을 입력하기 위함
			 int jsum =0; //다음 행으로 넘어갈 때 마다 초기화 해야하기 때문에 두번째 for문 밖, 첫번째 for문 안에 있어야함 (마지막 열)
				 for(int j=0; j<arr[i].length-1;j++) { //0~3열까지 값을 넣기 위한 반복
					 arr[i][j] = (int)(Math.random()*10+1); //i행j열에 랜덤 값을 넣는다.
					 jsum+=arr[i][j]; //3열에 대입할 행들의 합을 위한 연산
					 arr[arr.length-1][j] +=arr[i][j]; //3행 j열에 열들의 값을 더해준다.
					 sum +=arr[i][j]; //각 행의 마지막 열에 넣을 값 (ex. [0][3])
				 }
				 arr[i][arr.length-1]=jsum; //i행 3열에 값
		 }
		 arr[arr.length-1][arr.length-1]=sum;//3행 3열에 값
		

		 for(int i=0; i<arr.length;i++) {
			 for(int j=0; j<arr[i].length;j++) {
				 System.out.printf("%2d ",arr[i][j]);
			 }
			 System.out.println();
		 }
	
	 }
	 
	 public void practice5() {
		 Scanner sc = new Scanner(System.in);
		 
		 while(true) {
			 System.out.print("행 크기 : ");
			 int num1 =sc.nextInt();
			 System.out.print("열 크기 : ");
			 int num2 = sc.nextInt();

			 if((num1<1||num1>10)||(num2<1||num2>10)) {
				 System.out.println("no");
			 }else {
				 char[][] arr =new char[num1][num2];
				 for(int i=0;i<arr.length;i++) {
					 for(int j=0;j<arr[i].length;j++) {
						 arr[i][j]=(char)(Math.random()*26+65);
						 System.out.print(arr[i][j]+" ");
					 }
					 System.out.println();
				 }
				 break; //while 탈출
			 }
		 }
	 }
	 
	 public void practice6() {
		 String[][] strArr = new String[][]
		 { {"이", "까", "왔", "앞", "힘"}
		 , {"차", "지", "습", "으", "냅"}
		 , {"원", "열", "니", "로", "시"}
		 , {"배", "심", "다", "좀", "다"}
		 , {"열", "히", "!", "더", "!!"} };
		 
		  String temp="";
		  
		  for(int i=0;i<strArr.length;i++) {
			  for(int j=0; j<i;j++) {
				  temp = strArr[i][j];
				  strArr[i][j] = strArr[j][i];
				  strArr[j][i] = temp;
			  }
		  }
		  for(int i=0;i<strArr.length;i++) {
			  for(int j=0; j<strArr[i].length;j++) {
				  System.out.print(strArr[i][j]);
				  System.out.print(" ");
			  }
			  System.out.println();
		  }
	 }

	 public void practice7() {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("행의 크기 : ");
		 int n =sc.nextInt();
		 char [][] arr=new char[n][];
		 
		 char[] lc =new char['z'-'a'+1];
		 int num = 'a';
		 for(int i=0;num<='z';i++) {
			 lc[i]=(char)num;
			 num++;
		 }
		 
		 for(int i=0;i<arr.length;i++) {
			 System.out.println(i+"행의 크기 : ");
			 int m =sc.nextInt();
			 arr[i] =new char[m];
		 }
		 int k=0;
		 for(int i=0;i<arr.length;i++) {
			 for(int j=0;j<arr[i].length;j++) {
				 arr[i][j]=lc[k];
				 k++;
				 System.out.print(arr[i][j]+" ");
			 }
			 System.out.println();
		 }
	 }
	 
	 public void practice8() {
		String [] name =new String[]{"강건강","남나나","도대담","류라라","문미미","박보배"
			,"송성실","윤예의","진재주","차천축","피풍표","홍하하"};
		int count =0;
		
		System.out.println("== 1분단 ==");
		String[][] team1 =new String[3][2];
		for(int i=0;i<team1.length;i++) {
			for(int j=0; j<team1[i].length;j++) {
				team1[i][j]=name[count];
				System.out.print(team1[i][j]+" ");
				count++;
			}
			System.out.println();
		}
		System.out.println("== 2분단 ==");
		String[][] team2 =new String[3][2];
		for(int i=0;i<team2.length;i++) {
			for(int j=0; j<team2[i].length;j++) {
				team2[i][j]=name[count];
				System.out.print(team2[i][j]+" ");
				count++;
			}
			System.out.println();
		}
	 }
	 
	 public void practice9() {
		 String [] name =new String[]{"강건강","남나나","도대담","류라라","문미미","박보배"
					,"송성실","윤예의","진재주","차천축","피풍표","홍하하"};
				int count =0;
				
				System.out.println("== 1분단 ==");
				String[][] team1 =new String[3][2];
				for(int i=0;i<team1.length;i++) {
					for(int j=0; j<team1[i].length;j++) {
						team1[i][j]=name[count];
						System.out.print(team1[i][j]+" ");
						count++;
					}
					System.out.println();
				}
				System.out.println("== 2분단 ==");
				String[][] team2 =new String[3][2];
				for(int i=0;i<team2.length;i++) {
					for(int j=0; j<team2[i].length;j++) {
						team2[i][j]=name[count];
						System.out.print(team2[i][j]+" ");
						count++;
					}
					System.out.println();
				}
		 
		 Scanner sc = new Scanner(System.in);
		 System.out.println("============================");
		 System.out.println("검색할 학생 이름을 입력하세요 : ");
		 String search =sc.nextLine();
		 
		 String line = "왼쪽";
		 for(int i=0;i<team1.length;i++) {
				for(int j=0; j<team1[i].length;j++) {
					if(search.equals(team1[i][j])) {
						if(j==1) {
							line="오른쪽";
						}
						System.out.println("검색하신 "+search+" 학생은 1분단 "+(i+1)+"번째 줄 "+line+"에 있습니다.");
					}
				}
			}
		 for(int i=0;i<team2.length;i++) {
			 for(int j=0; j<team2[i].length;j++) {
				 if(search.equals(team2[i][j])) {
					 if(j==1) {
						 line="오른쪽";
					 }
					 System.out.println("검색하신 "+search+" 학생은 2분단 "+(i+1)+"번째 줄 "+line+"에 있습니다.");
				 }
			 }
		 }
	 }

	 public void method2(){
		 int[][] arr = new int[5][5]; //5, 5크기의 배열 선언
		 
		 for(int i=0; i<arr.length;i++) {//행
			 arr[i][0] =i+1;//0행0열 값은 1로 시작
			 for(int j=1;j<arr[i].length;j++) {//열
				 //0열은 행for문에서 값을 줬기 때문에 생략
				 arr[i][j] = arr[i][j-1]+5; //앞열의 값+5
			 }
		 }
		 
		 for(int i=0; i<arr.length;i++) {//행
			 for(int j=0;j<arr.length;j++) {//열
				 System.out.print(arr[i][j]+"  ");
			 }
			 System.out.println();
		 }
	 }
	 
	 public void method3(){
		 int[][] arr = new int[5][5]; //5, 5크기의 배열 선언
		 
		 int k=1; //배열에 넣을 정수값
		 for(int i=0;i<arr.length;i++) {
			 if(i%2==0) { //짝수행
				 for(int j=0; j<arr[i].length;j++) {
					 arr[i][j]=k++; //1씩 증가하는 값
				 }
				 
			 }else { //홀수행
				 for(int j=(arr[i].length)-1; j>=0;j--) {
					//열의 값을 뒤집어야 하기 때문에 짝수행의 조건식과 선언부의 값을 바꿔서 넣었다.
					//짝수 행에서는 0~4까지 k가 1씩 증가했다면
					//홀수 행에서는 4~0 순서로 k가 1씩 증가해야하기 때문이다.
					 arr[i][j]=k++;
				 }
			 }
		 }
		 
		 for(int i=0; i<arr.length;i++) {//행
			 for(int j=0;j<arr.length;j++) {//열
				 System.out.print(arr[i][j]+"  ");
			 }
			 System.out.println();
		 }
	 }
	 
	 public void method4(){
		 int[][] arr = new int[5][5]; //5, 5크기의 배열 선언
		 
		 
		 for(int i=0; i<arr.length;i++) {//행
			 arr[i][0] =i+1;//0행0열 값은 1로 시작
			 for(int j=1;j<arr[i].length;j++) {//열
				 if(j%2==0) {//짝수열
					 if(i==0) { //행이 0일 때
						 arr[i][j] = arr[i][j-1]+1;
						 //이전 열의 0행값 +1
					 }else {
						 arr[i][j] = arr[i-1][j]+1;
						 //이전 행 값+!
					 }
				 }else {//홀수열
					 if(i==0) {
						 arr[i][j] = arr[i][j-1]+9;
						 //이전 열 값+9
					 }else {
						 arr[i][j] = arr[i-1][j]-1;
						 //이전 행 값-1
					 }
				 }
			 }
		 }
		 
		 for(int i=0; i<arr.length;i++) {//행
			 for(int j=0;j<arr.length;j++) {//열
				 System.out.print(arr[i][j]+"  ");
			 }
			 System.out.println();
		 }
	 }

}
