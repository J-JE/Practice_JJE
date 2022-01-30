package com.uni.chap02_listsort.model.comparator;

import java.util.Comparator;

import com.uni.chap02_listsort.model.vo.Travel;

public class AscTravelNum implements Comparator<Travel>{

	@Override
	public int compare(Travel o1, Travel o2) {
		//10 이 100보다 크냐 10-100 하면 - 니까  
		//뺀값이 - 면 앞이 작다   +면  앞이크다 이렇게 해서 자리를 바꿔줌기준만잡아주면 정렬을 해준다.
		
		/*	
		 *  1 - 3 = -2 >0  false  1 3 2 5 4
			1 - 2 = -1 >0  false  1 3 2 5 4	
			..
			3 - 2 =  1 > 0 true   1 2 3 5 4 
			3 - 5 = -2 > 0 false  1 2 3 4 5 
			..
			5 - 4 =  1 > 0 true  1 2 3 4 5 
		*/

		return o1.gettNum()-o2.gettNum();
	}

}
