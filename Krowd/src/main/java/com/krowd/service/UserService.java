package com.krowd.service;

import java.util.List;

import com.krowd.beans.Users;
import com.krowd.dao.UserDAO;
import com.krowd.dao.UserDAOImpl;

public interface UserService {
	
	public List<Users> getAllUsers();
	public void addUser(Users user);
	public void updateUsers(Users user);
	public void deleteUsers(Users user);
	public Users getUserById(int id); 
	
//	public void updateFollow(Users user, Users user2);
}
