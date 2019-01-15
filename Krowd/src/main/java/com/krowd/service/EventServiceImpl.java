package com.krowd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krowd.beans.Events;
import com.krowd.dao.EventDAO;
import com.krowd.dao.EventDAOImpl;

@Service(value="eventService")
public class EventServiceImpl implements EventService {

	private EventDAO ud = new EventDAOImpl();

	@Override
	public List<Events> getAllEvents() {
		return ud.getAllEvents();
	}

	@Override
	public void createEvent(Events event) {
		ud.createEvent(event);
	}

	@Override
	public void updateEvents(Events event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteEvents(Events event) {
		ud.deleteEvent(event);
	}

	@Override
	public Events getEventById(int id) {
		return ud.getEventById(id);
	}

	@Override
	public Events getEventByUserId(int userid) {
		return ud.getEventByUserId(userid);
	}

//	@Override
//	public void updateFollow(Events event, Events event2) {
//		// TODO
//	}

}
