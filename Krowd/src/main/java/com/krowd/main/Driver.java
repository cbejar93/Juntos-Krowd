package com.krowd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.krowd.dao.CommentDAO;
import com.krowd.dao.CommentDAOImpl;
import com.krowd.dao.UserDAO;
import com.krowd.dao.UserDAOImpl;
import com.krowd.util.HibernateUtil;

//@Configuration
//@ComponentScan
public class Driver {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		testingUsers(sf); //pretty self explanatory 
		
		
	}
	
	static void testingUsers(SessionFactory sf) {
		UserDAO ud = new UserDAOImpl();
		CommentDAO cd = new CommentDAOImpl();
		Session s = sf.getCurrentSession();
		
		System.out.println(ud.getUsersByUserAndPass("BetterThanYou", "ImTheBest"));
		
//		System.out.println(cd.getCommentsByUserId(16));
		
		s.close();
	}

}
