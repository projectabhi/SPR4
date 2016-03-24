package com.test.spr4.impl.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
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
		Query query=this.getSession().createQuery("from Login");
		List<Login> loginList=query.list();
		for(Login login:loginList)
		{
			log.info("Id:"+login.getLoginId());
			log.info("First Name:"+login.getFirstName());
			log.info("Last Name:"+login.getLastName());
			log.info("User Id:"+login.getUsername());
			log.info("Pass:"+login.getPassword());
			log.info("Role:"+login.getUserRole());
		}
 	}
}
