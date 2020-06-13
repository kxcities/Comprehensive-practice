package com.example.demo.model;
public class GoodsDetailItem  extends GoodsListItem{
	String oriPicture;
	int expectedPrice;
	String detailText;
	String area;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setExpectedPrice(int expectedPrice) {
		this.expectedPrice = expectedPrice;
	}
	public int getExpectedPrice() {
		return expectedPrice;
	}
	public String getDetailText() {
		return detailText;
	}
	public void setDetailText(String detailText) {
		this.detailText = detailText;
	}
	public String getOriPicture() {
		return oriPicture;
	}
	public void setOriPicture(String oriPicture) {
		this.oriPicture = oriPicture;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((detailText == null) ? 0 : detailText.hashCode());
		result = prime * result + expectedPrice;
		result = prime * result + ((oriPicture == null) ? 0 : oriPicture.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoodsDetailItem other = (GoodsDetailItem) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (detailText == null) {
			if (other.detailText != null)
				return false;
		} else if (!detailText.equals(other.detailText))
			return false;
		if (expectedPrice != other.expectedPrice)
			return false;
		if (oriPicture == null) {
			if (other.oriPicture != null)
				return false;
		} else if (!oriPicture.equals(other.oriPicture))
			return false;
		return true;
	}
}
