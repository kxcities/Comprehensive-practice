package com.example.demo.model;

import com.example.demo.tool.PicTool;

public class GoodsListByteItem {
	String goodsId;
	String ownerName;
	String goodsTitle;
	String tag;
	byte[] icoPicture;
	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getGoodsTitle() {
		return goodsTitle;
	}

	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public byte[] getIcoPicture() {
		return icoPicture;
	}

	public void setIcoPicture(byte[] icoPicture) {
		this.icoPicture = icoPicture;
	}

	public GoodsListItem transferToStrItem() {
		GoodsListItem item = new GoodsListItem();
		item.setGoodsId(goodsId);
		item.setIcoPicture(PicTool.base64Encode(icoPicture));
		item.setTag(tag);
		item.setOwnerName(ownerName);
		item.setGoodsTitle(goodsTitle);
		return item;
	}
}
