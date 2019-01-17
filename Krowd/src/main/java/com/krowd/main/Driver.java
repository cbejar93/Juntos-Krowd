package com.krowd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.krowd.dao.JunctionDAO;
import com.krowd.dao.JunctionDAOImpl;
import com.krowd.util.HibernateUtil;

//@Configuration
//@ComponentScan
public class Driver {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		testingUsers(sf); // pretty self explanatory
	}

	static void testingUsers(SessionFactory sf) {
		JunctionDAO js = new JunctionDAOImpl();
		Session s = sf.getCurrentSession();
		
		System.out.println(js.getAll());
		
		s.close();
	}

}
