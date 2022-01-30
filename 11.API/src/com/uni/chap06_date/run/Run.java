package com.uni.chap06_date.run;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Run {

	/*
	 * 1. Date (java.util 패키지)
	 * - Date는 날짜를 다루기 위해 제공되는 클래스
	 * - 자바개발 초기에 급하게 만들어서 완성도도 낮고, 다국적으로 쓰기도 적합하지 않음
	 * - 1970년 1월 1일 0시 0분 0초를 기준으로 milliseconds 단위로 계산함
	 * - Date는 년도는 +1900, 월은 +1을 내부적으로 한다.
	 */
	public static void main(String[] args) {
		// Date

		
		// 현재 시각(Date 기본 생성) : 컴퓨터의 시간
		Date today = new Date();
		System.out.println(today);
		
		// 내가 원하는 날짜(Date의 매개변수 있는 생성자)
		Date today1 = new Date(120, 0, 28);	// 2020.01.28 -> (120+1900, 0+1, 28)
		System.out.println(today1);
		
		/*@Deprecated
		public Date(int year,
		                        int month,
		                        int date)

		Deprecated. As of JDK version 1.1,replaced by Calendar.set(year + 1900, month, date)or GregorianCalendar(year + 1900, month, date).
		*/
		// 원하는 패턴으로 뽑아보자
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E요일");
		System.out.println(sdf.format(today1));
	
		
		// 시각에 대해 원하는 값 뽑아 보기
		System.out.println("시간 : " + today.getTime());
		System.out.println("날짜 : " + today.getDate());
		System.out.println("요일 : " + today.getDay());
		System.out.println("시 : " + today.getHours());
		System.out.println("분 : " + today.getMinutes());
		System.out.println("달 : " + (today.getMonth() + 1));	// 주의
		System.out.println("초 : " + today.getSeconds());
		System.out.println("년 : " + (today.getYear() + 1900));	// 주의
		
		String curTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		
		System.out.println("curTime"+curTime);
		
		System.out.println("------------ 캘린더 -------------");
		// 2. Calendar
		// - 월만 +1 (년도는 직접입력)
		//   ex) 20라고 적으면 그냥 20년도로 인식, 2020로 입력해야 될 때는 2020을 입력
		// - TimeZone 기능 제공
		// - filed number 개념 도입(메소드 명을 같이 쓰기 위함)
		
		Calendar calendar = Calendar.getInstance();	// 현재 시각
							// new Calendar()를 쓸 수 없다. (기본생성자가 protected이기 때문에)
		
		calendar.set(2020, 0, 28); // set메소드를 통해서 시간을 설정
									// 년도는 full로 다 쓰고, 월은 Date때와 마찬가지로 -1인 값을 넣어줘야 함
		calendar.set(2008, 2-1, 29);
		// 시간에 대해 원하는 값 뽑기
		System.out.println("날짜 : " + calendar.get(GregorianCalendar.DATE));
		System.out.println("요일 : " + calendar.get(GregorianCalendar.DAY_OF_WEEK));
		System.out.println("시 : " + calendar.get(GregorianCalendar.HOUR));
		System.out.println("분 : " + calendar.get(GregorianCalendar.MINUTE));
		System.out.println("달 : " + (calendar.get(GregorianCalendar.MONTH)+1));	// 주의
		System.out.println("초 : " + calendar.get(GregorianCalendar.SECOND));
		System.out.println("년 : " + calendar.get(GregorianCalendar.YEAR));	
		
		// 원하는 format으로..
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd E요일 hh:mm:ss a");
		System.out.println(sdf1.format(calendar.getTime()));
		
		System.out.println("------------ 그레고리안 캘린더 -------------");
		// 윤년이란? 년도가(4의 배수이면서, 100의 배수가 아니거나)
		//              (400의 배수가)가 되는 해가 윤년(1년을 366일로 계산(=2월이 29일인 해))
		
		// 율리우스력의 근소한 오차 값을 수정한 그레고리력
		// (1년을 365 1/4일(365.2422일))
		// 1) 그 해의 연도가 4의 배수가 아니면 평년으로 2월은 28일만 있다.
		// 2) 만약 연도가 4의 배수면서 100의 배수가 아니면 윤일(2월 29일)을 도입한다.
		// 3) 만약 연도가 100의 배수이면서 400의 배수가 아닐 때 이 해는 평년으로 생각한다.
		// 4) 만약 연도가 400의 배수면 윤일(2월 29일)을 도입한다.
		
		// 2)의 예
		// 2008년 (윤년, 366일)
		
		// 3)의 예
		// 2300년 (평년, 365일)
		
		// 4)의 예
		// 2400년 (윤년, 366일)
		
		GregorianCalendar gc = new GregorianCalendar();	// 현재시간
		
		// 시간에 대해 원하는 값 뽑기
		System.out.println("날짜 : " + gc.get(GregorianCalendar.DATE));
		System.out.println("요일 : " + gc.get(GregorianCalendar.DAY_OF_WEEK));
		System.out.println("시 : " + gc.get(GregorianCalendar.HOUR));
		System.out.println("분 : " + gc.get(GregorianCalendar.MINUTE));
		System.out.println("달 : " + (gc.get(GregorianCalendar.MONTH)+1));	// 주의
		System.out.println("초 : " + gc.get(GregorianCalendar.SECOND));
		System.out.println("년 : " + gc.get(GregorianCalendar.YEAR));
		
		gc.set(2020, 5-1, 27);
		gc.set(2008, 2-1, 29);
		System.out.println(gc.getTime());
		
	}
}
