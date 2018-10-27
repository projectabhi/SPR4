package com.dashboard.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.webservices.awsecommerceservice.CustomerReviews;
import com.amazon.webservices.awsecommerceservice.EditorialReview;
import com.amazon.webservices.awsecommerceservice.EditorialReviews;
import com.amazon.webservices.awsecommerceservice.Item;
import com.amazon.webservices.awsecommerceservice.ItemAttributes;
import com.amazon.webservices.awsecommerceservice.ItemAttributes.ItemDimensions;
import com.amazon.webservices.awsecommerceservice.ItemLink;
import com.amazon.webservices.awsecommerceservice.ItemLinks;
import com.amazon.webservices.awsecommerceservice.ItemSearch;
import com.amazon.webservices.awsecommerceservice.ItemSearchRequest;
import com.amazon.webservices.awsecommerceservice.ItemSearchResponse;
import com.amazon.webservices.awsecommerceservice.Items;
import com.amazon.webservices.awsecommerceservice.Offer;
import com.amazon.webservices.awsecommerceservice.OfferListing;
import com.amazon.webservices.awsecommerceservice.Offers;
import com.amazon.webservices.awsecommerceservice.Price;
import com.dashboard.cxf.ws.AmazonClient;
import com.dashboard.form.SearchForm;
import com.dashboard.spring.dao.ItemDAO;
import com.dashboard.spring.entity.MasterItemCategory;
import com.dashboard.to.Categories;
import com.dashboard.to.DetailItemTO;
import com.dashboard.to.ItemAllTO;
import com.dashboard.to.ItemHeightTO;
import com.dashboard.to.ItemSearchTO;
import com.dashboard.to.SearchedItems;

@Service("itemSearchService")
public class ItemSearchService {

	private Logger log=Logger.getLogger(ItemSearchService.class);
	public static final String ASSOCIATE_TAG="amzborokali-21";
	
	@Autowired
	ItemDAO itemDao;
	
