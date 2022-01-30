package com.kh2.collection.silsub1.model.dao;

import java.util.ArrayList;

import com.kh2.collection.silsub1.model.vo.Board;

public class BoardDao {
	private ArrayList<Board> list = new ArrayList<Board>();
	
	public BoardDao() {	
		
	}
	
	public int getLastBoardNo() {
		
		return 0;
	}
	
	public void writeBoard(Board board) {
		
	}
	
	public ArrayList<Board> displayAllList() {
		
		return list;}
	
	public Board displayBoard() {
		
		return null;
	}
	
	public void upReadCount(int no) {
		
	} 
	
	public void modifyTitle(int no, String title) {
		
	}
	
	public void modifyContent(int no, String content) {
		
	}
	
	public void deleteBoard(int no) {
		
	}
	
	public ArrayList<Board> searchBoard(String title) {
		
		return list;
	}
	
	public void saveListFile() {
		
	}
	
	
}
