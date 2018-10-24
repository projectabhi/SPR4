package com.dashboard.form;

public class SearchForm {

	private String searchIndex;
	private String keywords;
	public String getSearchIndex() {
		return searchIndex;
	}
	public void setSearchIndex(String searchIndex) {
		this.searchIndex = searchIndex;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	@Override
	public String toString() {
		return "SearchForm [searchIndex=" + searchIndex + ", keywords=" + keywords + "]";
	}
	
	
}
