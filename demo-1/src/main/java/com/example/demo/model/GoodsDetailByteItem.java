package com.example.demo.model;

import com.example.demo.tool.PicTool;

public class GoodsDetailByteItem extends GoodsListByteItem{
	byte[] oriPicture;
	int expectedPrice;
	String detailText;
	String area;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
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
		item.setOriPicture(PicTool.base64Encode(oriPicture));
		item.setGoodsTitle(goodsTitle);
		item.setDetailText(detailText);
		item.setOwnerName(ownerName);
		item.setTag(tag);
		item.setArea(area);
		return item;
	}
}
