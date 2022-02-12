package com.hw3.run;

import com.hw3.controller.SetDate;

public class Run {

	public static void main(String[] args) {
		SetDate tw1 = new SetDate();
		// todayPrint()을 출력한다.
		// setDay()을 출력한다.
		System.out.println(tw1.todayPrint());
		System.out.println(tw1.setDay());
	}

}
