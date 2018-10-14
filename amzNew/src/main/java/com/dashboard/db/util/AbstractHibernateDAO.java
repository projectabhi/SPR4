package com.dashboard.db.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public abstract class AbstractHibernateDAO {

	/*@Autowired
    private HibernateTemplate hibernateTemplate;
 
    protected Session getSession(){
        return hibernateTemplate.getCurrentSession();
    }*/
}
