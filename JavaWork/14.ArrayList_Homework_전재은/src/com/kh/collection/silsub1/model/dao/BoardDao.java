package com.kh.collection.silsub1.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.collection.silsub1.model.vo.Board;

public class BoardDao {
	
	ArrayList<Board> list = new ArrayList<Board>();
	
	public BoardDao() {	//기본생성자
						//board_list.dat 파일의 내용을읽어서 list에 저장함null 될 때까지 저장함
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("board_list.dat"))){
			while(true) { list.add((Board)(ois.readObject())); }
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getLastBoardNo() {//게시글의 마지막 번호 리턴
		return list.get(list.size()-1).getBoardNo();
	}
	
	
	public void writeBoard(Board board) {//전달받은 게시글을 list에 추가
		list.add(board);
	}
	
	
	public ArrayList<Board> displayAllList() {//게시글 전체 list를 리턴
		return list;
	}
	
	
	public Board displayBoard(int no) {//전달받은 글 번호와 일치하는게시글 리턴
		Board board = null;
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).getBoardNo() == no) {	
				board = list.get(i);
				break;
			}
		}
		return board;
	}
	
	
	public void upReadCount(int no) {//전달받은 글 번호와 일치하는 게시글의 조회수 1 올려주기
		for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i).getBoardNo() == no) {
				list.get(i).setReadCount(list.get(i).getReadCount() + 1);
				break;
			}
		}
	}
	
	
	public void modifyTitle(int no, String title) {//전달받은 글 번호와 일치하는 게시글의 제목을 수정하기
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBoardNo() == no) {
				list.get(i).setBoardTitle(title);
				break;
			}
		}
	}
	
	
	public void modifyContent(int no, String content) {//전달받은 글 번호와 일치하는 게시글 내용 수정
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBoardNo() == no) {
				list.get(i).setBoardContent(content);
				break;
			}
		}
	}
	
	
	public void deleteBoard(int no) {//전달받은 글 번호와 일치하는 게시글 삭제
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBoardNo() == no) {
				list.remove(i);
				break;
			}
		}
	}
	
	public ArrayList<Board> searchBoard(String title){//전달받은 제목이 포함되어있는 게시글들 list 리턴
		ArrayList<Board> searchList = new ArrayList<Board>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBoardTitle().contains(title)) {//포함된 -> contains
				searchList.add(list.get(i));
				list.get(i).setReadCount(list.get(i).getReadCount() + 1);//조회수 +1
			}
		}
		return searchList;
	}
	
	
	public void saveListFile() {//board_list.dat 파일 저장하기
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("board_list.dat"))){
			System.out.println(list);
			oos.writeObject(list);
						
			System.out.println("board_list.dat에 성공적으로 저장되었습니다.");
			
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}