	public ItemAllTO getDefaultItems()
	{
		log.info("Inside getDeafultItems:");	
		ItemAllTO allItem=null;
		List<Items> defaultItems = null;
		
		ItemSearchRequest request=new ItemSearchRequest();
		request.setSearchIndex("Electronics");
		request.setKeywords("Gadget");
		request.getResponseGroup().add("Images");
		request.getResponseGroup().add("ItemAttributes");
		request.getResponseGroup().add("Offers");
		request.getResponseGroup().add("PromotionSummary");
		request.getResponseGroup().add("SalesRank");
		request.setSort("salesrank");
		
		ItemSearch element=new ItemSearch();
		element.setAssociateTag(ASSOCIATE_TAG);
		element.getRequest().add(request);
		ItemSearchResponse response=AmazonClient.getInstance().getClient("ItemSearch").itemSearch(element);
		List<ItemSearchTO> listSearchItem = null;
		if(response != null)
		{
			defaultItems = response.getItems();
			if(defaultItems != null && !defaultItems.isEmpty()){
				allItem =new ItemAllTO();
				allItem.setMoreResultUrl(defaultItems.get(0).getMoreSearchResultsUrl());
			}
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
						//log.info("Items:"+itemSearchTO.toString());	
						listSearchItem.add(itemSearchTO);
					}
				}
			}
			if(allItem != null)
				allItem.setListIemSearh(listSearchItem);
		}
		
		return allItem;
	}
	
	public List<Categories> getAllCategory()
	{
		List<Categories> categoriesDsp=null;
		List<MasterItemCategory>  categories=this.itemDao.getAllCategoriesJDBC();
		if(categories != null && !categories.isEmpty()){
			categoriesDsp=new ArrayList<Categories>();
			for(MasterItemCategory masterItemCategory:categories)
			{
				Categories cg=new Categories();
				cg.setCategoryId(masterItemCategory.getCategoryId());
				cg.setCategoryName(masterItemCategory.getCategoryName());
				cg.setCategoryDescription(masterItemCategory.getCatDescription());
				categoriesDsp.add(cg);
			}
		}
		return categoriesDsp;
	}
	
	public SearchedItems getSearchItems(SearchForm form)
	{
		SearchedItems searchedItems=null;
		List<DetailItemTO> detailItemTOs=null;
		
		ItemSearchRequest request=new ItemSearchRequest();
		request.setSearchIndex(form.getSearchIndex());
		request.setKeywords(form.getKeywords());
		request.getResponseGroup().add("EditorialReview");
		request.getResponseGroup().add("ItemAttributes");
		request.getResponseGroup().add("Offers");
		request.getResponseGroup().add("Images");
		request.getResponseGroup().add("Reviews");
		
		ItemSearch element=new ItemSearch();
		element.setAssociateTag(ASSOCIATE_TAG);
		element.getRequest().add(request);
		ItemSearchResponse response=AmazonClient.getInstance().getClient("ItemSearch").itemSearch(element);
		
		List<Items> items = null;
		if(response != null)
		{
			searchedItems=new SearchedItems();
			searchedItems.setItems("Y");
			detailItemTOs = new ArrayList<DetailItemTO>();
			items = response.getItems();
			if(items != null && !items.isEmpty()){
				List<Item> item=items.get(0).getItem();
				if(item != null && !item.isEmpty())
				{
					for(Item itm:item)
					{
						DetailItemTO detailItemTO=new DetailItemTO();
						detailItemTO.setAsin(itm.getASIN());
						if(itm.getMediumImage() != null)
							detailItemTO.setMediumImgUrl(itm.getMediumImage().getURL());
						if(itm.getLargeImage() != null)
							detailItemTO.setLargeImgUrl(itm.getLargeImage().getURL());
						Offers offers=itm.getOffers();
						List<Offer> offersList=null;
						if(offers!= null)
							offersList=offers.getOffer();
						if(offersList != null && !offersList.isEmpty() && offersList.size()>0)
						{
							List<OfferListing> offersListing=offersList.get(0).getOfferListing();
							for(OfferListing offerListing:offersListing)
							{
								if(offerListing.getPrice() != null)
								{
									detailItemTO.setFormattedPrice(offerListing.getPrice().getFormattedPrice());
								}
								if(offerListing.getSalePrice() != null)
								{
									detailItemTO.setActualFormattedPrc(offerListing.getSalePrice().getFormattedPrice());
								}
								if(offerListing.getAmountSaved() != null)
								{
									detailItemTO.setSaved(offerListing.getAmountSaved().getFormattedPrice());
								}
								if(offerListing.getPercentageSaved() != null)
								{
									detailItemTO.setPercentSaved(offerListing.getPercentageSaved());
								}
								break;
							}
						}
						
						EditorialReviews editorialReviews=itm.getEditorialReviews();
						List<EditorialReview> reviews=editorialReviews.getEditorialReview();
						if(reviews!= null && !reviews.isEmpty() && reviews.size()>0)
							detailItemTO.setEditorReview(reviews.get(0).getContent());
						
						CustomerReviews customerReviews=itm.getCustomerReviews();
						if(customerReviews.isHasReviews())
							detailItemTO.setCustomerReviewUrl(customerReviews.getIFrameURL());
						
						ItemAttributes itemAttributes=itm.getItemAttributes();
						if(itemAttributes!= null){
							detailItemTO.setTitle(itemAttributes.getTitle());
							List<String> features = itemAttributes.getFeature();
							detailItemTO.setFeature(features);
							ItemDimensions dimensions=itemAttributes.getItemDimensions();
							if(dimensions != null){
								ItemHeightTO heightTO=new ItemHeightTO(); 
								heightTO.setHeight(dimensions.getHeight());
								heightTO.setLength(dimensions.getLength());
								heightTO.setWeight(dimensions.getWeight());
								heightTO.setWidth(dimensions.getWidth());
								
								detailItemTO.setHeightTO(heightTO);
							}
						}
						
						ItemLinks itLinks= itm.getItemLinks();
						if(itLinks != null)
						{
							List<ItemLink> itmLnk=itLinks.getItemLink();
							for(ItemLink link:itmLnk)
							{
								if("Add To Wishlist".equalsIgnoreCase(link.getDescription())){
									detailItemTO.setAddToWishUrl(link.getURL());
								}
							}
						}
						log.fatal("Detail:"+detailItemTO);
						detailItemTOs.add(detailItemTO);
					}
				}
			}
			searchedItems.setDetailItemTOs(detailItemTOs);
		}
		return searchedItems;
	}
}
