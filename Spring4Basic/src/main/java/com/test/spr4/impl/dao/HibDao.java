package com.test.spr4.impl.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.test.spr4.entity.Login;

@Transactional
public class HibDao {

	private static Logger log=Logger.getLogger(HibDao.class);
	
	@Resource(name="sessionFactory")
	public SessionFactory sessionFactory;
	
	protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }


	public void getUsers()
	{
		List list=(List) getSession().get(Login.class, 1L);
		log.info(list.get(0));
	}
}
