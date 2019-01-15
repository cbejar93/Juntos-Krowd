package com.krowd.dao;

import java.util.List;

import com.krowd.beans.Events;

public interface EventDAO {
	
	public List<Events> getAllEvents();
	public Events getEventById(int event_Id);
	public void deleteEvent(Events events);
	public void updateEvent(Events events);
	public void createEvent(Events events);
	public Events getEventByUserId(int userid);

}
