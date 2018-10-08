package com.dashboard.to;

import java.util.List;

public class ItemAllTO {
	
	private String moreResultUrl;
	private List<ItemSearchTO> listIemSearh;

	public String getMoreResultUrl() {
		return moreResultUrl;
	}

	public void setMoreResultUrl(String moreResultUrl) {
		this.moreResultUrl = moreResultUrl;
	}

	public List<ItemSearchTO> getListIemSearh() {
		return listIemSearh;
	}

	public void setListIemSearh(List<ItemSearchTO> listIemSearh) {
		this.listIemSearh = listIemSearh;
	}

	
}
