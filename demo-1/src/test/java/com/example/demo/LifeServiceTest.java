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

import com.example.demo.model.LifeShareByteItem;
import com.example.demo.model.LifeShareItem;
import com.example.demo.service.LifeService;
import com.example.demo.tool.PicTool;
@RunWith(SpringRunner.class)
@SpringBootTest
public class LifeServiceTest {
	@Resource
	private LifeService lifeService;
	private List<LifeShareItem> items;
	@Before
	public void setUp() {
		String pic1 = PicTool.readToString("life_p1.txt");
		String pic2 = PicTool.readToString("life_p2.txt");
		LifeShareItem item1 = new LifeShareItem();
		LifeShareItem item2 = new LifeShareItem();
		item1.setPicture(pic1);
		item1.setUserName("A");
		item1.setText("阳光真好");
		item2.setPicture(pic2);
		item2.setUserName("B");
		item2.setText("周树人");
		items = new ArrayList<LifeShareItem>();
		items.add(item2);
		items.add(item1);
	}
	@Test
	public void lifeShareUploadTest() throws Exception{
		LifeShareByteItem item = new LifeShareByteItem();
		String str = PicTool.readToString("life_p1.txt");
		item.setPicture(PicTool.base64Decode(str));
		item.setUserName("A");
		item.setText("阳光真好");
		String result = lifeService.LifeShareUpload(item);
		Assert.assertThat(result, is("success"));
	}
	@Test
	public void lifeDownloadTest() throws Exception{
		Thread.sleep(5000);
		LifeShareByteItem item = new LifeShareByteItem();
		String str = PicTool.readToString("life_p2.txt");
		item.setPicture(PicTool.base64Decode(str));
		item.setUserName("B");
		item.setText("周树人");
		lifeService.LifeShareUpload(item);
		List<LifeShareItem>  life = lifeService.LifeShareDownload(1);
		Assert.assertEquals(life, items);
	}
	
}
