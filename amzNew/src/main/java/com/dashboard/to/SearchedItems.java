package com.dashboard.to;

import java.util.List;

public class SearchedItems {
	private String items;
	private List<DetailItemTO> detailItemTOs;
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public List<DetailItemTO> getDetailItemTOs() {
		return detailItemTOs;
	}
	public void setDetailItemTOs(List<DetailItemTO> detailItemTOs) {
		this.detailItemTOs = detailItemTOs;
	}	
}
