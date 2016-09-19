package com.thmoon.duitang.entity;

public class TopItem {

	private int imageSource;
	private String title;
	private String time;
	
	public TopItem(int imageSource,String title,String time) {
		this.imageSource = imageSource;
		this.title = title;
		this.time = time;
	}
	
	public int getImageSource() {
		return imageSource;
	}
	public void setImageSource(int imageSource) {
		this.imageSource = imageSource;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
