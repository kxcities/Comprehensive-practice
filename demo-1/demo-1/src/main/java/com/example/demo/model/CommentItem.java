package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;

public class CommentItem {
	String commentId;
	String goodsId;
	String commentName;
	String commentWord;
	public String getCommentWord() {
		return commentWord;
	}
	public void setCommentWord(String commentWord) {
		this.commentWord = commentWord;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getCommentName() {
		return commentName;
	}
	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}
	public List<ReplyItem> getReplies() {
		return replies;
	}
	public void setReplies(List<ReplyItem> replies) {
		this.replies = replies;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	List<ReplyItem> replies;
	Timestamp createTime;
}
