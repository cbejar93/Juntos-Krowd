package com.krowd.dao;

import java.util.List;

import com.krowd.beans.Users;

public interface UserDAO {

	//Success
	public List<Users> getAllUsers();
	
	public void addUser(Users user);

	public void updateUsers(Users user);
	public void deleteUsers(Users user);
	

	public Users getUserById(int id); 

	public List<Users> getUserByFID(String fID);
	
	public List<Users> getUsersByUserAndPass(String username, String password);
	
//	public void updateFollow(Users user, Users user2);
}
