package com.krowd.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.krowd.beans.Users;
import com.krowd.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
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

	@Override
	public void updateUsers(Users user) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(user);
			tx.commit();
			s.close();
		}

	}

	@Override
	public void deleteUsers(Users user) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(user);
			tx.commit();
			s.close();
		}
	}

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

	

//	@Override
//	public void updateFollow(Users user, Users user2) {
//		// TODO Auto-generated method stub
//		
//	}

}
