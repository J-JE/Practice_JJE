package com.hw4.controller;

import java.util.Scanner;

import com.hw4.model.vo.Employee;

public class EmpTest {

	private Employee[] empArr;
	
	public EmpTest() {
	}
	
	public void setEmp() {
		Scanner sc = new Scanner(System.in);
		empArr =new Employee[6];
		
		empArr[0] = new Employee("문말똥", 24, 1500000, 1.245);
		empArr[1] = new Employee("장소똥", 40, 2500000, 1.4);
		empArr[2] = new Employee("금개똥", 22, 1780000, 1.3);
		empArr[3] = new Employee("봉쥐똥", 31, 1950000, 1.365);
		empArr[4] = new Employee("홍닭똥", 34, 1650000, 1.212);
		
		System.out.println("이름을 입력하세요 : ");
		String name =sc.nextLine();
		System.out.println("나이를 입력하세요 : ");
		int age =sc.nextInt();
		System.out.println("급여를 입력하세요 : ");
		int salary =sc.nextInt();
		System.out.println("세율을 입력하세요 : ");
		double taxRate =sc.nextDouble();
//		sc.nextLine();
		
		empArr[5] = new Employee(name, age, salary, taxRate);
		
	}
	
	public void printEmp() {
		for(Employee e : empArr) {
			System.out.println(e.toString());
		}
	}
	
	public void nameSortPrint() {
		
		for(int i =0; i<empArr.length;i++) {
			for(int j=0; j<i;j++) {
				int num = empArr[i].getName().compareTo(empArr[j].getName());
				if(num<0) {
					Employee temp = empArr[i];
					empArr[i]=empArr[j];
					empArr[j]=temp;
				}
			}
		}
	}
	
}
