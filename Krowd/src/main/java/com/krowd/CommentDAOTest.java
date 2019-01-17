package com.krowd;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.krowd.beans.Comments;
import com.krowd.dao.CommentDAO;
import com.krowd.dao.CommentDAOImpl;

class CommentDAOTest {

	private static CommentDAO cd;
	private static Comments c;
	private static Comments nc;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cd = new CommentDAOImpl();
		c = new Comments(1001, "Here is a test comment", null, null, 632);
	}
	
	@AfterEach void setUpAfterClass() throws Exception{
		if (cd.getCommentById(1001) != null) {
			cd.deleteComment(c);
		}
	}

	@Test
	void testDeleteComment() {
		cd.deleteComment(c);
		assertNull(cd.getCommentById(1001));
	}

	@Test
	void testUpdateComment() {
		cd.createComment(c);
		nc = new Comments(1001, "Updated", null, null, 632);
		cd.updateComment(nc);
		assertEquals("Updated", cd.getCommentById(1001).getData());
		
	}

	@Test
	void testCreateComment() {
		cd.createComment(c);
		assertEquals("Here is a test comment", cd.getCommentById(1001).getData());
	}

	@Test
	void testGetCommentById() {
		assertEquals("Krowd always hosting the best events", cd.getCommentById(8).getData());
	}

	@Test
	void testGetAllComments() {
		assertNotNull(cd.getAllComments());
	}

	@Test
	void testGetCommentsByUserId() {
		assertEquals("Best Event Ever", cd.getCommentsByUserId(16).get(1).getData());
	}

	@Test
	void testGetCommentsByEventId() {
		assertNotNull(cd.getCommentsByEventId(1));
	}

}
