package com.hw3.model.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Book implements Serializable{

	private String title;
	private String author;
	private int price;
	private Calendar dates;
	private double discout;
	
	public Book() {
	}

	public Book(String title, String author, int price, Calendar dates, double discout) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.dates = dates;
		this.discout = discout;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Calendar getDates() {
		return dates;
	}

	public void setDates(Calendar dates) {
		this.dates = dates;
	}

	public double getDiscout() {
		return discout;
	}

	public void setDiscout(double discout) {
		this.discout = discout;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 출간 ");
		String str=sdf.format(dates.getTime());
		return title + " " + author + " " + price + " " +str+" "+ discout;
	}
}
