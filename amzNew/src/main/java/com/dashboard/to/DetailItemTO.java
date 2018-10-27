package com.dashboard.to;

import java.math.BigInteger;
import java.util.List;

public class DetailItemTO {

	private String title;
	private String formattedPrice;
	private String actualFormattedPrc;
	private String saved;
	private String editorReview;
	private boolean hasCustomerReviews; 
	private String customerReviewUrl;
	private String asin;
	private String mediumImgUrl;
	private List<String> feature;
	private String detailPageUrl;
	private ItemHeightTO heightTO;
	private String color;
	private String addToWishUrl;
	private String largeImgUrl;
	private BigInteger percentSaved;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFormattedPrice() {
		return formattedPrice;
	}
	public void setFormattedPrice(String formattedPrice) {
		this.formattedPrice = formattedPrice;
	}
	public String getEditorReview() {
		return editorReview;
	}
	public void setEditorReview(String editorReview) {
		this.editorReview = editorReview;
	}
	public String getCustomerReviewUrl() {
		return customerReviewUrl;
	}
	public void setCustomerReviewUrl(String customerReviewUrl) {
		this.customerReviewUrl = customerReviewUrl;
	}
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public String getMediumImgUrl() {
		return mediumImgUrl;
	}
	public void setMediumImgUrl(String mediumImgUrl) {
		this.mediumImgUrl = mediumImgUrl;
	}
	public List<String> getFeature() {
		return feature;
	}
	public void setFeature(List<String> feature) {
		this.feature = feature;
	}
	public String getDetailPageUrl() {
		return detailPageUrl;
	}
	public void setDetailPageUrl(String detailPageUrl) {
		this.detailPageUrl = detailPageUrl;
	}
	public String getActualFormattedPrc() {
		return actualFormattedPrc;
	}
	public void setActualFormattedPrc(String actualFormattedPrc) {
		this.actualFormattedPrc = actualFormattedPrc;
	}
	public String getSaved() {
		return saved;
	}
	public void setSaved(String saved) {
		this.saved = saved;
	}
	public boolean isHasCustomerReviews() {
		return hasCustomerReviews;
	}
	public void setHasCustomerReviews(boolean hasCustomerReviews) {
		this.hasCustomerReviews = hasCustomerReviews;
	}
	public ItemHeightTO getHeightTO() {
		return heightTO;
	}
	public void setHeightTO(ItemHeightTO heightTO) {
		this.heightTO = heightTO;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAddToWishUrl() {
		return addToWishUrl;
	}
	public void setAddToWishUrl(String addToWishUrl) {
		this.addToWishUrl = addToWishUrl;
	}
	public String getLargeImgUrl() {
		return largeImgUrl;
	}
	public void setLargeImgUrl(String largeImgUrl) {
		this.largeImgUrl = largeImgUrl;
	}
	
	public BigInteger getPercentSaved() {
		return percentSaved;
	}
	public void setPercentSaved(BigInteger percentSaved) {
		this.percentSaved = percentSaved;
	}
	@Override
	public String toString() {
		return "DetailItemTO [title=" + title + ", formattedPrice=" + formattedPrice + ", actualFormattedPrc="
				+ actualFormattedPrc + ", saved=" + saved + ", editorReview=" + editorReview + ", hasCustomerReviews="
				+ hasCustomerReviews + ", customerReviewUrl=" + customerReviewUrl + ", asin=" + asin + ", mediumImgUrl="
				+ mediumImgUrl + ", feature=" + feature + ", detailPageUrl=" + detailPageUrl + ", heightTO=" + heightTO
				+ ", color=" + color + ", addToWishUrl=" + addToWishUrl + ", largeImgUrl=" + largeImgUrl
				+ ", percentSaved=" + percentSaved + "]";
	}
}
