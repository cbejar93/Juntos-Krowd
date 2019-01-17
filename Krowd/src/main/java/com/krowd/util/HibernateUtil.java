package com.krowd.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * This class is for the Hibernate Util. We store the configuration, as well as the 
 * environmental variables for the Hibernate configuration to work within our database.
 */

public class HibernateUtil {
	
private static SessionFactory sessionFactory;
	
	/*
	 * This method gets the session factory for the current session, so it can access the
	 * environmental variables as well as the configuration for the hibernate.cfg.xml file.
	 * At the conclusion of this method call, a session factory will be built, and returned.
	 */
	public static SessionFactory getSessionFactory() {
		if (HibernateUtil.sessionFactory == null) {
			
			//if no sessionFactlry has been created ,create one
			
			Configuration c = new Configuration();
			c.setProperty("hibernate.connection.username", System.getenv("Demo_DB_User"));
			c.setProperty("hibernate.connection.password", System.getenv("Demo_DB_Pass"));
			c.setProperty("hibernate.connection.url", System.getenv("Demo_DB_URL"));
			c.configure(); // :: "hibernate.cfg.xml" :: by default, looks for hibernate.cfg.xml in src/main/resources 
			HibernateUtil.sessionFactory = c.buildSessionFactory();
			
			
		}
		return HibernateUtil.sessionFactory;
	}
}
