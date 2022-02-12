package com.kh.collection.silsub1.model.comparator;

import java.util.Comparator;

import com.kh.collection.silsub1.model.vo.Board;

public class DescBoardDate implements Comparator{
public DescBoardDate() {}
	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Board && o2 instanceof Board) {
			Board b1 = (Board) o1;
			Board b2 = (Board) o2;

			return b2.getBoardDate().compareTo(b1.getBoardDate());

		}
		return 0;
	}

}
