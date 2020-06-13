package com.example.demo.model;

public class BookInfoItem {
	String title;
	String author;
	String publisher;
	String storedDetail;
	String availDetail;
	String detailLink;
	public String getStoredDetail() {
		return storedDetail;
	}
	public void setStoredDetail(String storedDetail) {
		this.storedDetail = storedDetail;
	}
	public String getAvailDetail() {
		return availDetail;
	}
	public void setAvailDetail(String availDetail) {
		this.availDetail = availDetail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDetailLink() {
		return detailLink;
	}
	public void setDetailLink(String detailLink) {
		this.detailLink = detailLink;
	}
}
