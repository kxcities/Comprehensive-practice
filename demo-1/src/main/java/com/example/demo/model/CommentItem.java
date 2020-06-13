package com.example.demo.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CommentItem {
	String commentId;
	String goodsId;
	String commentName;
	String commentWord;
	public CommentItem() {
		replies = new ArrayList<ReplyItem>();
	}
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentId == null) ? 0 : commentId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentItem other = (CommentItem) obj;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		return true;
	}

	List<ReplyItem> replies;
	Timestamp createTime;
}
