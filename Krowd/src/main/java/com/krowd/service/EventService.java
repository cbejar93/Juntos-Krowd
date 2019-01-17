package com.krowd.service;

import java.util.List;

import com.krowd.beans.Events;

/*
 * This interface that contains methods for the services for Events.
 */
public interface EventService {
	
	public List<Events> getAllEvents();
	public void createEvent(Events event);
	public void updateEvents(Events event);
	public void deleteEvents(Events event);
	public Events getEventById(int id);
	public List<Events> getEventByUserId(int userid);

//	public void updateFollow(Events event, Events event2);
}
