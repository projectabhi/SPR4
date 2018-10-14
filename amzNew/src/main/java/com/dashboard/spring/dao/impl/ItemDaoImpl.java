package com.dashboard.spring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.dashboard.spring.dao.ItemDAO;
import com.dashboard.spring.entity.MasterItemCategory;
import com.dashboard.to.Categories;

@Repository("itemDao")
public class ItemDaoImpl implements ItemDAO {
	
	Logger log = Logger.getLogger(ItemDaoImpl.class);
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void getAllCategories() {
		log.info("Using Hibernate .....");
		List<MasterItemCategory> masterItemCategories= this.hibernateTemplate.loadAll(MasterItemCategory.class);
		for(MasterItemCategory category:masterItemCategories)
		{
			log.info(category.getCategoryName());
		}
		this.getAllCategoriesJDBC();
		//return null;
	}
	
	public void getAllCategoriesJDBC() {
		log.info("Using JDBCTemplate .....");
		List<MasterItemCategory> masterItemCategories= this.jdbcTemplate.query("SELECT * FROM MASTER_ITEM_CATEGORY", new RowMapper<MasterItemCategory>(){  
		    @Override  
		    public MasterItemCategory mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	MasterItemCategory e=new MasterItemCategory();  
		        e.setCategoryId(rs.getInt(1));  
		        e.setCategoryName(rs.getString(2));  
		        e.setCatDescription(rs.getString(3));  
		        return e;  
		    }  
		    });  
		
		for(MasterItemCategory category:masterItemCategories)
		{
			log.info(category.getCategoryName());
		}
		//return null;
	}

}
