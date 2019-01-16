package com.krowd.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.krowd.beans.Users;
import com.krowd.dao.JunctionDAO;
import com.krowd.dao.JunctionDAOImpl;
import com.krowd.dao.UserDAO;
import com.krowd.dao.UserDAOImpl;
import com.krowd.util.HibernateUtil;

//@Configuration
//@ComponentScan
public class Driver {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
//		testingUsers(sf); // pretty self explanatory
		junctionTableTest(sf);
	}
	
	static void junctionTableTest(SessionFactory sf) {
		Session s = sf.getCurrentSession();
		JunctionDAO jd = new JunctionDAOImpl();
		
		System.out.println(jd.getAll());
	}

	static void testingUsers(SessionFactory sf) {
		JunctionDAO jd = new JunctionDAOImpl();
		UserDAO ud = new UserDAOImpl();
		Session s = sf.getCurrentSession();

		
//		System.out.println(jd.getAttendingUsersList(10));

		// IM A MADDDDDDD-MAN

//		String[] array = new String[] { "https://randomuser.me/api/portraits/women/85.jpg",
//				"https://randomuser.me/api/portraits/women/10.jpg", "https://randomuser.me/api/portraits/men/65.jpg",
//				"https://randomuser.me/api/portraits/women/10.jpg", "https://randomuser.me/api/portraits/men/78.jpg",
//				"https://randomuser.me/api/portraits/women/42.jpg", "https://randomuser.me/api/portraits/men/39.jpg",
//				"https://randomuser.me/api/portraits/women/77.jpg", "https://randomuser.me/api/portraits/men/34.jpg",
//				"https://randomuser.me/api/portraits/women/55.jpg", "https://randomuser.me/api/portraits/women/4.jpg",
//				"https://randomuser.me/api/portraits/men/27.jpg", "https://randomuser.me/api/portraits/women/54.jpg",
//				"https://randomuser.me/api/portraits/men/50.jpg", "https://randomuser.me/api/portraits/women/22.jpg",
//				"https://randomuser.me/api/portraits/men/63.jpg", "https://randomuser.me/api/portraits/women/83.jpg",
//				"https://randomuser.me/api/portraits/men/36.jpg", "https://randomuser.me/api/portraits/women/2.jpg",
//				"https://randomuser.me/api/portraits/women/88.jpg", "https://randomuser.me/api/portraits/men/2.jpg",
//				"https://randomuser.me/api/portraits/women/64.jpg", "https://randomuser.me/api/portraits/men/68.jpg",
//				"https://randomuser.me/api/portraits/women/11.jpg", "https://randomuser.me/api/portraits/men/66.jpg",
//				"https://randomuser.me/api/portraits/women/32.jpg", "https://randomuser.me/api/portraits/men/59.jpg"};

		int counter = 0;
		List<Users> ls = ud.getAllUsers();

//		for (Users u : ls) {
//			
//			u.setPhoto_url(array[counter]);
//			ud.updateUsers(u);
//		
//			System.out.println(u);
//			counter ++;
//			
//			if(counter == array.length) {
//				counter = 0;
//			}
//			
//		}

		s.close();
	}

}
