package com.example.demo;

import static org.hamcrest.CoreMatchers.is;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.DealItem;
import com.example.demo.model.GoodsDetailByteItem;
import com.example.demo.model.GoodsListItem;
import com.example.demo.service.TradeService;
import com.example.demo.tool.IdGeneratorTool;
import com.example.demo.tool.PicTool;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeServiceTest {
	@Resource
	TradeService tradeService;
	List<GoodsDetailByteItem> items;
	List<GoodsListItem> listItems;
	List<DealItem> deals;
	@Before
	public void setUp() throws Exception {
		String pic = PicTool.readToString("goods_p2.txt");
		String icoPic = PicTool.readToString("ico_p2.txt");
		items = new ArrayList<GoodsDetailByteItem>();
		listItems = new ArrayList<GoodsListItem>();
		GoodsDetailByteItem item1 = new GoodsDetailByteItem();
		item1.setOriPicture(PicTool.base64Decode(pic));
		item1.setIcoPicture(PicTool.base64Decode(icoPic));
		item1.setArea("西区");
		item1.setGoodsId(IdGeneratorTool.goodsIdGenerate());
		item1.setOwnerName("A");
		item1.setTag("工具");
		item1.setDetailText("可以锤");
		item1.setExpectedPrice(10);
		item1.setGoodsTitle("锤子");
		items.add(item1);
		GoodsListItem listitem1 = new GoodsListItem();
		listitem1.setIcoPicture(icoPic);
		listitem1.setGoodsTitle(item1.getGoodsTitle());
		listitem1.setOwnerName(item1.getOwnerName());
		listitem1.setTag(item1.getTag());
		listItems.add(listitem1);
		deals = new ArrayList<DealItem>();
		String buyer = "B";
		String dealPlace = "xxxxx";
		Timestamp dealTime = Timestamp.valueOf("2020-3-3 19:22:00");
		DealItem deal = new DealItem();
		deal.setBuyer(buyer);
		deal.setDealPlace(dealPlace);
		deal.setDealTime(dealTime);
		deal.setDealId(IdGeneratorTool.goodsIdGenerate());
		deal.setGoods(tradeService.findGoodsListById("0").transferToStrItem());
		deals.add(deal);
	}
	@Test
	public void TestDemo1() {
		String result = tradeService.goodsRealse(items.get(0));
		Assert.assertThat(result, is("success"));
	}
	@Test
	public void TestDemo2() throws Exception {
		List<GoodsListItem> goods = tradeService.goodsTitleSearch("锤",1);
		Assert.assertEquals(goods, listItems);
	}
	@Test
	public void TestDemo3() throws Exception {
		List<GoodsListItem> expect =  new ArrayList<GoodsListItem>();
		expect.add(listItems.get(0));
		List<GoodsListItem> goods = tradeService.goodsTagSearch("工具", 1);
		Assert.assertThat(goods, is(listItems));
	}
	@Test
	public void TestDemo4() throws Exception{
		List<GoodsListItem> goods = tradeService.goodsAreaSearch("西区", 1);
		Assert.assertThat(goods, is(listItems));
	}
	@Test
	public void  TestDemo5() throws Exception{
		List<GoodsListItem> goods = tradeService.goodsPriceSearch(1, 15, 1);
		Assert.assertThat(goods, is(listItems));
	}
	@Test
	public void  TestDemo6() throws Exception{
		DealItem deal = deals.get(0);
		String result = tradeService.generateDeal(deal.getDealId(),deal.getBuyer(),deal.getGoods().getGoodsId(),deal.getDealTime(),deal.getDealPlace());
		Assert.assertThat(result, is("success"));
	}
	@Test
	public void TestDemo7() throws Exception{	
		List<DealItem> dealitems = tradeService.runningDeal("B", 1);
		Assert.assertThat(dealitems, is(deals));
	}
	@Test
	public void TestDemo8()throws Exception{
		String result = tradeService.dealFinish(deals.get(0).getDealId());
		Assert.assertThat(result, is("success"));
	}
	@Test
	public void TestDemo9() throws Exception{
		List<DealItem> dealsitems = tradeService.finishedDeal("B", 1);
		deals.clear();
		Assert.assertThat(dealsitems,is(deals));
	}
	
}
