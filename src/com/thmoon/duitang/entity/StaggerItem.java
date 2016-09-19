package com.thmoon.duitang.entity;

public class StaggerItem {

	private int imageSource;
	private String description;
	private int collectNum;
	private int thumImage;
	private String userName;
	private String collectPlace;
	
	public StaggerItem() {
	}

	public StaggerItem(int imageSource, String description, int collectNum,
			int thumImage, String userName, String collectPlace) {
		super();
		this.imageSource = imageSource;
		this.description = description;
		this.collectNum = collectNum;
		this.thumImage = thumImage;
		this.userName = userName;
		this.collectPlace = collectPlace;
	}

	public int getImageSource() {
		return imageSource;
	}

	public void setImageSource(int imageSource) {
		this.imageSource = imageSource;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCollectNum() {
		return collectNum;
	}

	public void setCollectNum(int collectNum) {
		this.collectNum = collectNum;
	}

	public int getThumImage() {
		return thumImage;
	}

	public void setThumImage(int thumImage) {
		this.thumImage = thumImage;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCollectPlace() {
		return collectPlace;
	}

	public void setCollectPlace(String collectPlace) {
		this.collectPlace = collectPlace;
	}
	
	
}
