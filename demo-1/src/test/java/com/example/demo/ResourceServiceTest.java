package com.example.demo;

import static org.hamcrest.CoreMatchers.is;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.BookInfoItem;
import com.example.demo.service.ResourceService;
import com.sun.tools.javac.util.Pair;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceServiceTest {
	@Autowired
	ResourceService resourceService;
	@Test
	public void testDemo1() throws ClientProtocolException, IOException {
		Pair<List<BookInfoItem>,Integer> item = resourceService.bookSearch(URLEncoder.encode("三体","UTF-8"), null);
		Assert.assertThat(8, is(item.fst.size()));
		Assert.assertThat(8, is(item.snd));
	}
	
}
