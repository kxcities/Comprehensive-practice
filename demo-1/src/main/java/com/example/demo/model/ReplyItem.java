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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentId == null) ? 0 : commentId.hashCode());
		result = prime * result + ((replyName == null) ? 0 : replyName.hashCode());
		result = prime * result + ((replyWord == null) ? 0 : replyWord.hashCode());
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
		ReplyItem other = (ReplyItem) obj;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		if (replyName == null) {
			if (other.replyName != null)
				return false;
		} else if (!replyName.equals(other.replyName))
			return false;
		if (replyWord == null) {
			if (other.replyWord != null)
				return false;
		} else if (!replyWord.equals(other.replyWord))
			return false;
		return true;
	}
}
