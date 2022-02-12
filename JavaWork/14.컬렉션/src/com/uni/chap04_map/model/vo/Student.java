package com.uni.chap04_map.model.vo;

public class Student {
	private int stdId; // 학번
	private String stdName;  //학생명
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public Student(int stdId, String stdName) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
	}


	public int getStdId() {
		return stdId;
	}


	public void setStdId(int stdId) {
		this.stdId = stdId;
	}


	public String getStdName() {
		return stdName;
	}


	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student stdId = " +stdId+"  stdName = "+ stdName;
	}

}
