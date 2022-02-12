package com.uni.part02.personMVC.controller;

import com.uni.part02.personMVC.model.vo.Person;

public class PersonController {
	private Person[] people =new Person[3]; //3명의 정보를 담을것
	
	private int count =0; //현재 추가된 사람 수를 나타낼 변수
	
	public boolean insertPerson(String name, int age, int wealth) { //반환값과 일치 시키기
		if(count <people.length) {
			people[count++]=new Person(name, age, wealth);
			return true;
		}else {
			return false;
		}
		
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	public Person[] getPeople() {
		// TODO Auto-generated method stub
		return people;
	}

	public Person serchPerson(String search) {
		
		for(int i=0; i<count;i++) {
			if(people[i].getName().equals(search)) {
				return people[i];
			}
		}
		return null;
	}

	public String getWealth() {
		int sum =0;
		for(int i= 0; i<count;i++) {
			sum+=people[i].getWealth();
		}
		
		double avg = (double)sum/count;
		
		String avg1 =String.format("%.3f", avg);
		String avg2 =String.format("%.2f", avg);
		
		return String.valueOf(avg) + "  %.3f : " + avg1 + "  %.2f : "+avg2;
	}


}
