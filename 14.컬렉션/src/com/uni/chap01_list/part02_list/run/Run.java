package com.uni.chap01_list.part02_list.run;

import java.util.ArrayList;
import java.util.List;

import com.uni.chap01_list.part02_list.model.vo.Music;

public class Run {

	public static void main(String[] args) {
		
		//E -> Element : 리스트에 담길 요소 (객체)
		ArrayList<Music> list = new ArrayList<Music>();
		
		//1.add(E e) : 리스트의 끝에 인스턴스 데이터를 추가하는 메소드 (내부적으로 사이즈 검사한후 수용가능한 범위이면 추가되 넘어가도 알아서 사이즈 늘려준다음 추가함)
		list.add(new Music ("Good bye","박효신"));
		list.add(new Music ("가을아침","아이유"));
		list.add(new Music ("달링","양다일"));
		
		//list.add("R","sdf");
		
		System.out.println(list.toString());
		
		//2.add(int index, E e) : 인덱스를 지정해서 해당인덱스에 인스턴스 추가하는 메소드 (내부적으로 기존에 있는것은 뒤로 땡기고  해당인덱스에 값추가)
		list.add(1, new Music("연인","박효신"));
		System.out.println(list);
		
		//3.set(int index, E e) : 해당하는 인덱스의 값을 E로 변경
		list.set(0, new Music("엔젤베이비","트로이시반"));
		System.out.println(list);
		
		System.out.println(list.size());
		
//		list.remove(1);
		list.remove(new Music("엔젤베이비","트로이시반"));
		
		System.out.println(list);
		System.out.println(list.size());
		
		System.out.println(list.get(0));
		System.out.println(list.get(0).getTitle());
		
		//subList(int index1, int index2) : index1에서 index2 앞까지 추출해서 새로운 list 를 반환
		List sub = list.subList(0, 2);
		System.out.println(sub);
		
		//addAll(Collextion C) : 컬렉션을 통채로 뒤에 추가하는 메소드
		list.addAll(sub);
		System.out.println(list);
		System.out.println(list.size());
		
		System.out.println(list.isEmpty());
		
//		list.clear();
		System.out.println(list.isEmpty());
		
		for(Object o : list ) {
			System.out.println(o);
		}
	}

}
