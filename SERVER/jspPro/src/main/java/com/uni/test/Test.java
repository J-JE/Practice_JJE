package com.uni.test;
//package com.kh.test.model;

import java.sql.Date;

public class Test {
	private int number;
	private String writer;
	private String title;
	private String content;
	private Date date;

	public Test() {	}

	public Test(int number, String writer, String title, String content, Date date) {
		super();
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
//CREATE TABLE TEST(
//
//		 SEQ NUMBER,
//
//		 WRITER VARCHAR2(30),
//
//		 TITLE VARCHAR2(100),
//
//		 CONTENT VARCHAR2(200),
//
//		 REGDATE DATE
//
//		);