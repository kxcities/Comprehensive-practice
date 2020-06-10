package com.example.demo.model;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

public class DealItem {
	String dealId;
	String buyer;
	GoodsListItem goods;
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
	public GoodsListItem getGoods() {
		return goods;
	}
	public void setGoods(GoodsListItem goods) {
		this.goods = goods;
	}
	public String getDealPlace() {
		return dealPlace;
	}
	public void setDealPlace(String dealPlace) {
		this.dealPlace = dealPlace;
	}
	public Timestamp getDealTime() {
		return dealTime;
	}
	public void setDealTime(Timestamp dealTime) {
		this.dealTime = dealTime;
	}
	String dealPlace;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	Timestamp dealTime;
}
