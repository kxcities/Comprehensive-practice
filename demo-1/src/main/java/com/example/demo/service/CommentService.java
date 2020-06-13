package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.example.demo.model.CommentItem;
import com.example.demo.serviceInterface.CommentInterface;
import com.example.demo.tool.IdGeneratorTool;

@Service
public class CommentService {
	@Resource
	CommentInterface commentInterface;
	public String  commentUpload(String goodsId, String commentName, String commentWord) {
		try {
			commentInterface.commentUpload(IdGeneratorTool.commentIdGenerate(), goodsId, commentName, commentWord);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}
	public List<CommentItem> commentDownload(String goodsId, int curPage) throws Exception{
		return commentInterface.commentDownload(goodsId,  (curPage - 1) * PAGE_NUM, PAGE_NUM);
	}
	public String commentReplyUpload(String commentId, String replyName, String replyWord) {
		try {
			commentInterface.commentReplyUpload(commentId, replyName, replyWord);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}
	static int PAGE_NUM = 10;
}
