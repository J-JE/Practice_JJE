package com.uni.chap02_listsort.model.comparator;

import java.util.Comparator;

import com.uni.chap02_listsort.model.vo.Travel;

public class DescTravelNum implements Comparator<Travel> {

	@Override
	public int compare(Travel o1, Travel o2) {
		return -(o1.gettNum()-o2.gettNum());
//		return o2.gettNum()- o1.gettNum();
	}


}
