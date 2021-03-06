package com.hw1.controller;

import com.hw1.model.vo.Guests;
import com.hw1.model.vo.RollerCoaster;

public class RideController {
	Guests[] gs = new Guests[4];
	Guests[] onboard = new Guests[RollerCoaster.PERMITNUMBER]; //동시 탑승 제한 인원2
	
	public RideController() {
	}
	
	public void cutGuest() {
		/*예외처리를 통해 인원을 제한하고 탑승자와 관련된 정보 출력*/
		gs[0] = new Guests("홍길동", 17, 'm', 120.2);
		gs[1] = new Guests("유관순", 20, 'f', 102.3);
		gs[2] = new Guests("김유신", 23, 'm', 110.4);
		gs[3] = new Guests("김흥부", 21, 'm', 112.5);
		
		int count =0;
		try {
			for(int i=0; i<gs.length;i++) {
				// for문과 if문을 통해 RollerCoaster 클래스의 허용키 상수값 크기
				// 이상인 사람을 Guests객체 배열 onBoard에 담는다.
				if(RollerCoaster.CUTHEIGHT<=gs[i].getHeight()) {//탑승 대기자의 키 비교
					onboard[count++]= gs[i];
				}
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			// 문제가 발생한 해당 배열의 인덱스 번호가 몇번에서 발생하는지
			
			char ch = e.getMessage().charAt(e.getMessage().length()-1);//Index 2 out of bounds for length 2의 마지막 글자
			System.out.println("문제가 발생한 해당 배열의 인덱스 번호 : "+ch); // Throwable클래스의 getMessage()메소드를 통해 출력
		}finally {
			System.out.println("인원이 가득 찼습니다. 다음 차례를 기다리세요");
			System.out.println("이번 차례 탑승 명단");
			
			// 탑승자 각각의 이름, 키를 출력하고 두 탑승자의 요금합계를 출력 하시오
			for(Guests g : onboard) {
				System.out.println("이름 : "+ g.getName() +", 키 : "+g.getHeight());
			}
			System.out.println("탑승자 요금 합계 : "+RollerCoaster.PRICE*(count-1));//count++
		}
		
	}
}
