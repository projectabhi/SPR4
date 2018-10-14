package com.dashboard.test;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
@PropertySource(value = { "classpath:application.properties" })
public class TestConfig {
	@Autowired
	private Environment environment;
	
	@Bean
	  public DataSource dataSource() {
	      DriverManagerDataSource ds = new DriverManagerDataSource();
	      ds.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
	      ds.setUrl(environment.getRequiredProperty("jdbc.url"));
	      ds.setUsername(environment.getRequiredProperty("jdbc.username"));
	      ds.setPassword(environment.getRequiredProperty("jdbc.password"));
	      return ds;
	  }
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
	              new AnnotationConfigApplicationContext(TestConfig.class);
		context.getBean(PersonDao.class).loadAll();
	}

}
