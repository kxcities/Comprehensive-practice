package com.example.demo;

import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.CommentItem;
import com.example.demo.service.CommentService;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {
	@Resource
	CommentService commentService;
	
	@Test
	public void TestDemo1() {
		String goodsId = "1";
		String commentName = "A";
		String commentText = "sss";
		String result = commentService.commentUpload(goodsId, commentName, commentText);
		Assert.assertThat(result, is("success"));
	}
	@Test
	public void TestDemo2() throws Exception {
		String goodsId = "0";
		CommentItem item = new CommentItem();
		item.setCommentId("d3d829f4e62b474eaeb3be082eb5ba16");
		List<CommentItem> items = new ArrayList<CommentItem>();
		items.add(item);
		List<CommentItem> comments =  commentService.commentDownload(goodsId, 1);
		Assert.assertThat(comments, is(items));
	}
	@Test
	public void TestDemo3() {
		String commentId = "d3d829f4e62b474eaeb3be082eb5ba16";
		String replyName = "A";
		String replyWord = "ssss";
		String result = commentService.commentReplyUpload(commentId, replyName, replyWord);
		Assert.assertThat(result, is("success"));		
	}
}
