package com.dashboard.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.amazon.webservices.awsecommerceservice.Item;
import com.amazon.webservices.awsecommerceservice.ItemLink;
import com.amazon.webservices.awsecommerceservice.ItemLinks;
import com.amazon.webservices.awsecommerceservice.ItemSearch;
import com.amazon.webservices.awsecommerceservice.ItemSearchRequest;
import com.amazon.webservices.awsecommerceservice.ItemSearchResponse;
import com.amazon.webservices.awsecommerceservice.Items;
import com.dashboard.cxf.ws.AmazonClient;
import com.dashboard.to.ItemAllTO;
import com.dashboard.to.ItemSearchTO;

@Service("itemSearchService")
public class ItemSearchService {

	private Logger log=Logger.getLogger(ItemSearchService.class);
	public static final String ASSOCIATE_TAG="amzborokali-21";
	
	public ItemAllTO getDefaultItems()
	{
		log.info("Inside getDeafultItems:");	
		ItemAllTO allItem=null;
		List<Items> defaultItems = null;
		
		ItemSearchRequest request=new ItemSearchRequest();
		request.setSearchIndex("All");
		request.setKeywords("Electronics");
		request.getResponseGroup().add("Images");
		request.getResponseGroup().add("ItemAttributes");
		request.getResponseGroup().add("Offers");
		
		ItemSearch element=new ItemSearch();
		element.setAssociateTag(ASSOCIATE_TAG);
		element.getRequest().add(request);
		ItemSearchResponse response=AmazonClient.getClient("ItemSearch").itemSearch(element);
		List<ItemSearchTO> listSearchItem = null;
		if(response != null)
		{
			defaultItems = response.getItems();
			if(defaultItems != null)
				allItem =new ItemAllTO();
			for(Items items:defaultItems)
			{
				allItem.setMoreResultUrl(items.getMoreSearchResultsUrl());
				List<Item> itemResults=items.getItem();
				if(itemResults != null && !itemResults.isEmpty())
				{
					listSearchItem = new ArrayList<ItemSearchTO>();
					for(Item itm:itemResults)
					{
						ItemSearchTO itemSearchTO=new ItemSearchTO();
						itemSearchTO.setDetailPageURL(itm.getDetailPageURL());
						if(itm.getItemAttributes() != null)
							itemSearchTO.setItemTitle(itm.getItemAttributes().getTitle());
						if(itm.getOfferSummary() != null && itm.getOfferSummary().getLowestNewPrice() != null)
							itemSearchTO.setFormattedPrice(itm.getOfferSummary().getLowestNewPrice().getFormattedPrice());
						if(itm.getMediumImage() != null)
						{
							itemSearchTO.setMediumImgUrl(itm.getMediumImage().getURL());
							itemSearchTO.setMediumImgHeight(itm.getMediumImage().getHeight());
						}
						
						ItemLinks itemLinks = itm.getItemLinks();
						List<ItemLink> listItemLink =null;
						if(itemLinks != null)
							listItemLink = itemLinks.getItemLink();
						if(listItemLink != null && !listItemLink.isEmpty())
						{
							for(ItemLink link:listItemLink)
							{
								if("All Offers".equalsIgnoreCase(link.getDescription()))
								{
									itemSearchTO.setAllOffersUrl(link.getURL());
									break;
								}
							}
						}
						if(itemLinks != null)
						log.info("Items:"+itemSearchTO.toString());	
						listSearchItem.add(itemSearchTO);
					}
				}
			}
			if(allItem != null)
				allItem.setListIemSearh(listSearchItem);
		}
		
		return allItem;
	}
}
