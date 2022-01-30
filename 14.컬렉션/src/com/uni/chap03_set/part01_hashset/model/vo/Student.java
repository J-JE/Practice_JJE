package com.uni.chap03_set.part01_hashset.model.vo;

public class Student {
	private int stdId; // 학번
	private String stdName;  //학생명
	
	
	public Student() {	}


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
		return "Student stdId = " +stdId+"  stdName = "+ stdName;
	}

	@Override
	public int hashCode() {
		final int prime = 31; //prime은 소수이면서 ?뭐더라
		int result =1;
		result = prime*result+stdId;
		result = prime*result+((stdName ==null)? 0 : stdName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		Student other = (Student)obj;
		if(stdId != other.stdId) {
			return false;
		}
		if(stdName ==null) {
			if(other.stdName!=null) {
				return false;
			}
		}else if(!stdName.equals(other.stdName)) {
			return false;
		}
		return true;
	}
}