package com.uni.chap01_list.part02_list.model.vo;

public class Music {
	private String title;
	private String artist;
	
	public Music() {
		// TODO Auto-generated constructor stub
	}

	public Music(String title, String artist) {
		super();
		this.title = title;
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Music [ title = " + title + ", artist = "+ artist + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (title+artist).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!( obj instanceof Music )) {
			return false;
		}
		Music other = (Music)obj;
		if(this.title.equals(other.title)&&this.artist.equals(other.artist)) {
			return true;
		}else {
			return false;
		}
	}

	
}
