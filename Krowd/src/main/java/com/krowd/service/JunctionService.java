package com.krowd.service;

import java.util.List;

import com.krowd.beans.Events;
import com.krowd.beans.Users;

public interface JunctionService {

	// Users Following and Followers
	public List<Users> getUserFollowingList(int user_Id);

	public List<Users> getUserFollowerList(int user_Id);

	// Users adding a Follower To Table
	public void createFollower(Users userFriend);

	// Users deleting a Follower From Table
	public void unFollow(Users userFriend);

	// Users Get Users Attending An Event
	public List<Users> getAttendingUsersList(int user_Id);

	// USers Get Events User Is Attending
	public List<Events> getEventUserIsAttending(int event_Id);

	// Users adding an Attendee To An Event
	public void createAttendee(Users userEvent);

	// Users removing an Attendee From Table
	public void removeAttendee(Users userEvent);
}
