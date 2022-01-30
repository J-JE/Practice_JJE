package com.kh.collection.silsub1.model.comparator;

import java.util.Comparator;

import com.kh.collection.silsub1.model.vo.Board;

public class AscBoardNo implements Comparator{
	public AscBoardNo() {}
	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Board && o2 instanceof Board) {
			Board b1 = (Board) o1;
			Board b2 = (Board) o2;
			
			return b1.getBoardNo()-b2.getBoardNo();
		}
		return 0;
	}

}
