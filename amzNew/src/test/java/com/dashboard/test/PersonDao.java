package com.dashboard.test;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {

		@Autowired
		private DataSource dataSource;
		private JdbcTemplate jdbcTemplate;
		
		  @PostConstruct
		  private void postConstruct() {
		      jdbcTemplate = new JdbcTemplate(dataSource);
		  }
		  
		  public void loadAll() {
			  StringBuilder sb = new StringBuilder("select count(1) from master_item_category");
		      List<Integer> lst= (List)jdbcTemplate.queryForList(sb.toString(),Integer.class);
		      System.out.println(lst.get(0).intValue());
		  }
}
