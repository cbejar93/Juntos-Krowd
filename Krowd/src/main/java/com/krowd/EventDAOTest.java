package com.krowd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.krowd.dao.EventDAO;
import com.krowd.dao.EventDAOImpl;

class EventDAOTest {

	private static EventDAO ed;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		ed = new EventDAOImpl();
	}

	@Test
	public void validEvent() {
		assertEquals("Group Dog Walk", ed.getEventById(1).getEvent_name());
	}

	// Need to handle null pointers
	@Test
	public void invalidEvent() {
		assertEquals(null, ed.getEventById(400).getEvent_name());
	}

	@Test
	void testGetEventById() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteEvent() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateEvent() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateEvent() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllEvents() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEventByUserId() {
		fail("Not yet implemented");
	}

}

