package com.hw3.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SetDate {
	
	public SetDate() {
	}
	
	public String todayPrint() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 h시 mm분 ss초");
		Date d = new Date();
		String date = sdf.format(d);
		
		return date;
	}
	
	public String setDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		Date d = new Date(2011-1900, 3-1, 21);
		String date = sdf.format(d);
		return date;
	}
}
