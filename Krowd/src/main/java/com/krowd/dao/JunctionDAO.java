package com.krowd.dao;

import java.util.List;

import com.krowd.beans.User_Events;
import com.krowd.beans.User_Friends;

public interface JunctionDAO {
	
	public List<User_Friends> getAll();
	
	//User_Friends Following and Followers
	public List<User_Friends> getUserFollowingList(int user_Id);
	public List<User_Friends> getUserFollowerList(int user_Id);
	
	// User_Friends adding a Follower To Table
	public void createFollower(User_Friends userFriend);
	
	// User_Friends deleting a Follower From Table
	public void unFollow(User_Friends userFriend);


	
	
	//User_Events Get Users Attending An Event
	public List<User_Events> getAttendingUsersList(int event_Id);
	
	//USer_Events Get Events User Is Attending
	public List<User_Events> getEventUserIsAttending(int user_Id);
	
	// User_Events adding an Attendee To An Event
	public void createAttendee(User_Events userEvent);
	
	// User_Events removing an Attendee From Table
	public void removeAttendee(User_Events userEvent);
}
