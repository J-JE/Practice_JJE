package com.hw1.model.vo;

public class Employee extends Person{
	
	private int salary;
	private String dept;
	
	public Employee() { }

	public Employee(String name, int age, double height, double weight, int salary, String dept) {
		super(age, height, weight);
//		super.age =age; //private 멤버라 불가능
		super.name=name;//name 값은 부모 필드 값에 직접 접근해서 초기화, protected 멤버라 가능
		this.salary=salary;
		this.dept=dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String information() {
		return "급여=" + salary + ", 부서=" + dept + super.information(); //super.까먹지 말기
	}

}
