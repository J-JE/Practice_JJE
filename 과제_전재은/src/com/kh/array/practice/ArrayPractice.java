package com.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

	 public void practice1(){
		 int[] arr = new int[10];
		 
		 for(int i=0; i<arr.length;i++) {
			 arr[i] =i+1;
			 System.out.print(arr[i]+" ");
		 }
	 }
	 public void practice2(){
		 int[] arr = new int[10];
		 
		 int j = 10;
		 for(int i=0; i<arr.length;i++) {
			 arr[i] =j;
			 j -=1;
			 System.out.print(arr[i]+" ");
		 }
	 }
	 
	 public void practice3() {
		 
		 Scanner sc = new Scanner(System.in);
		 System.out.println("양의 정수 : ");
		 int n = sc.nextInt();
		 
		 int[] arr = new int[n];

		 for(int i=0; i<arr.length;i++) {
			 arr[i] =i+1;
			 System.out.print(arr[i]+" ");
		 }
	 }
	 
	 public void practice4() {
		 String[] arr = new String[] {"사과","귤","포도","복숭아","참외"};
		 
		 System.out.println(arr[1]);
	 }

	 public void practice5() {
		 Scanner sc =new Scanner(System.in);
		 System.out.println("문자열 : ");
		 String str =sc.nextLine();
		 System.out.println("문자 : ");
		 char ch =sc.next().charAt(0);
		 
		 char[] arr = new char[str.length()+1];
		 int count = 0;
		 String index ="";
		 
		 for(int i=0;i<arr.length-1;i++) {
			 arr[i]= str.charAt(i) ;
			 if(ch==arr[i]) {
				 index += i+" ";
				 count++;
			 }
		 }
		 System.out.println(str+"에 "+ch+"가 존재하는 위치(인덱스) : "+index );
		 System.out.println(ch+" 개수 : "+count);
	 }

	 public void practice6() {
		 char[] w = new char[] {'월','화','수','목','금','토','일'};
		 Scanner sc =new Scanner(System.in);
		 System.out.println("0 ~ 6 사이 숫자 입력 : ");
		 int n = sc.nextInt();
		 
		 if(n>=0 && n<=6) {
			 System.out.println(w[n]+"요일");
		 }else {
			 System.out.println("잘못 입력하셨습니다.");
		 }
	 }
	 
	 public void practice7() {
		 Scanner sc =new Scanner(System.in);
		 System.out.println("정수 : ");
		 int iNum = sc.nextInt();
		 int[] arr = new int[iNum];
		 int sum = 0;
		 
		 for(int i=0;i<arr.length;i++) {
			System.out.println("배열"+i+"번째 인덱스에 넣을 값 : ");
			int num =sc.nextInt();
			arr[i] = num;
			sum += num;
		 }
		 for(int i =0; i<arr.length;i++) {
			 System.out.print(arr[i]+" ");
		 }
		 System.out.println();
		 System.out.println("총 합 : "+sum);
	 }
	 
	 public void practice8() {
		 Scanner sc =new Scanner(System.in);
		 
		 while(true) {
			 System.out.println("정수 : ");
			 int n=sc.nextInt();

			 if (n>=3&&n%2==1) {
				 int[] arr =new int[n];
				 int j = 1;

				 for(int i=0;i<n;i++) {
					 if(i<=n/2) {
						 arr[i] = i+1;
					 }else {
						 arr[i] = i-j;
						 j +=2;
					 }
					 if(i<n-1) {
						 System.out.print(arr[i]+", ");
						 
					 }else {
						 System.out.println(1);
					 }
				 }
				 break;
			 }else {
				 System.out.println("다시 입력하세요.");
			 }
		 }
	 }
	 
	 public void practice9() {
		 String[] menu =new String[] {"후라이드","양념","간장"};
		 
		 Scanner sc =new Scanner(System.in);
		 System.out.println("치킨 이름을 입력하세요 : ");
		 String str =sc.nextLine();
		 
		 if(str.equals(menu[0])) {
			 System.out.println(str+"치킨 배달 가능");
		 }else if(str.equals(menu[1])){
			 System.out.println(str+"치킨 배달 가능");
		 }else if(str.equals(menu[2])){
			 System.out.println(str+"치킨 배달 가능");
		 }else {
			 System.out.println(str+"치킨은 없는 메뉴입니다.");
		 }
	 }
	 
	 public void practice10() {
		 int[] arr = new int[10];
		 
		 for(int i=0;i<arr.length;i++) {
			 arr[i] = (int)(Math.random()*10+1);
			 System.out.print(arr[i]+" ");
		 }
	 }
	 
	 public void practice11() {
		 int[] arr = new int[10];
		 
		 for(int i=0;i<arr.length;i++) {
			 arr[i] = (int)(Math.random()*10+1);
			 System.out.print(arr[i]+" ");
		 }
		 System.out.println();
		 Arrays.sort(arr);
		 System.out.println("최대값 : "+arr[9]);
		 System.out.println("최소값 : "+arr[0]);
	 }
	 
	 public void practice12() {
		 int[] arr =new int[10];

		 for(int i=0;i<arr.length;i++) {
			 arr[i] = (int)(Math.random()*10+1);
			 for(int j=0;j<i;j++) {
				 if(arr[i]==arr[j]) {
					 i--;
					 break;
				 }
			 }
		 }	 
		 for(int i=0;i<arr.length;i++) {
			 System.out.print(arr[i]+" ");
		 }
	 }
	 
	 public void practice13() {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("주민등록번호(-포함) : ");
		 String str =sc.nextLine();

		 char[] num =new char[14];

		 for(int i=0; i<=13;i++) {
			 num[i] = str.charAt(i);
			 if(i<=7) {
				 System.out.print(num[i]);
			 }else{
				 System.out.print("*");
			 }
		 }
	 }
	 
	 public void practice14() {
		 int[] arr =new int[6];
		 
		 for(int i=0;i<arr.length;i++) {
			 arr[i]=(int)(Math.random()*45+1);
			 for(int j=0;j<i;j++) {
				 if(arr[i]==arr[j]) {
					 i--;
					 break;
				 }
			 }
			 
		 }
		 for(int i =0; i<arr.length;i++) {
			 for(int j=0;j<i;j++) {
				 if(arr[i]<arr[j]) {
					 int temp =arr[i];
					 arr[i]=arr[j];
					 arr[j]=temp;
				 }
			 }
		 }
		 for(int i=0;i<arr.length;i++) {
			 System.out.print(arr[i]+" ");
		 }
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
