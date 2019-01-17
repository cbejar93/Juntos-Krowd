package com.krowd.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.krowd.beans.Events;
import com.krowd.util.HibernateUtil;

/*
 * This class implements the methods from the EventDAO.
 */
public class EventDAOImpl implements EventDAO {

	/*
	 * This simply creates a session factory for the class.
	 */
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	
	/*
	 * This method gets all events that are under a particular event Id.(non-Javadoc)
	 * @see com.krowd.dao.EventDAO#getEventById(int)
	 */
	@Override
	public Events getEventById(int event_Id) {
		
		Events evn = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			evn = (Events) s.get(Events.class, event_Id);
			tx.commit();
		}
		catch (NullPointerException e){
			evn = null;
		}
		return evn;
		
	}

	/*
	 * This method deletes events.(non-Javadoc)
	 * @see com.krowd.dao.EventDAO#deleteEvent(com.krowd.beans.Events)
	 */
	@Override
	public void deleteEvent(Events events) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(events);
			tx.commit();
			s.close();
		}
		
	}

	/*
	 * This method updates events.(non-Javadoc)
	 * @see com.krowd.dao.EventDAO#updateEvent(com.krowd.beans.Events)
	 */
	@Override
	public void updateEvent(Events events) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(events);
			tx.commit();
			s.close();
		}
		
	}

	/*
	 * This method gives the ability to create an event.(non-Javadoc)
	 * @see com.krowd.dao.EventDAO#createEvent(com.krowd.beans.Events)
	 */
	@Override
	public void createEvent(Events events) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(events);
			tx.commit();
			s.close();
		}
		
	}

	/*
	 * This method simply gets all events.(non-Javadoc)
	 * @see com.krowd.dao.EventDAO#getAllEvents()
	 */
	@Override
	public List<Events> getAllEvents() {
		List<Events> events = new ArrayList<>();
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			events = s.createQuery("from Events").getResultList();
			tx.commit();
			s.close();
		}
		return events;
	}

	/*
	 * This method simply grabs all events by a specified user. This happens
	 * by grabbing the particular User id, and displaying those events.(non-Javadoc)
	 * @see com.krowd.dao.EventDAO#getEventByUserId(int)
	 */
	@Override
	public List<Events> getEventByUserId(int userid) {
		
		List<Events> evn = new ArrayList<>();
		
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			evn = s.createQuery("from Events where USER_ID = " + userid).getResultList();
			tx.commit();
			s.close();
		}
		return evn;
	}


}
