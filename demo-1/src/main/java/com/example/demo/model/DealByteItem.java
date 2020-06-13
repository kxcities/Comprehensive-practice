package com.example.demo.model;

import java.sql.Timestamp;


public class DealByteItem {
	String dealId;
	String buyer;
	GoodsListByteItem goods;
	String dealPlace;
	Timestamp dealTime;
	public Timestamp getDealTime() {
		return dealTime;
	}
	public void setDealTime(Timestamp dealTime) {
		this.dealTime = dealTime;
	}
	public String getDealId() {
		return dealId;
	}
	public void setDealId(String dealId) {
		this.dealId = dealId;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public GoodsListByteItem getGoods() {
		return goods;
	}
	public void setGoods(GoodsListByteItem goods) {
		this.goods = goods;
	}
	public String getDealPlace() {
		return dealPlace;
	}
	public void setDealPlace(String dealPlace) {
		this.dealPlace = dealPlace;
	}
	public DealItem transferToStrItem() {
		DealItem item = new DealItem();
		item.setBuyer(buyer);
		item.setDealId(dealId);
		item.setDealPlace(dealPlace);
		item.setDealTime(dealTime);
		item.setGoods(goods.transferToStrItem());
		return item;
	}
}
