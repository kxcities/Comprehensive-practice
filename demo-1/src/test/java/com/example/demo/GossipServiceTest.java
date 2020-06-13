package com.example.demo;

import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.GossipService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GossipServiceTest {
	@Resource
	private GossipService gossipService;
	@Before
	public void setUp() {
		
	}
	@Test
	public void gossipUploadTest()throws Exception {
		String gossipBlock = "block";
		String gossipText = "text";
		String result = gossipService.gossipUpload(gossipBlock, gossipText);
		Assert.assertThat(result, is("success"));
	}
	@Test
	public void gossipBlockSearchTest()throws  Exception{
		String searchBlock = "block";
		List<String> target  = new ArrayList<String>();
		target.add("text");
		target.add("text");
		target.add("text");
		target.add("text");
		List<String> gossips = gossipService.gossipBlockSearch(searchBlock, 1);
		Assert.assertThat(gossips, is(target));
	}
	@Test
	public void gossipStatusSearchTest()throws Exception{
		List<String> target  = new ArrayList<String>();
		target.add("text");
		List<String> gossips = gossipService.gossipStatusSearch(-1, 1);
		Assert.assertThat(gossips, is(target));
	}
	@Test
	public void gossipUpdateStatusTest()throws Exception{
		String result = gossipService.gossipUpdateStatus("text", 0);
		Assert.assertThat(result, is("success"));
	}
}
