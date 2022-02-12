package com.uni.chap02_listsort.model.comparator;

import java.util.Comparator;

import com.uni.chap02_listsort.model.vo.Travel;

public class AscCountry implements Comparator<Travel> {

	@Override
	public int compare(Travel o1, Travel o2) {
		return o1.getCountry().compareTo(o2.getCountry());
	}
}
