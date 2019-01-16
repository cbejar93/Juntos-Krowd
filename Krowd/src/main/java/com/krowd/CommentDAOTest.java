package com.krowd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.krowd.dao.CommentDAO;
import com.krowd.dao.CommentDAOImpl;

class CommentDAOTest {

	private static CommentDAO cd;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cd = new CommentDAOImpl();
	}

	@Test
	void testDeleteComment() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateComment() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateComment() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCommentById() {
		assertEquals("Krowd always hosting the best events", cd.getCommentById(8).getData());
	}

	@Test
	void testGetAllComments() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCommentsByUserId() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCommentsByEventId() {
		fail("Not yet implemented");
	}

}
