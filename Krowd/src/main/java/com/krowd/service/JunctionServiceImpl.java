package com.krowd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krowd.beans.User_Events;
import com.krowd.beans.User_Friends;
import com.krowd.dao.JunctionDAO;
import com.krowd.dao.JunctionDAOImpl;

@Service(value="junctionService")
public class JunctionServiceImpl implements JunctionService {

	private JunctionDAO jd = new JunctionDAOImpl();

	@Override
	public List<User_Friends> getUserFollowingList(int user_Id) {
		
		return jd.getUserFollowingList(user_Id);
	}

	@Override
	public List<User_Friends> getUserFollowerList(int user_Id) {
		// TODO Auto-generated method stub
		return jd.getUserFollowingList(user_Id);
	}

	@Override
	public void createFollower(User_Friends userFriend) {
		jd.createFollower(userFriend);
	}

	@Override
	public void unFollow(User_Friends userFriend) {
		jd.unFollow(userFriend);
	}

	@Override
	public List<User_Events> getAttendingUsersList(int event_Id) {
		
		return jd.getAttendingUsersList(event_Id);
	}

	@Override
	public List<User_Events> getEventUserIsAttending(int user_Id) {
		return jd.getEventUserIsAttending(user_Id);
	}

	@Override
	public void createAttendee(User_Events userEvent) {
		jd.createAttendee(userEvent);
	}

	@Override
	public void removeAttendee(User_Events userEvent) {
		jd.removeAttendee(userEvent);
	}

}
