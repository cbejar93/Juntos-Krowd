package com.krowd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krowd.beans.Events;
import com.krowd.beans.Users;
import com.krowd.dao.JunctionDAO;
import com.krowd.dao.JunctionDAOImpl;

@Service(value="junctionService")
public class JunctionServiceImpl implements JunctionService {

	private JunctionDAO jd = new JunctionDAOImpl();

	@Override
	public List<Users> getUserFollowingList(int user_Id) {
		
		return jd.getUserFollowingList(user_Id);
	}

	@Override
	public List<Users> getUserFollowerList(int user_Id) {
		// TODO Auto-generated method stub
		return jd.getUserFollowingList(user_Id);
	}

	@Override
	public void createFollower(Users userFriend) {
		jd.createFollower(userFriend);
	}

	@Override
	public void unFollow(Users userFriend) {
		jd.unFollow(userFriend);
	}

	@Override
	public List<Users> getAttendingUsersList(int event_Id) {
		
		return jd.getAttendingUsersList(event_Id);
	}

	@Override
	public List<Events> getEventUserIsAttending(int user_Id) {
		return jd.getEventUserIsAttending(user_Id);
	}

	@Override
	public void createAttendee(Users userEvent) {
		jd.createAttendee(userEvent);
	}

	@Override
	public void removeAttendee(Users userEvent) {
		jd.removeAttendee(userEvent);
	}

}
