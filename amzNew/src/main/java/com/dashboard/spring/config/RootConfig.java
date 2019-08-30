package com.dashboard.spring.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.dashboard.spring.dao.RequestDao;

@EnableCaching
@Configuration
@ComponentScan(basePackages={"com.dashboard.spring"})
public class RootConfig {

	@Autowired
	RequestDao requestDao;
	
	//EhCache based CacheManager, most commonly used in Enterprise applications.
    @Bean
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheFactory().getObject());
    }
 
    @Bean
    public EhCacheManagerFactoryBean ehCacheFactory() {
        EhCacheManagerFactoryBean factory = new EhCacheManagerFactoryBean();
        factory.setConfigLocation(new ClassPathResource("ehcache.xml"));
        factory.setShared(true);
        return factory;
    }
    
    @PostConstruct
    public void setSytemProps()
    {
    	System.out.println("Start: Setting application properties ...");
    	String viewUrl=requestDao.getMasterData("views_url");
    	System.setProperty("VIEW_URL", viewUrl);
    	System.out.println("End: Setting application properties ...");
    }
}
