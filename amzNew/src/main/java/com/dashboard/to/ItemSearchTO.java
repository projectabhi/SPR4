package com.dashboard.to;

import com.amazon.webservices.awsecommerceservice.DecimalWithUnits;

public class ItemSearchTO {
	private String detailPageURL;
	private String mediumImgUrl;
	private DecimalWithUnits mediumImgHeight;
	private String itemTitle;
	private String formattedPrice;
	private String allOffersUrl;
	
	public String getDetailPageURL() {
		return detailPageURL;
	}
	public void setDetailPageURL(String detailPageURL) {
		this.detailPageURL = detailPageURL;
	}
	public String getMediumImgUrl() {
		return mediumImgUrl;
	}
	public void setMediumImgUrl(String mediumImgUrl) {
		this.mediumImgUrl = mediumImgUrl;
	}
	
	public DecimalWithUnits getMediumImgHeight() {
		return mediumImgHeight;
	}
	public void setMediumImgHeight(DecimalWithUnits mediumImgHeight) {
		this.mediumImgHeight = mediumImgHeight;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getFormattedPrice() {
		return formattedPrice;
	}
	public void setFormattedPrice(String formattedPrice) {
		this.formattedPrice = formattedPrice;
	}
	
	public String getAllOffersUrl() {
		return allOffersUrl;
	}
	public void setAllOffersUrl(String allOffersUrl) {
		this.allOffersUrl = allOffersUrl;
	}
	
	@Override
	public String toString() {
		return "ItemSearchTO [detailPageURL=" + detailPageURL + ", mediumImgUrl=" + mediumImgUrl + ", mediumImgHeight="
				+ mediumImgHeight + ", itemTitle=" + itemTitle + ", formattedPrice=" + formattedPrice
				+ ", allOffersUrl=" + allOffersUrl + "]";
	}
	
	
}
