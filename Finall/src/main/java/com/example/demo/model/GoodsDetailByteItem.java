package com.example.demo.model;

import com.example.demo.tool.PicTool;

public class GoodsDetailByteItem extends GoodsListByteItem{
	byte[] oriPicture;
	int expectedPrice;
	String detailText;
	public byte[] getOriPicture() {
		return oriPicture;
	}
	public void setOriPicture(byte[] oriPicture) {
		this.oriPicture = oriPicture;
	}
	public int getExpectedPrice() {
		return expectedPrice;
	}
	public void setExpectedPrice(int expectedPrice) {
		this.expectedPrice = expectedPrice;
	}
	public String getDetailText() {
		return detailText;
	}
	public void setDetailText(String detailText) {
		this.detailText = detailText;
	}
	public GoodsDetailItem tranferToStrItem() {
		GoodsDetailItem item = new GoodsDetailItem();
		item.setGoodsId(goodsId);
		item.setExpectedPrice(expectedPrice);
		item.setIcoPicture(PicTool.base64Encode(icoPicture));
		item.setGoodsTitle(goodsTitle);
		item.setDetailText(detailText);
		return item;
	}
}
