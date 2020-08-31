package com.connection.spring4.util;

import java.util.List;
import java.util.Properties;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;

public class LdapManager {

	public String createUserDN(String s)
	{
		String rdn="ou=OU,o=O,c=IN";
		StringBuffer sb=new StringBuffer();
		sb.append("cn");
		sb.append("=");
		sb.append(s);
		sb.append(",");
		sb.append(rdn);
		return sb.toString();
	}
	
	public DirContext getInitContext() throws NamingException
	{
		DirContext ctx=null;
		String contextFactory="com.sun.jndi.ldap.LdapCtxFactory";
		String providerUrl="ldap://<LDAP IP>";
		String auth="username";
		String secPrinciple="cn=root,ou=OU,o=O,c=C";
		String credential="password";
		Properties env=new Properties();
		env.put("java.naming.factory.initial", contextFactory);
		env.put("java.naming.provider.url", providerUrl);
		env.put("java.naming.security.authentication", auth);
		env.put("java.naming.security.principle", secPrinciple);
		env.put("java.naming.security.credentials", credential);
		ctx=new InitialDirContext(env);
		
		return ctx;
	}
	
	public DirContext createUserCtx(String userDN,String password) throws NamingException
	{
		DirContext ctx=null;
		String contextFactory="com.sun.jndi.ldap.LdapCtxFactory";
		String providerUrl="ldap://<LDAP IP>";
		String auth="username";
		Properties env=new Properties();
		env.put("java.naming.factory.initial", contextFactory);
		env.put("java.naming.provider.url", providerUrl);
		env.put("java.naming.security.authentication", auth);
		env.put("java.naming.security.principle", userDN);
		env.put("java.naming.security.credentials", password);
		ctx=new InitialDirContext(env);
		
		return ctx;
	}
	
	public void authenticate(String userId,String pass,String appName) throws Exception
	{
		String attribs[]= {"status","loginattempts","usercreationdate","employeetype"};
		String userDn=createUserDN(userId);
		DirContext ctx=getInitContext();
		Attributes loginAttribs=ctx.getAttributes(userDn, attribs);
		for(NamingEnumeration n=loginAttribs.getAll();n.hasMore();) {
			Attribute attr=(Attribute)n.next();
			if(attr.getID().equalsIgnoreCase("status"))
			{
				NamingEnumeration e=attr.getAll();
				if(e.hasMore()) {
					String obj=(String) e.next();
					if(obj.equalsIgnoreCase("TRUE"))
						;//account status is true
					else
						;//account status is true
				}
			}else if(attr.getID().equalsIgnoreCase("loginattempts")) {
				
			}
		}
		
		ModificationItem mods[] = new ModificationItem[2];
		mods[0]=new ModificationItem(2, new BasicAttribute("status", "FALSE"));
		mods[1]=new ModificationItem(2, new BasicAttribute("loginattempts", 0));
		ctx.modifyAttributes(userDn, mods);
	}
	
	public void addUser(String userId)
	{
		String userDn=createUserDN(userId);
		Attributes attribs=new BasicAttributes();
		Attribute objClass=new BasicAttribute("objectclass");
		objClass.add("top");
		objClass.add("person");
		objClass.add("organizationalPerson");
		objClass.add("inetOrgPerson");
		objClass.add("ePerson");
		attribs.put(objClass);
	}
}
