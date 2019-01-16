package com.krowd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.krowd.dao.UserDAO;
import com.krowd.dao.UserDAOImpl;

class UserDAOTest {

	private static UserDAO ud;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ud = new UserDAOImpl();
	}

	@Test
	void testGetAllUsers() {
		fail("Not yet implemented");
	}

	@Test
	void testAddUser() {
		fail("Not yet implemented");
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
