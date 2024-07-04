package com.example.C104JavaExam;


public class Board {
	
	private String title;
	private String content;
	
	
	//constructor
	public Board() {
		this.title = "";
		this.content = "";
	}
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	//getter setter method
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

	
}
