package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CommentItem;
import com.example.demo.service.CommentService;
import com.google.common.collect.ImmutableMap;
@RestController
public class CommentController extends BaseController {
	@Resource
	CommentService commentService;
	@PostMapping("home/goods/commentUpload")
	public String commentUpload(HttpSession session, @RequestBody Map<String, String >inputParam) {
		String goodsId = inputParam.get("id");
		String commentWord = inputParam.get("word");
		String commentName = inputParam.get("name");
		Map<String,Object> jsonMap = null;
		String result = commentService.commentUpload(goodsId, commentName, commentWord);
		jsonMap = ImmutableMap.of("result", result);
		return passRespond(jsonMap);
	}
	@PostMapping("home/goods/commentDownload")
	public String commentDownload(HttpSession session, @RequestBody Map<String,String> inputParam) {
		Map<String,Object> jsonMap = null;
		try {
			Integer curPage = Integer.parseInt(inputParam.get("curPage"));
			String goodsId = inputParam.get("id");
			List<CommentItem> items = commentService.commentDownload(goodsId,curPage);
			jsonMap = ImmutableMap.of("items", items);
			return passRespond(jsonMap);
		}catch(Exception e) {
			e.printStackTrace();
			return errorRespond();
		}
	}
	@PostMapping("home/goods/comentReplyUpload")
	public String commentReplyUpload(HttpSession session, @RequestBody Map<String, String> inputParam) {
		Map<String,Object> jsonMap = null;
		String commentId = inputParam.get("id");
		String replyName = inputParam.get("name");
		String replyWord = inputParam.get("word");
		String result = commentService.commentReplyUpload(commentId, replyName, replyWord);
		jsonMap = ImmutableMap.of("result", result);
		return passRespond(jsonMap);
	}
}
