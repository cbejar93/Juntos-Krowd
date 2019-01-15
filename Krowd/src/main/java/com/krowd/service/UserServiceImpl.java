package com.krowd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krowd.beans.Users;
import com.krowd.dao.UserDAO;
import com.krowd.dao.UserDAOImpl;

@Service(value="userService")
public class UserServiceImpl implements UserService {

	private UserDAO ud = new UserDAOImpl();

	@Override
	public List<Users> getAllUsers() {
		return ud.getAllUsers();
	}

	@Override
	public void addUser(Users user) {
		ud.addUser(user);
	}

	@Override
	public void updateUsers(Users user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteUsers(Users user) {
		ud.deleteUsers(user);
	}

	@Override
	public Users getUserById(int id) {
		return ud.getUserById(id);
	}


//	@Override
//	public void updateFollow(Users user, Users user2) {
//		// TODO
//	}

}
