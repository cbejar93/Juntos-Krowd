package com.krowd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krowd.beans.Users;
import com.krowd.dao.UserDAO;
import com.krowd.dao.UserDAOImpl;

@Service(value = "userService")
/*
 * Service class that implements the methods from UserService interface.
 */
public class UserServiceImpl implements UserService {

	/*
	 * Creates an instance of the UserDAOImpl.
	 */
	private UserDAO ud = new UserDAOImpl();

	/*
	 * Method that gets all users. Makes a call to the UserDAOImpl method
	 * getAllUsers.(non-Javadoc)
	 * @see com.krowd.service.CommentService#getAllComments()
	 */
	@Override
	public List<Users> getAllUsers() {
		return ud.getAllUsers();
	}

	/*
	 * Method that will add users, by making a call to the UserDAOImpl method
	 * createUser.(non-Javadoc)
	 * @see com.krowd.service.CommentService#createComment(com.krowd.beans.Comments)
	 */
	@Override
	public void addUser(Users user) {
		ud.addUser(user);
	}

	/*
	 * Method that updates users. This also makes a call to the UserDAOImpl and the method,
	 * updateUser.(non-Javadoc)
	 * @see com.krowd.service.CommentService#updateComment(com.krowd.beans.Comments)
	 */
	@Override
	public void updateUsers(Users user) {
		ud.updateUsers(user);
	}

	/*
	 * This method deletes the users (non-Javadoc)
	 * @see com.krowd.service.CommentService#deleteComment(com.krowd.beans.Comments)
	 */
	@Override
	public void deleteUsers(Users user) {
		ud.deleteUsers(user);
	}

	/*
	 * This method gets users by a particular Id. It does this by making a call to the UserDAOImpl
	 * method getUserById.(non-Javadoc)
	 * @see com.krowd.service.CommentService#getCommentById(int)
	 */
	@Override
	public Users getUserById(int id) {
		return ud.getUserById(id);
	}

	/*
	 * This method gets users by a particular fId. It also makes a call to the UserDAOImpl method
	 * getUserByFID(non-Javadoc)
	 * @see com.krowd.service.UserService#getUserByFID(java.lang.String)
	 */
	@Override
	public List<Users> getUserByFID(String fID) {
		return ud.getUserByFID(fID);
	}

}
