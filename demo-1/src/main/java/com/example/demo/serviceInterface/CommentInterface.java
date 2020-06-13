package com.example.demo.serviceInterface;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.CommentItem;
import com.example.demo.model.ReplyItem;

@Mapper
public interface CommentInterface {
	void commentUpload(String commentId, String goodsId, String commentName, String commentWord)throws Exception;
	List<CommentItem> commentDownload(String goodsId, int pageStart, int pageSize) throws Exception;
	void replyUpload(String commentId, String replyName, String replyWord) throws Exception;
	List<ReplyItem> replyFindById(String commentId) throws Exception;
	void commentReplyUpload(String commentId, String replyName, String replyWord) throws Exception;
}
