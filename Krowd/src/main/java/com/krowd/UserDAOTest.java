package com.krowd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.krowd.beans.Users;
import com.krowd.dao.UserDAO;
import com.krowd.dao.UserDAOImpl;

/*
 * These are tests that will be applied to the methods of the UserDAO.  
 */

class UserDAOTest {

	private static UserDAO ud;
	private static Users u;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ud = new UserDAOImpl();
		u = new Users(1001, "Jane", "Doe", "jdoe", "jdoe123@gmail.com", 100, "password" , null);
		if (ud.getUserById(1001) != null) {
			ud.deleteUsers(u);
		}
	}

	@Test
	void testGetAllUsers() {
		assertNotNull(ud.getAllUsers());
	}

	@Test
	void testAddUser() {
		ud.addUser(u);
		assertEquals("jdoe", ud.getUserById(1001).getUsername());
		
	}

	@Test
	void testUpdateUsers() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteUsers() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUserById() {
		assertEquals("abodesson4x", ud.getUserById(632).getUsername());
	}

	@Test
	void testGetUsersByUserAndPass() {
		fail("Not yet implemented");
	}

}
