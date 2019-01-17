package com.krowd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krowd.beans.Events;
import com.krowd.beans.Users;
import com.krowd.dao.JunctionDAO;
import com.krowd.dao.JunctionDAOImpl;

/*
 * This is a Service class that implements the JunctionService interface methods.
 */
@Service(value="junctionService")
public class JunctionServiceImpl implements JunctionService {

	/*
	 * Creates an instance of the JunctionDAOImpl.
	 */
	private JunctionDAO jd = new JunctionDAOImpl();

	/*
	 * This method gets a list of Users that a particular User is following.(non-Javadoc)
	 * @see com.krowd.service.JunctionService#getUserFollowingList(int)
	 */
	@Override
	public List<Users> getUserFollowingList(int user_Id) {
		
		return jd.getUserFollowingList(user_Id);
	}

	/*
	 * This method grabs a list of a followers for a particular User.(non-Javadoc)
	 * @see com.krowd.service.JunctionService#getUserFollowerList(int)
	 */
	@Override
	public List<Users> getUserFollowerList(int user_Id) {
		// TODO Auto-generated method stub
		return jd.getUserFollowingList(user_Id);
	}

	/*
	 * This method allows the ability to create a follower. This happens by calling the 
	 * JunctionDAOImpl method createFollower.(non-Javadoc)
	 * @see com.krowd.service.JunctionService#createFollower(com.krowd.beans.Users)
	 */
	@Override
	public void createFollower(Users userFriend) {
		jd.createFollower(userFriend);
	}

	/*
	 * This method allows the ability to unfollow a certain user.(non-Javadoc)
	 * @see com.krowd.service.JunctionService#unFollow(com.krowd.beans.Users)
	 */
	@Override
	public void unFollow(Users userFriend) {
		jd.unFollow(userFriend);
	}

	/*
	 * This method gets a list of all the users will be attending a certain event
	 * by taking in the Event id.(non-Javadoc)
	 * @see com.krowd.service.JunctionService#getAttendingUsersList(int)
	 */
	@Override
	public List<Users> getAttendingUsersList(int event_Id) {
		
		return jd.getAttendingUsersList(event_Id);
	}

	/*
	 * This method tells whether a certain user attending an event. Makes call to 
	 * the JunctionDAOImpl method getEventUserIsAttending.(non-Javadoc)
	 * @see com.krowd.service.JunctionService#getEventUserIsAttending(int)
	 */
	@Override
	public List<Events> getEventUserIsAttending(int user_Id) {
		return jd.getEventUserIsAttending(user_Id);
	}

	/*
	 * This method gives the ability to create an attendee to the method.(non-Javadoc)
	 * @see com.krowd.service.JunctionService#createAttendee(com.krowd.beans.Users)
	 */
	@Override
	public void createAttendee(Users userEvent) {
		jd.createAttendee(userEvent);
	}

	/*
	 * This method simple removes an attendee from a particular event.(non-Javadoc)
	 * @see com.krowd.service.JunctionService#removeAttendee(com.krowd.beans.Users)
	 */
	@Override
	public void removeAttendee(Users userEvent) {
		jd.removeAttendee(userEvent);
	}

}
