package com.example.demo.model;

import java.sql.Timestamp;

public class ReplyItem {
	String commentId;
	String replyName;
	Timestamp replyTime;
	String replyWord;
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getReplyName() {
		return replyName;
	}
	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}
	public Timestamp getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}
	public String getReplyWord() {
		return replyWord;
	}
	public void setReplyWord(String replyWord) {
		this.replyWord = replyWord;
	}
}
