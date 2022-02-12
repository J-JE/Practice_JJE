package com.hw1.run;

import com.hw1.model.vo.Employe;

public class Run {

	public static void main(String[] args) {

		// 객체배열을 크기 3으로 할당 한 뒤

		Employe[] emp =new Employe[3];
		// 0번 인덱스에는 기본생성자를 통해서 객체 생성
		emp[0] =new Employe();
		
		// 1번 인덱스에는 매개변수 6개짜리 생성자를 이용하여 객체 생성
		emp[1] =new Employe (1, "홍길동", 19, 'M', "01022223333", "서울 잠실"); //소괄호
		
		// 2번 인덱스에는 매개변수 10개짜리 생성자를 이용하여 객체 생성 후 출력
		emp[2] =new Employe (2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, "01011112222", "서울 마곡");
		
		for(int i =0; i<emp.length;i++) {
			System.out.println(emp[i].information());
		}
		System.out.println("=================================================================");
		
		// 3개의 객체 중 값이 없는 필드에 각각 값을 넣은 뒤 다시 출력
		emp[0] =new Employe (0, "김말똥", "영업부", "팀장", 30, 'M', 3000000, 0.2, "01055559999", "전라도 광주");
		emp[1] =new Employe (1, "홍길동", "기획부", "부장", 19, 'M', 4000000, 0.3, "01022223333", "서울 잠실");
		
		
		for(int i =0; i<emp.length;i++) {
			if(i!=2) {
				System.out.println(emp[i].information());
			}
		}
		System.out.println("=================================================================");
		
		// 직원 각각의 보너스가 적용된 1년 연봉을 계산하여 출력
		int sum =0;
		
		for(int i =0; i<emp.length;i++) {
			
			System.out.print(emp[i].getEmpName()+"의 연봉 : ");
			// 보너스가 적용된 연봉 = (급여 + (급여 * 보너스포인트)) * 12
			int salary =(int)(emp[i].getSalary()+ (emp[i].getSalary()*emp[i].getBonusPoint())) * 12;
			sum+=salary;
			System.out.println(salary +"원");
		}
		System.out.println("=================================================================");
		
		// 3명 직원의 연봉 평균을 구하여 출력 
		System.out.println("직원들의 연봉의 평균 : "+sum/3+"원");
	}

}
