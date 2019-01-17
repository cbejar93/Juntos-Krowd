package com.krowd.service;

import com.krowd.beans.Credentials;
import com.krowd.beans.Users;

/*
 * Interface for the AuthenticationService.
 */
public interface AuthenticationService {
	
	public Users isValidUser(Credentials credentials);
	
	public Users authenticateUsers(Credentials creds);
	

}
