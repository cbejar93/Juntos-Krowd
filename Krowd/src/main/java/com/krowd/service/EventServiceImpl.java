package com.krowd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krowd.beans.Events;
import com.krowd.dao.EventDAO;
import com.krowd.dao.EventDAOImpl;

/*
 * Service class that implements the methods from EventService interface.
 */
@Service(value="eventService")
public class EventServiceImpl implements EventService {

	/*
	 * Creates an instance of the EventDAOImpl.
	 */
	private EventDAO ud = new EventDAOImpl();

	/*
	 * Method that gets all events. Makes a call to the EventDAOImpl method
	 * getAllEvents.(non-Javadoc)
	 * @see com.krowd.service.CommentService#getAllComments()
	 */
	@Override
	public List<Events> getAllEvents() {
		return ud.getAllEvents();
	}

	/*
	 * Method that will create events, by making a call to the EventDAOImpl method
	 * createEvent.(non-Javadoc)
	 * @see com.krowd.service.CommentService#createComment(com.krowd.beans.Comments)
	 */
	@Override
	public void createEvent(Events event) {
		ud.createEvent(event);
	}

	/*
	 * Method that updates events. This also makes a call to the EventDAOImpl and the method,
	 * updateEvent.(non-Javadoc)
	 * @see com.krowd.service.CommentService#updateComment(com.krowd.beans.Comments)
	 */
	@Override
	public void updateEvents(Events event) {
		// TODO Auto-generated method stub
	}

	/*
	 * This method deletes the events (non-Javadoc)
	 * @see com.krowd.service.CommentService#deleteComment(com.krowd.beans.Comments)
	 */
	@Override
	public void deleteEvents(Events event) {
		ud.deleteEvent(event);
	}

	/*
	 * This method gets events by a particular Id. It does this by making a call to the EventDAOImpl
	 * method getEventById.(non-Javadoc)
	 * @see com.krowd.service.CommentService#getCommentById(int)
	 */
	@Override
	public Events getEventById(int id) {
		return ud.getEventById(id);
	}

	/*
	 * This method gets events by a particular UserId. It makes a call to the EventDOAImpl method
	 * getEventsByUserId.(non-Javadoc)
	 * @see com.krowd.service.CommentService#getCommentsByUserId(int)
	 */
	@Override
	public List<Events> getEventByUserId(int userid) {
		return ud.getEventByUserId(userid);
	}

//	@Override
//	public void updateFollow(Events event, Events event2) {
//		// TODO
//	}

}
