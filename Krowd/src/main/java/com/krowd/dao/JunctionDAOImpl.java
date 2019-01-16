package com.krowd.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.krowd.beans.User_Events;
import com.krowd.beans.User_Friends;
import com.krowd.util.HibernateUtil;

public class JunctionDAOImpl implements JunctionDAO {

	private SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public List<User_Friends> getAll(){
		List<User_Friends> users = null;
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			users = s.createQuery("from User_Friends").getResultList();
			tx.commit();
			s.close();
		}
		return users;
	}
	
	// get List from User_Friends
	// Where CurrentUser//Id equals Following_User_Id = ?
	@Override
	public List<User_Friends> getUserFollowingList(int user_Id) {
		List<User_Friends> users = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			users = s.createQuery("from user_Friends where FOLLOWING_USER_ID = " + user_Id).getResultList();
			tx.commit();
			s.close();
		}
		return users;
	}

	// get List from User_Friends
	// Where CurrentUser//Id equals User_Id = ?
	@Override
	public List<User_Friends> getUserFollowerList(int user_Id) {
		List<User_Friends> users = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			users = s.createQuery("from user_Friends where USER_ID = " + user_Id).getResultList();
			tx.commit();
			s.close();
		}
		return users;
	}

	@Override
	public void createFollower(User_Friends userFriend) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.persist(userFriend);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void unFollow(User_Friends userFriend) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.delete(userFriend);
			tx.commit();
			s.close();
		}
	}
	
	
	// get User List from User_Events where Event_Id = ?
	@Override
	public List<User_Events> getAttendingUsersList(int event_Id) {
		List<User_Events> userEvents = new ArrayList<>();
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			userEvents = s.createQuery("from user_Events where EVENT_ID = " + event_Id).getResultList();
			tx.commit();
			s.close();
		}
		return userEvents;
	}



	@Override
	public List<User_Events> getEventUserIsAttending(int user_Id) {
		List<User_Events> userEvents = new ArrayList<>();
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			userEvents = s.createQuery("from user_Events where User_Id = " + user_Id).getResultList();
			tx.commit();
			s.close();
		}
		return userEvents;
	}

	@Override
	public void createAttendee(User_Events userEvent) {
	}

	@Override
	public void removeAttendee(User_Events userEvent) {
		
	}

}
