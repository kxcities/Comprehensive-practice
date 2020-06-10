package com.example.demo.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.model.DealByteItem;
import com.example.demo.model.DealItem;
import com.example.demo.model.GoodsDetailByteItem;
import com.example.demo.model.GoodsDetailItem;
import com.example.demo.model.GoodsListByteItem;
import com.example.demo.model.GoodsListItem;
import com.example.demo.serviceInterface.TradeInterface;
import com.example.demo.tool.IdGeneratorTool;
@Service
public class TradeService {
	@Resource
	TradeInterface tradeInterface;
	public String goodsRealse(GoodsDetailByteItem item){
		try {
			tradeInterface.goodsRealse(item);
		}catch(Exception ex) {
			return "fail";
		}
		return "success";
	}
	public List<GoodsListItem> goodsTitleSearch(String keyTitle, Integer curPage) throws Exception {
		String searchWord ='%' + keyTitle + '%';
		List<GoodsListByteItem> byteItems = tradeInterface.goodsTitleSearch(searchWord,(curPage - 1) * PAGE_NUM, PAGE_NUM);
		List<GoodsListItem> items = new ArrayList<GoodsListItem>();
		for(GoodsListByteItem byteItem : byteItems) {
			items.add(byteItem.transferToStrItem());
		}
		return items;
	}
	public GoodsDetailItem findGoodsDetailById(String goodsId) throws Exception {
		return tradeInterface.findGoodsDetailById(goodsId).tranferToStrItem();
	}
	public List<GoodsListItem> goodsTagSearch(String tag, int curPage) throws Exception{
		String searchTag  = "%" + tag + "%";
		List<GoodsListByteItem> byteItems = tradeInterface.goodsTagSearch(searchTag, (curPage - 1) * PAGE_NUM, PAGE_NUM);
		List<GoodsListItem> items = new ArrayList<GoodsListItem>();
		for(GoodsListByteItem byteItem : byteItems) {
			items.add(byteItem.transferToStrItem());
		}
		return items;
	}
	public List<GoodsListItem> goodsAreaSearch(String area, int curPage) throws Exception{
		String searchArea = "%" + area + "%";
		List<GoodsListByteItem> byteItems = tradeInterface.goodsAreaSearch(searchArea, (curPage - 1) * PAGE_NUM, PAGE_NUM);
		List<GoodsListItem> items = new ArrayList<GoodsListItem>();
		for(GoodsListByteItem byteItem : byteItems) {
			items.add(byteItem.transferToStrItem());
		}
		return items;
	}
	public List<GoodsListItem> goodsPriceSearch(Integer minPrice, Integer maxPrice, int curPage) throws Exception{
		List<GoodsListByteItem> byteItems = tradeInterface.goodsPriceSearch(minPrice, maxPrice, (curPage - 1) * PAGE_NUM, PAGE_NUM);
		List<GoodsListItem> items = new ArrayList<GoodsListItem>();
		for(GoodsListByteItem byteItem : byteItems) {
			items.add(byteItem.transferToStrItem());
		}
		return items;
	}
	public GoodsListByteItem findGoodsListById(String goodsId) throws Exception {
		return tradeInterface.findGoodsListById(goodsId);
	}
	public String generateDeal(String buyer, String goodsId, Timestamp dealTime, String dealPlace) throws Exception {
			Integer state = 0;
			tradeInterface.generateDeal(IdGeneratorTool.dealIdGenerate(),buyer, goodsId,dealTime,dealPlace,state);
			if(state == 0) {
				return "success";
			}
			else {
				return "fail";
			}
	}
	public List<DealItem> runningDeal(String buyerName, int curPage) throws Exception {
		List<DealByteItem> byteItems = tradeInterface.runningDeal(buyerName,(curPage - 1) * PAGE_NUM, PAGE_NUM);
		List<DealItem> items = new ArrayList<DealItem>();
		for(DealByteItem byteItem : byteItems) {
			items.add(byteItem.transferToStrItem());
		}
		return items;
	}
	public List<DealItem> finishedDeal(String buyerName, int curPage) throws Exception {
		List<DealByteItem> byteItems = tradeInterface.finishedDeal(buyerName,(curPage - 1) * PAGE_NUM, PAGE_NUM);
		List<DealItem> items = new ArrayList<DealItem>();
		for(DealByteItem byteItem : byteItems) {
			items.add(byteItem.transferToStrItem());
		}
		return items;
	}
	public String dealFinish(String dealId) {
		try {
			tradeInterface.dealFinish(dealId);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}
	static int PAGE_NUM = 10;
}
