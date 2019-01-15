package com.krowd.service;

import java.util.List;

import com.krowd.beans.Events;
import com.krowd.dao.EventDAO;
import com.krowd.dao.EventDAOImpl;

public interface EventService {
	
	public List<Events> getAllEvents();
	public void createEvent(Events event);
	public void updateEvents(Events event);
	public void deleteEvents(Events event);
	public Events getEventById(int id);
	public Events getEventByUserId(int userid);

//	public void updateFollow(Events event, Events event2);
}
