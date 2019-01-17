package com.krowd.dao;

import java.util.List;

import com.krowd.beans.Events;
import com.krowd.beans.Users;

public interface JunctionDAO {
	
	public List<Users> getAll();
	
	//User_Friends Following and Followers
	public List<Users> getUserFollowingList(int user_Id);
	public List<Users> getUserFollowerList(int user_Id);
	
	// User_Friends adding a Follower To Table
	public void createFollower(Users userFriend);
	
	// User_Friends deleting a Follower From Table
	public void unFollow(Users userFriend);


	
	
	//User_Events Get Users Attending An Event
	public List<Users> getAttendingUsersList(int event_Id);
	
	//USer_Events Get Events User Is Attending
	public List<Events> getEventUserIsAttending(int user_Id);
	
	// User_Events adding an Attendee To An Event
	public void createAttendee(Users userEvent);
	
	// User_Events removing an Attendee From Table
	public void removeAttendee(Users userEvent);
}
