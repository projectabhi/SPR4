package com.dashboard.spring.dao;

import com.dashboard.spring.entity.ClientInfo;

public interface RequestDao {

	public void persistClientReq(ClientInfo clientInfo);
	public Integer getHitCount();
	public String getMasterData(String paramName);
}
