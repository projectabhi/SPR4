package com.dashboard.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService{

	private Logger log=Logger.getLogger(MyUserDetailsService.class);

	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		log.info("inside loadbyusername");
		List<SimpleGrantedAuthority> authList = getAuthorities();
		log.info("Username:"+arg0);
		UserDetails user = new User(arg0, "qwer4099", true, true, true, true, authList);
        return user;
	}
	
	private List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authList = new ArrayList<SimpleGrantedAuthority>();
        authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
 
        //you can also add different roles here
        //for example, the user is also an admin of the site, then you can add ROLE_ADMIN
        //so that he can view pages that are ROLE_ADMIN specific
        /*if (role != null && role.trim().length() > 0) {
            if (role.equals("admin")) {
                authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        }*/
 
        return authList;
    }
}
