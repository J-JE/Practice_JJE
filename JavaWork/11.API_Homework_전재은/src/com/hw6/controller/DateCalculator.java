package com.hw6.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateCalculator {

	public DateCalculator() {	}

	public long leapDate() {
		/*1년 1월 1일부터 오늘까지의 총 날 수를 계산
		1년부터 현재 연도까지 각 연도가 윤년이면 총 날수에 366일을, 평년이면 365일을 더함
		해당 현재 연도가 윤년이면 2월을 29일로 평년이면 28일로더함
		월의 날짜 수를 더함 (31일: 1, 3, 5, 7, 8, 10, 12월/ 30일: 4, 6, 9, 11월)*/
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		
		long count = 0;
		
		for(int i = 1;i<today.getYear()+1900;i++) { //1년(i=1) ~ 지난해(i<2022)까지 일 수 계산
			if(isLeapYear(i)) {
				count+=366;
			}else {
				count+=365;
			}
		}
		
		for(int i = 1; i<today.getMonth()+1;i++) {//1월~지난달까지 일 수 계산
			if(i==1||i==3||i==5||i==7||i==8||i==10||i==12) {
				count+=31;
			}else if(i==4||i==6||i==9||i==11){
				count +=30;
			}else if(i==2){
				if(isLeapYear(today.getYear())){//윤년
					count+=29;
				}else {
					count+=28;
				}
			}
		}
	
		for(int i = 1; i<=today.getDate();i++) { //이번달 1일~오늘까지 일 수 계산
			count+=1;
		}
		
		
		return count;
	}
	
	public long leapDate_guide1() {
		Calendar today=Calendar.getInstance();
		long sumDays=0L;
		
		for(int i=1;i<=today.get(Calendar.YEAR);i++) { 					// Year
			if(i==today.get(Calendar.YEAR)){ 							// 올해가 되면
				if(isLeapYear(i)) System.out.println("올해는 윤년입니다.");
				else System.out.println("올해는 평년입니다.");
				
				for(int j=1;j<=(today.get(Calendar.MONTH)+1);j++){ 		// Month
					
					if(j==(today.get(Calendar.MONTH)+1)) {				// 이번달이 되면
						for(int n=1;n<=today.get(Calendar.DATE);n++) 	// Date, 오늘이 되면
						{
							sumDays+=1;
						}
					}
					
					else if(j==2) { //지난달 까지
						if(isLeapYear(i)) sumDays+=29;
						else sumDays+=28;
					}
					else if(j==4||j==6||j==9||j==11) {
						sumDays+=30;
					}
					else sumDays+=31;
				}
			}
			
			else {//지난해 까지
				if(isLeapYear(i)) sumDays+=366;
				else sumDays+=365;	
			}
		}
		return sumDays;
	}

	public long leapDate_guide2() {//GregorianCalendar()클래스에서 제공하는 isLeapYear() 메소드
		
		GregorianCalendar today=new GregorianCalendar();
		long sumDays=0L;
		for(int i=1;i<=today.get(GregorianCalendar.YEAR);i++) { 					// Year
			if(i==today.get(GregorianCalendar.YEAR)){ 							// 올해가 되면,
				if(today.isLeapYear(GregorianCalendar.YEAR)) System.out.println("올해는 윤년입니다.");
				else System.out.println("올해는 평년입니다.");
				
				for(int j=1;j<=(today.get(GregorianCalendar.MONTH)+1);j++){ 		// Month
					
					if(j==(today.get(GregorianCalendar.MONTH)+1)) {				// 이번달이 되면,
						
						for(int n=1;n<=today.get(GregorianCalendar.DATE);n++) 	// Date, 오늘이 되면,
						{
							sumDays+=1;
						}
					}
					
					else if(j==2) {
						if(today.isLeapYear(GregorianCalendar.YEAR)) sumDays+=29;
						else sumDays+=28;
					}
					else if(j==4||j==6||j==9||j==11) {
						sumDays+=30;
					}
					else sumDays+=31;
				}
			}
			
			else {
				if(today.isLeapYear(GregorianCalendar.YEAR)) sumDays+=366;
				else sumDays+=365;	
			}
		}
		return sumDays;
	}
	
	public boolean isLeapYear(int year) { //윤년 여부 boolean
		/*연도가 윤년이면 true, 평년이면 false 리턴
		(윤년: 연도가 4의 배수이면서,100의 배수가 아니거나 400의배수가 되는 해)*/

		
		if ((year %4 ==0 && year %100 !=0) || year %400 ==0) {
			return true;
		} else {
			return false;
		}
	}

}
