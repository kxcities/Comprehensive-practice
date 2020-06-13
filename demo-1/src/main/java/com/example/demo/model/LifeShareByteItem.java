package com.example.demo.model;

import java.sql.Timestamp;

import com.example.demo.tool.PicTool;

public class LifeShareByteItem {
	byte[] picture;
	String userName;
	String text;
	Timestamp time;
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public LifeShareItem transferToStrItem() {
		LifeShareItem item = new LifeShareItem();
		item.setPicture(PicTool.base64Encode(picture));
		item.setUserName(userName);
		item.setTime(time);
		item.setText(text);
		return item;
	}
}
