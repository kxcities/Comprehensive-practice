package com.example.demo.model;

import java.sql.Timestamp;

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buyer == null) ? 0 : buyer.hashCode());
		result = prime * result + ((dealPlace == null) ? 0 : dealPlace.hashCode());
		result = prime * result + ((dealTime == null) ? 0 : dealTime.hashCode());
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DealItem other = (DealItem) obj;
		if (buyer == null) {
			if (other.buyer != null)
				return false;
		} else if (!buyer.equals(other.buyer))
			return false;
		if (dealPlace == null) {
			if (other.dealPlace != null)
				return false;
		} else if (!dealPlace.equals(other.dealPlace))
			return false;
		if (dealTime == null) {
			if (other.dealTime != null)
				return false;
		} else if (!dealTime.equals(other.dealTime))
			return false;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		return true;
	}
	Timestamp dealTime;
}
