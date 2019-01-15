package com.krowd.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.krowd.beans.Events;
import com.krowd.util.HibernateUtil;

public class EventDAOImpl implements EventDAO {

	private SessionFactory sf = HibernateUtil.getSessionFactory();
	
	
	@Override
	public Events getEventById(int event_Id) {
		
		Events evn = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			evn = (Events) s.get(Events.class, event_Id);
			tx.commit();
		}
		return evn;
		
	}

	@Override
	public void deleteEvent(Events events) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(events);
			tx.commit();
			s.close();
		}
		
	}

	@Override
	public void updateEvent(Events events) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(events);
			tx.commit();
			s.close();
		}
		
	}

	@Override
	public void createEvent(Events events) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(events);
			tx.commit();
			s.close();
		}
		
	}

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

	@Override
	public Events getEventByUserId(int userid) {
		
		Events evn = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			evn = (Events) s.get(Events.class, userid);
			tx.commit();
		}
		return evn;
	}


}
