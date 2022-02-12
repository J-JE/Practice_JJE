package com.uni.chap08_mvc.run;

import com.uni.chap08_mvc.view.ProductMenu;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ProductMenu().mainMenu();
		
		
		
		//MVC패턴
		// Model : 데이터를 담당하는 역할
		// View  : 사용자의 시각적인 요소를 담당하는 역할 (화면같은것)  --> 사용자에게 출력을 해준다거나, 사용자로부터 값을 입력받는 구문들을 진행할 예정
		// Controller : 사용자가 요청하는 기능을 처리해주는 역할 
		
		/*
		 *  Run  		->   View  		 -> 	 Controller
		 *  첫화면 실행		출력및입력 		요청		사용자의 요청을 처리해줌
		 *  							<--
		 *  				결과출력		 요청 처리결과 반환
		 */
	}

}
