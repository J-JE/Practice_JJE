package com.uni.chap03_set.part02_treeset.run;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import com.uni.chap03_set.part02_treeset.model.vo.Student;

public class Run {

	public static void main(String[] args) {
	
		TreeSet <String> ts = new TreeSet<>();
		ts.add(new String ("하하하"));
		ts.add(new String ("나나나"));
		ts.add(new String ("가가가"));
		ts.add(new String ("다다다"));
		ts.add(new String ("하하하"));
		
		System.out.println(ts);
		System.out.println(ts.size());
		
		
		TreeSet <Student> ts2 = new TreeSet<>();
		ts2.add(new Student("공유", 30, 100));
		ts2.add(new Student("이효리", 20, 90));
		ts2.add(new Student("유재석", 40, 60));
		ts2.add(new Student("공유", 10, 100));
		//add할때 애초에 어떤 정렬 기준을 가지고 담을지 제시하지 않게 되면 ClassCastException 발생
		//TreeSet은 Hashcode()나 equals()로 중복판단을 하지않고
		//compareTo()에 제시한 정렬필드가 같은 경우 동일 객체로 판단
		System.out.println(ts2);
		System.out.println(ts2.size());
		
		//1. for each
		System.out.println("=======");
		for(Student s : ts2) {
			System.out.println(s);
		}
		
		//2. ArrayList
		System.out.println("=======");
		ArrayList<Student> list = new ArrayList<>(ts2);
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//3. Iterator
		System.out.println("=======");
		Iterator it2 = ts2.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
	}
}
