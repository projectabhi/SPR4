package com.test.spr4.impl.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.test.jpa.entity.Login;
import com.test.jpa.entity.LoginDetail;



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
			Set<LoginDetail> logDetSet=login.getLoginDetails();
			for(LoginDetail detail:logDetSet)
			{
				log.info("detail.getLogDetId()"+detail.getLogDetId());
				log.info("detail.getLoginRole()"+detail.getLoginRole());
				log.info("detail.getLoginDate()"+detail.getLoginDate());
			}
		}
 	}
	
	public int saveLogin(Login login)
	{
		log.info("inside saveLogin method...");
		int i=0;
		login.setFirstName("Gunjeeta");
		login.setLastName("Dey");
		login.setPassword("gungun");
		login.setUsername("BOLTU");
		login.setUserRole("SUPERUSER");
		LoginDetail loginDetail=new LoginDetail();
		loginDetail.setLoginDate(new Timestamp(System.currentTimeMillis()));
		loginDetail.setLoginRole("SUPERUSER");
		loginDetail.setLogin(login);
		Set<LoginDetail> logDetSet=new HashSet<LoginDetail>();
		logDetSet.add(loginDetail);
		login.setLoginDetails(logDetSet);
		try{
			this.getSession().save(login);
			i=1;
		}catch (Exception e) {
			i=0;
		}		
		log.info("exit from saveLogin method...");
		return i;
	}
}
