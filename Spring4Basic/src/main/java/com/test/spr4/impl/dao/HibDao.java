package com.test.spr4.impl.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class HibDao {

	static Logger log=Logger.getLogger(HibDao.class);
	
	@Resource(name="sessionFactory")
	public SessionFactory sessionFactory;
	
	protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }


	public void getUsers()
	{
		List list=getSession().createSQLQuery("SELECT * FROM LOGIN").list();
		log.info(list.toString());
	}
}
