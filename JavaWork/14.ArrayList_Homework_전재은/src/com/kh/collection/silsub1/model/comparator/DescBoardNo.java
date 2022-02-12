package com.kh.collection.silsub1.model.comparator;

import java.util.Comparator;

import com.kh.collection.silsub1.model.vo.Board;

public class DescBoardNo implements Comparator{
public DescBoardNo() {}
	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Board && o2 instanceof Board) {
			Board b1 = (Board) o1;
			Board b2 = (Board) o2;

			return b2.getBoardNo()-b1.getBoardNo();
		}
		return 0;
	}

}
