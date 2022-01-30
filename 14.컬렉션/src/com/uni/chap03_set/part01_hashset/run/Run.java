package com.uni.chap03_set.part01_hashset.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import com.uni.chap03_set.part01_hashset.model.vo.Student;

public class Run {

	public static void main(String[] args) {
		/*
		 * 1. Hash (hash알고리즘 도입) :
		 * 		데이터의 검색 성능 향상을 위해서 사용
		 * 		(hashCode와 equals를 모두 오버라이딩 해야한다.)
		 * 
		 * 2. Set
		 * 		- 순서유지 안됨, 중복 저장이 되지 않는다.(수학에서의 집합 개념)
		 * 		- 종류로는 HashSet, LinkedHashSet, TreeSet이 있다.
		 *      
		 * 3. HashSet
		 * 		- 순서가 존재하지 않는다.
		 * 		- hashCode()와 equals()가 오버라이딩 되어 있어야 한다.
		 * 
		 * 4. LinkedHashSet
		 * 		- 넣는 순서가 유지 된다.
		 * 		(hashCode와 equals를 모두 오버라이딩 해야한다.)
		 * 
		 * 5. TreeSet
		 * 		- 정렬기준대로 순서가 정해짐(기본 오름차순)
		 * 		- hashCode()와 equals()를 오버라이딩 할 필요 없이 알아서 중복저장 되지 않는다.
		 * 		- 세팅은 해 주어야 됨(Comparable이나 Comparator 구현 클래스)
		 * 
		 * 
		 */
//		Collection hs = new HashSet(); //부모로도 받을 수 있다.(다형성 적용)
//		Set hs = new HashSet();
		HashSet<String> hs =new HashSet();
		
		hs.add("반갑습니다");
		hs.add(new String ("반갑습니다"));
		hs.add(new String ("여러분"));
		hs.add(new String ("안녕하세요"));
		hs.add(new String ("여러분"));
		hs.add("1");
		hs.add(null);
		hs.add(null);
		
		System.out.println(); //저장 순서 유지 안됨(추가한 순서대로 출력안됨), 중복제거됨(해시셋은 이퀄스와 해시코드가 오버라이딩되어있어서 중복이 허가안됨)
		System.out.println(hs.size());
		System.out.println(hs.contains("여러분"));
		
		
//		System.out.println(hs.isEmpty());
//		hs.clear();
		System.out.println(hs.isEmpty());
		
		Iterator it = hs.iterator();
		while(it.hasNext()) {//다음 요소가 있을 때 까지
			System.out.println(it.next());
		}
		
		HashSet<Student> hs2 = new HashSet(); //인덱스가 없어서 어레이리스트나 다른 방법을 써봐야함
		hs2.add(new Student (1 , "공유"));
		hs2.add(new Student (2 , "로운"));
		hs2.add(new Student (3 , "공명"));
		hs2.add(new Student (4 , "공유"));
		hs2.add(new Student (3 , "공명"));
		hs2.add(new Student (4 , "공유"));
		
		System.out.println(hs2);
		System.out.println(hs2.size());
		
		//1. for each
//		System.out.println("=======");
//		for(Student s : hs2) {
//			System.out.println(s);
//		}
		
		/*
		//2. Iterator
		System.out.println("=======");
		Iterator it2 = hs2.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		*/
		
		//3. ArrayList
		
		System.out.println("=======");
		ArrayList<Student> arrS = new ArrayList<>();
		for(Student s : hs2) {
			arrS.add(s);
		}
		for(Student s : arrS) {
			System.out.println(s);
		}

		System.out.println("=======");
		ArrayList<Student> list = new ArrayList<>(hs2);
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		 
	}
	
	
	
	
	
}
