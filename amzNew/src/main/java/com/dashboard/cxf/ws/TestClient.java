package com.dashboard.cxf.ws;

import com.amazon.webservices.awsecommerceservice.ItemSearch;
import com.amazon.webservices.awsecommerceservice.ItemSearchRequest;
import com.amazon.webservices.awsecommerceservice.ItemSearchResponse;

public class TestClient {

	public static void main(String[] args) {
		
		ItemSearchRequest request=new ItemSearchRequest();
		request.setSearchIndex("Books");
		request.setKeywords("Meluha");
		request.getResponseGroup().add("Images");
		request.getResponseGroup().add("OfferListings");
		request.getResponseGroup().add("Small");
		
		ItemSearch element=new ItemSearch();
		/*element.setAWSAccessKeyId(AWS_ACCESS_KEY_ID);*/
		element.setAssociateTag("amzborokali-21");
		element.getRequest().add(request);
		ItemSearchResponse response=AmazonClient.getInstance().getClient("ItemSearch").itemSearch(element);

	}

}
