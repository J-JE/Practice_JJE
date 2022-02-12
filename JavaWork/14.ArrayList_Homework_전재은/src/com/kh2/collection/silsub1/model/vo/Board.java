package com.kh2.collection.silsub1.model.vo;

import java.util.Date;

public class Board {
	private int boardNo; // 게시글 번호
	private String boardTitle; // 게시글 제목
	private String boardWrtier; // 작성자
	private Date boardDate; // 작성 날짜
	private String boardContent; // 게시글 내용
	private int readCount; // 조회수
	
	public Board() { }

	public Board(int boardNo, String boardTitle, String boardWrtier, Date boardDate, String boardContent, int readCount) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWrtier = boardWrtier;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
		this.readCount = readCount;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWrtier() {
		return boardWrtier;
	}

	public void setBoardWrtier(String boardWrtier) {
		this.boardWrtier = boardWrtier;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardWrtier=" + boardWrtier
				+ ", boardDate=" + boardDate + ", boardContent=" + boardContent + ", readCount=" + readCount + "]";
	}
	
}
