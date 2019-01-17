package com.krowd;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import com.krowd.dao.EventDAO;
import com.krowd.dao.EventDAOImpl;
import com.krowd.beans.Events;

class EventDAOTest {

	private static EventDAO ed;
	private static Events eb;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		ed = new EventDAOImpl();
		eb = new Events();
		eb = new Events(1001, "Book Club", "100 Wallaby Way", "A small, Tuesday night book club meeting with discussion.", "Art",
				null, 1, null, null, 20);
		if (ed.getEventById(1001) != null) {
			ed.deleteEvent(eb);
		}
	}
	
	@AfterEach void setUpAfterClass() throws Exception{
		if (ed.getEventById(1001) != null) {
			ed.deleteEvent(eb);
		}
		
		eb = new Events(1001, "Book Club", "100 Wallaby Way", "A small, Tuesday night book club meeting with discussion.", "Art",
				null, 1, null, null, 20);
	}
	

	@Test
	void testGetEventById() {
		assertEquals("Group Dog Walk", ed.getEventById(1).getEvent_name());
	}

	@Test
	void testDeleteEvent() {
		ed.createEvent(eb);
		ed.deleteEvent(eb);
		assertEquals(null,  ed.getEventById(1001));
	}

	@Test
	void testCreateEvent() {
		ed.createEvent(eb);
		assertEquals("Book Club", ed.getEventById(1001).getEvent_name());
	}
	
	@Test
	void testUpdateEvent() {
		ed.createEvent(eb);
		eb = new Events(1001, "Book Club (Weekly)", "100 Wallaby Way", "A small, Tuesday night book club meeting with discussion.", "Art",
				null, 1, null, null, 20);
		ed.updateEvent(eb);
		assertEquals("Book Club (Weekly)", ed.getEventById(1001).getEvent_name());
	}


	//Maybe change this
	@Test
	void testGetAllEvents() {
		assertNotNull(ed.getAllEvents());
	}

	@Test
	void testGetEventByUserId() {
		assertEquals("Casual Cycling", ed.getEventByUserId(16).get(0).getEvent_name());
	}

}

