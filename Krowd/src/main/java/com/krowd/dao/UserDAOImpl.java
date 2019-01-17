package com.krowd.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.krowd.beans.Users;
import com.krowd.util.HibernateUtil;

/*
 * Class that implements all the methods from the UserDAO interface.
 */
public class UserDAOImpl implements UserDAO {

	/*
	 * Creates a session factory restrictive to the class.
	 */
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	/*
	 * This method simply gets all users.(non-Javadoc)
	 * @see com.krowd.dao.UserDAO#getAllUsers()
	 */
	public List<Users> getAllUsers() {
		List<Users> userList = new ArrayList<>();

		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();

			userList = s.createQuery("from Users").getResultList();

			tx.commit();
			s.close();
		}

		return userList;

	}

	/*
	 * This method allows a User to be added.(non-Javadoc)
	 * @see com.krowd.dao.UserDAO#addUser(com.krowd.beans.Users)
	 */
	@Override
	public void addUser(Users user) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();

//			changed from persist to save(will research) - would throw, detached to persistent state exception
			s.persist(user);
			tx.commit();
			s.close();
		}
	}

	/*
	 * This method gives the ability to update a certain user.(non-Javadoc)
	 * @see com.krowd.dao.UserDAO#updateUsers(com.krowd.beans.Users)
	 */
	@Override
	public void updateUsers(Users user) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(user);
			tx.commit();
			s.close();
		}

	}

	/*
	 * This method gives the ability to delete a certain user.(non-Javadoc)
	 * @see com.krowd.dao.UserDAO#deleteUsers(com.krowd.beans.Users)
	 */
	@Override
	public void deleteUsers(Users user) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(user);
			tx.commit();
			s.close();
		}
	}

	/*
	 * This method gets a certain User by their Id.(non-Javadoc)
	 * @see com.krowd.dao.UserDAO#getUserById(int)
	 */
	@Override
	public Users getUserById(int id) {
		Users user = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			user = (Users) s.get(Users.class, id);
			tx.commit();
			s.close();
		}
		return user;
	}

	/*
	 * This method gets a certain User by their Username and password.(non-Javadoc)
	 * @see com.krowd.dao.UserDAO#getUsersByUserAndPass(java.lang.String, java.lang.String)
	 */
	public List<Users> getUsersByUserAndPass(String username, String password){
		List<Users> user = new ArrayList<>();
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			user = s.createQuery("from Users where USERNAME = " + username + " and PASSWORD = " + password).getResultList();
			
			tx.commit();
			s.close();
		}
		return user;
	}

	/*
	 * This method gets User by Fid.(non-Javadoc)
	 * @see com.krowd.dao.UserDAO#getUserByFID(java.lang.String)
	 */
	@Override
	public List<Users> getUserByFID(String fID) {
		List<Users> user = null;
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			
			user = s.createQuery("from Users where FID = :fID").setParameter("fID", fID).getResultList();
			
			tx.commit();
			s.close();
		}
		return user;
	}
	


//	@Override
//	public void updateFollow(Users user, Users user2) {
//		// TODO Auto-generated method stub
//		
//	}

}
