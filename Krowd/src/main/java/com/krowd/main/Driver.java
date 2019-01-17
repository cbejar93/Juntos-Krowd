package com.krowd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.krowd.beans.Events;
import com.krowd.dao.EventDAO;
import com.krowd.dao.EventDAOImpl;
import com.krowd.dao.UserDAO;
import com.krowd.dao.UserDAOImpl;
import com.krowd.util.HibernateUtil;

//@Configuration
//@ComponentScan
public class Driver {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		testingUsers(sf); // pretty self explanatory
	}

	static void testingUsers(SessionFactory sf) {
		UserDAO ud = new UserDAOImpl();
		EventDAO ed = new EventDAOImpl();
		Session s = sf.getCurrentSession();
		
		Events evn = new Events("Welcome to The Jungle",
				"This is Purely a test of the Event Creation System, Thanks for looking Though", 900);
		ed.createEvent(evn);
		
		System.out.println(evn);
		s.close();
	}

}
