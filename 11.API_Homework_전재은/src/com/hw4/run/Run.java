package com.hw4.run;

import com.hw4.controller.EmpTest;

public class Run {
	
	/*
	* Employee[] 라는 객체 배열에 5명의 사원 명, 나이, 급여, 세율을 등록한다. 이후에 사원 명, 나이, 급여,
	* 세율, 실제 급여를 등록 순, 이름 순으로 출력한다.
	* 실제 급여 = 급여 – (급여 * 세율 / 100)
	*/
	
	public static void main(String[] args) {
		EmpTest et = new EmpTest();
		
		// setEmp()를 실행 해 기존 사원들 등록 및 입력을 통한 사원 한명 정보 등록
		et.setEmp();
		
		System.out.println("------------------------정렬 이전------------------------");
		// printEmp()를 실행 해 사원들 출력
		et.printEmp();
		
		// nameSortPrint()를 통해 사원들의 이름을 오름차순으로 출력
		et.nameSortPrint();
		
		System.out.println("------------------------정렬 이후------------------------");
		// printEmp()를 실행 해 사원들 출력
		et.printEmp();
	}

}
