package com.krowd.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.krowd.beans.Credentials;
import com.krowd.beans.Users;
import com.krowd.util.HibernateUtil;

public class AuthenticationServiceImpl implements AuthenticationService {
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	/*
	 * This is a an authentication method. We have taken in the username and password from the user,
	 * therefore we are going to check the system, to see if they are registered within our system
	 * as a user.(non-Javadoc)
	 * @see com.krowd.service.AuthenticationService#isValidUser(com.krowd.beans.Credentials)
	 */
	@Override
	public Users isValidUser(Credentials credentials) {
		Users user = null;
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		
		user = authenticateUsers(username, password);
		return user;
	}

	/*
	 * This is to take the credentials and actually checking the database.(non-Javadoc)
	 * @see com.krowd.service.AuthenticationService#authenticateUsers(java.lang.String, java.lang.String)
	 */
	@Override
	public Users authenticateUsers(String username, String password) {
		Users use = null;
		if (username.equals(use.getUsername()) && password.equals(use.getPassword())) {
			return new Users();
		} else {
			return null;
		}
			
	}

}
