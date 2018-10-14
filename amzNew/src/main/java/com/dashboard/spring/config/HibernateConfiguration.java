package com.dashboard.spring.config;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.dashboard.spring.config" })
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfiguration {

	@Resource
    private Environment environment;
	
		@Bean
		public HibernateTemplate hibernateTemplate() {
			return new HibernateTemplate(sessionFactory());
		}
		
	 	@Bean
	    public SessionFactory sessionFactory() {
	        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
	        lsfb.setDataSource(dataSource());
	        lsfb.setPackagesToScan(new String[] {"com.dashboard.spring.entity"});
	        lsfb.setHibernateProperties(hibernateProperties());
	        try {
				lsfb.afterPropertiesSet();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        return lsfb.getObject();
	     }
	     
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
	        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
	        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
	        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
	        return dataSource;
	    }
	     
	    private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
	        return properties;        
	    }
	     
	    @Bean
	    public HibernateTransactionManager transactionManager() {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(sessionFactory());
	       return txManager;
	    }
	    
	    @Bean 
	    public HibernateExceptionTranslator hibernateExceptionTranslator(){ 
	      return new HibernateExceptionTranslator(); 
	    }
}
