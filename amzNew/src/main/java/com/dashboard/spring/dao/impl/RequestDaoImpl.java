package com.dashboard.spring.dao.impl;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.dashboard.spring.dao.RequestDao;
import com.dashboard.spring.entity.ClientInfo;

@Repository("requestDao")
public class RequestDaoImpl implements RequestDao {

	Logger log = Logger.getLogger(RequestDaoImpl.class);
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional
	public void persistClientReq(ClientInfo clientInfo) {
		this.hibernateTemplate.persist(clientInfo);
	}

	public Integer getHitCount()
	{
		log.info("Inside getHitCount....");
		Integer count=null;
		StringBuffer sbf=new StringBuffer("SELECT COUNT(1) FROM CLIENT_INFO");
		count=this.jdbcTemplate.queryForObject(sbf.toString(), Integer.class);
		log.info("Total Hit:"+count);
		return count;
	}

	@Override
	@Cacheable("masterdata")
	public String getMasterData(String paramName) {
		log.info("paramName:"+paramName);
		String paramValue=null;
		StringBuffer sbf=new StringBuffer("SELECT PARAMETER_VALUE FROM DASHBOARD_MASTER WHERE PARAMETER_NAME=?");
		paramValue=this.jdbcTemplate.queryForObject(sbf.toString(),new Object[]{paramName} ,String.class);
		log.info("paramValue"+paramValue);
		return paramValue;
	}
}
