package com.krowd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krowd.beans.Credentials;
import com.krowd.beans.Users;
import com.krowd.dao.UserDAO;
import com.krowd.dao.UserDAOImpl;

/*
 * Class that implements the methods from AuthenticationService.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private UserService userService;
	/*
	 * This is a an authentication method. We have taken in the username and
	 * password from the user, therefore we are going to check the system, to see if
	 * they are registered within our system as a user.(non-Javadoc)
	 * 
	 * @see com.krowd.service.AuthenticationService#isValidUser(com.krowd.beans.
	 * Credentials)
	 */

	@Override
	public Users isValidUser(Credentials credentials) {
		Users user = null;
		String username = credentials.getUsername();
		String password = credentials.getPassword();

		user = authenticateUsers(credentials);
		return user;
	}

	/*
	 * This is to take the credentials and actually checking the
	 * database.(non-Javadoc)
	 * 
	 * @see
	 * com.krowd.service.AuthenticationService#authenticateUsers(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Users authenticateUsers(Credentials creds) {

		UserDAO ud = new UserDAOImpl();
		List<Users> list = null;
		Users u = null;
		System.out.println(creds);
	
		
		try {	
//			list = ud.getUsersByUserAndPass(creds.getUsername(), creds.getPassword());
			list = ud.getAllUsers();
			for(Users u2 : list) {
				System.out.println(u2);
				if (u2.getUsername().equals(creds.getUsername() )&& u2.getPassword().equals(creds.getPassword())) {

					System.out.println("GOTCHA BETCH!");
					
					u = u2;
					return u;
				}
			}
		}	catch (Exception e) {
			System.out.println("Invalid Username & Password");
		}
		return null;

	}

}
