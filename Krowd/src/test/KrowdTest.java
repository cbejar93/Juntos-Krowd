package src.main.test

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import beans.Comments;
import beans.Events;
import beans.Users;
import dao.CommentDAO;
import dao.CommentDAOImpl;
import dao.EventDAO;
import dao.EventDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import util.HibernateUtil;

@RunWith(MockitoJUnitRunner.class
public class KrowdTest {


	// using mock object - it does not throw any "unexpected interaction" exception
	mockedList.add("one");mockedList.clear();

	// selective, explicit, highly readable verification
	verify(mockedList).add("one");
	verify(mockedList).clear();
	
	// you can mock concrete classes, not only interfaces
	LinkedList mockedList = mock(LinkedList.class);

	// stubbing appears before the actual execution
	when(mockedList.get(0)).thenReturn("first");

	// the following prints "first"
	System.out.println(mockedList.get(0));

	// the following prints "null" because get(999) was not stubbed
	System.out.println(mockedList.get(999));
	
	@RunWith(MockitoJUnitRunner.class)
	public class NebjaTest {
		@InjectMocks
	UserDAOImpl userdaoi;
	@Mock
	UserDAO userdao;
	@Mock
	private SessionFactory hibernateSessionFactory;
	@Mock
	User us;



	@Test
	public void testTheThing() throws Exception{
		Session session = Mockito.mock(Session.class);
		List<User> us = new ArrayList<>();
		Mockito.lenient().when(hibernateSessionFactory.getCurrentSession()).thenReturn(session);
		Mockito.lenient().when(userdao.getAllUsers()).thenReturn(us);
		 	
	}
	}

	/*********************************************************************
	 * COMMENTS
	 *********************************************************************/
	
	/*
	 * We're taking in these values
	 * 	comment_id
		data
		event
		Created
		user_id
	 */
	@Test
	public void testPostComment() {
		StringHelper helper = new StringHelper();
		//helper.truncate
		// create mock
		MyClass test = mock(MyClass.class);

		// define return value for method getUniqueId()
		when(test.getUniqueId()).thenReturn(43);

		// use mock in test....
		assertEquals(test.getUniqueId(), 43);
	}

	/*
	 * This tests whether the user can delete a comment they've posted.
	 */

	@Test
	public void testDeleteComment() {
		Iterator<String> i = mock(Iterator.class);
		when(i.next()).thenReturn("Mockito").thenReturn("rocks");
		String result = i.next() + " " + i.next();
		// assert
		assertEquals(156, "THIS EVENT SUCKS, YOU'RE ALL NOOBS", "Gameathon", 12-31-18, 666);
	}

	/*
	 * This test ensures that a user can downvote a comment that another user has
	 * posted.
	 */

	@Test
	public void testDownvoteComment() {
		Comparable<String> c = mock(Comparable.class);
		when(c.compareTo("Mockito")).thenReturn(1);
		when(c.compareTo("Eclipse")).thenReturn(2);
		// assert
		assertEquals(156, "THIS EVENT SUCKS, YOU'RE ALL NOOBS", "Gameathon", 12-31-18, 666);
	}

	/*
	 * This test ensures that a user can upvote a comment that another user has
	 * posted.
	 */

	@Test
	public void testUpvoteComment() {
		Comparable<Integer> c = mock(Comparable.class);
		when(c.compareTo(anyInt())).thenReturn(-1);
		// assert
		assertEquals(156, "THIS EVENT SUCKS, YOU'RE ALL NOOBS", "Gameathon", 12-31-18, 666);
	}

	/*
	 * This test ensures that events are posted to google maps and are searchable to
	 * registered users.
	 */

	@Test
	public void testGoogleMapSearchEvent() {
		Comparable<Todo> c = mock(Comparable.class);
		when(c.compareTo(isA(Todo.class))).thenReturn(0);
		// assert
		assertEquals(0, c.compareTo(156, "THIS EVENT SUCKS, YOU'RE ALL NOOBS", "Gameathon", 12-31-18, 666(1)));
	}

	/*
	 * This test ensures that users can generate and earn tokens.
	 */

	@Test
	public void testEarnTokens() {
		EarnTokenService eartokser = new EarnTokenService();
		userInfo uinfo = new userInfo("p@revature.com", "pokeballssuck666");
		User u = new User(25, "pikachu@revature.com", "pokeballssuck666", "Pikachu", "Ketchum", 6664202019, "false");
		assertEquals(u.auth.isUserValid(uinfo));
	}

	/*
	 * This test ensures that earned tokens can be spent.
	 */

	@Test
	public void testSpendTokens() {
		SpendTokenService spetokser = new SpendTokenService();
		userInfo uinfo = new userInfo("p@revature.com", "pokeballssuck666");
		User u = new User(25, "pikachu@revature.com", "pokeballssuck666", "Pikachu", "Ketchum", 6664202019, "false");
		assertEquals(u.auth.isUserValid(uinfo));
	}

	/*
	 * This test ensures that users can send private messages to one another.
	 */

	@Test
	public void testSendMessage() {
		verify(test, never()).sendMessage("never called");
		verify(test, atLeastOnce()).sendMessage("called at least once");
		verify(test, atLeast(2)).sendMessage("called at least twice");
		verify(test, times(5)).sendMessage("called five times");
		verify(test, atMost(3)).sendMessage("called at most 3 times");
	}

	/*********************************************************************
	 * USERS
	 *********************************************************************/

	/*
	 * We're taking in these values
	 * userid; firstname; lastname; username; email; token_score; password;
	 * photo_id;
	 */

	/*
	 * This test returns a list of all of the users.
	 */
	@Test
	public void testGetAllUsers() {
		List<Users> uList = new ArrayList<>();
		uList = userDao.getallUsers();
		assertEquals(666, uList.get(4).getId());
	}

	@Test
	public void testGetUserById() {
		User thisUser = new User(25, "Pikachu", "Ketchum", "pikapower", "pikachu@revature.com", 500, "pokeballssuck666",
				6664202019);
		assertTrue(thisUser.equals(UserDao.getUserbyID(25)));
	}
	
	//This test verifies that users can be returned based on their id

	@Test
	public void testIncorrectUserEmail() {
		userInfo uinfo = new userInfo("p@revature.com", "pokeballssuck666");
		User u = new User(25, "Pikachu", "Ketchum", "pikapower", "pikachu@revature.com", 500, "pokeballssuck666",
				6664202019);
		assertFalse(u.equals(auth.isValidUser(uinfo)));
	}
	
	//This test tries to submit bogus info to the backend

	@Test
	public void testNullUserInfo() {
		userInfo uinfo = new userInfo(null, null);
		User u = new User(25, "Pikachu", "Ketchum", "pikapower", "pikachu@revature.com", 500, "pokeballssuck666",
				6664202019);
		assertFalse(u.equals(auth.isUserValid(uinfo)));
	}
	
	//This test verifies that the user is actually a real user

	@Test
	public void testVerifyRealUser() {
		AuthenticationService auth = new AuthenticationService();
		userInfo uinfo = new userInfo("p@revature.com", "pokeballssuck666");
		User u = new User(25, "Pikachu", "Ketchum", "pikapower", "pikachu@revature.com", 500, "pokeballssuck666",
				6664202019);
		assertEquals(u.auth.isUserValid(uinfo));
	}

	//This test attempts to sign a demo user, Pikachu, up for Krowd
	
	@Test
	public void testUserRegister() {
		RegistrationService regis = new RegistrationService();
		userInfo uinfo = new userInfo("pikachu@revature.com", "pokeballssuck666");
		User u = new User(25, "Pikachu", "Ketchum", "pikapower", "pikachu@revature.com", 500, "pokeballssuck666",
				6664202019);
		assertEquals(u.auth.isUserValid(uinfo));
	}

	/*********************************************************************
	 * ADMIN
	 *********************************************************************/
	
	//This test returns a list of all of Krowd's admins
	
	@Test
	public void getAllAdmins() {
		List<Admins> aList = new ArrayList<>();
		aList = adminDao.getAllAdmins();
		assertEquals(18, aList.get(69).getAdmin_ID());
	}
	
	//This test returns an admin based on their ID

	@Test
	public void testGetAdminById() {
		User thisAdmin = new Admin(6, "charizard@revature.com,", "flamethrower69", "Charizard", "Emberscale",
				6669991337, "false");
		assertTrue(thisAdmin.equals(AdminDao.getAdminbyID(6)));
	}
	
	//This test attempts to log in as an admin and delete a comment

	@Test
	public void testAdminDeleteComment() {
		DeleteCommentService delcomser = new DeleteCommentService();
		adminInfo ainfo = new adminInfo("charizard@revature.com", "flamethrower69");
		Admin a = new Admin(6, "charizard@revature.com,", "flamethrower69", "Charizard", "Emberscale", 6669991337,
				"false");
		assertEquals(a.ath.isAdminValid(ainfo));
	}
	
	//

	@Test
	public void testAdminDeleteUser() {
		DeleteUserService deluserser = new DeleteCommentService();
		adminInfo ainfo = new adminInfo("charizard@revature.com", "flamethrower69");
		Admin a = new Admin(6, "charizard@revature.com,", "flamethrower69", "Charizard", "Emberscale", 6669991337,
				"false");
		assertEquals(a.auth.isAdminValid(ainfo));
	}

	@Test
	public void testAdminDeleteEvent() {
		DeleteEventService deleveser = new DeleteCommentService();
		adminInfo ainfo = new adminInfo("charizard@revature.com", "flamethrower69");
		Admin a = new Admin(6, "charizard@revature.com,", "flamethrower69", "Charizard", "Emberscale", 6669991337,
				"false");
		assertEquals(a.auth.isAdminValid(ainfo));
	}

	/*********************************************************************
	 * EVENTS
	 *********************************************************************/
	/*
	 * event_id event_name event_location event_description event_type event_date
	 * user_id photo_id created
	 */
	@Test
	public void getAllEvents() {
		List<Events> eList = new ArrayList<>();
		eList = eventsDao.getAllEvents();
		assertEquals(18, eList.get(69).getEvent_ID());
	}

	@Test
	public void testGetEventById() {
		Event thisEvent = new Event();
		assertEvent(thisEvent.equals(EventDao.getEventbyID(666)));
	}

	@Test
	public void testGetHost() {
		GetHostService gehoser = new GetHostService
		hostInfo hinfo = new hostInfo(7);
		Host h = new Host(7, "squirtle@revature.com", "bubblebeam420", "Squirtle", "Aquaring", 7776662020, "false");
		assertEquals(h.auth.isHostValid(hinfo));
	}

	@Test
	public void testHostCreateEvent() {
		CreateEventService creeveser = new CreateEventService();
		eventInfo einfo = new eventInfo(666);
		Event e = new Event(666, "Pokemon Battle", "Viridian City", "Squirtle versus Pikachu", "Battle", 2-5-2018:2100, 7, 9034934300, 1-3-2018:1043);
		hostInfo hinfo = new hostInfo(7);
		Host h = new Host(7);
		assertEquals(h.auth.isHostValid(hinfo));
	}

	@Test
	public void testHostCustomizeEvent() {
		CustomizeEventService cuseveser = new CustomizeEventService();
		eventInfo einfo = new eventInfo(666);
		Event e = new Event(666, "Pokemon Battle", "Viridian City", "Squirtle versus Pikachu", "Battle", 2-5-2018:2100, 7, 9034934300, 1-3-2018:1043);
		hostInfo hinfo = new hostInfo(7);
		Host h = new Host(7);
		assertEquals(h.auth.isHostValid(hinfo));
	}

	@Test
	public void testHostDeleteEvent() {
		DeleteEventService deleveser = new DeleteEventService();
		eventInfo einfo = new eventInfo(666);
		Event e = new Event(666, "Pokemon Battle", "Viridian City", "Squirtle versus Pikachu", "Battle", 2-5-2018:2100, 7, 9034934300, 1-3-2018:1043);
		hostInfo hinfo = new hostInfo(7);
		Host h = new Host(7);
		assertEquals(h.auth.isHostValid(hinfo));
	}

	@Test
	public void testHostSendEventInvitation() {
		SendEventInvitationService seneveinvser = new SendEventInvitationService();
		eventInfo einfo = new eventInfo(666);
		Event e = new Event(666, "Pokemon Battle", "Viridian City", "Squirtle versus Pikachu", "Battle", 2-5-2018:2100, 7, 9034934300, 1-3-2018:1043);
		hostInfo hinfo = new hostInfo(7);
		Host h = new Host(7);
		assertEquals(h.auth.isHostValid(hinfo));
	}

	/*
	 * This test makes sure an event host can upload an image for the event.
	 */

	@Test
	public void testHostUploadImage() {
		HostUploadImageService hosuplimaser = new HostUploadImageService();
		eventInfo einfo = new eventInfo(666);
		Event e = new Event(666, "Pokemon Battle", "Viridian City", "Squirtle versus Pikachu", "Battle", 2-5-2018:2100, 7, 9034934300, 1-3-2018:1043);
		hostInfo hinfo = new hostInfo(7);
		Host h = new Host(7);
		assertEquals(h.auth.isHostValid(hinfo));
	}

	/*
	 * This tests the event host's ability to successfully create an event via
	 * Google Maps.
	 */

	@Test
	public void testHostGmapsCreateEvent() {
		HostGmapsCreateEventService hosgmacreeveser = new HostGmapsCreateEventService();
		eventInfo einfo = new eventInfo(666);
		Event e = new Event(666, "Pokemon Battle", "Viridian City", "Squirtle versus Pikachu", "Battle", 2-5-2018:2100, 7, 9034934300, 1-3-2018:1043);
		hostInfo hinfo = new hostInfo(7);
		Host h = new Host(7);
		assertEquals(h.auth.isHostValid(hinfo));
	}

	/*
	 * The event charts are a personalized feed that are dynamically generated for
	 * each user. This test ensures the functionality of the generation of the
	 * charts.
	 */

	@Test
	public void testEventCharts() {
		EventChartsService evechaser = new EventChartsService();
		eventInfo einfo = new eventInfo(666);
		Event e = new Event(666, "Pokemon Battle", "Viridian City", "Squirtle versus Pikachu", "Battle", 2-5-2018:2100, 7, 9034934300, 1-3-2018:1043);
		hostInfo hinfo = new hostInfo(7);
		Host h = new Host(7);
		assertEquals(h.auth.isHostValid(hinfo));
	}

	/*********************************************************************
	 * CREDENTIALS
	 *********************************************************************/
	
	/*
	 * username
	 * password
	 */
	
	@Test
	public void testUserLogout() {
		LogoutService logoserv = new LogoutService();
		userInfo uinfo = new userInfo("pikachu@revature.com", "pokeballssuck666");
		User u = new User(25, "Pikachu", "Ketchum", "pikapower", "pikachu@revature.com", 500, "pokeballssuck666",
				6664202019);
		assertEquals(u.auth.isUserValid(uinfo));
	}

	@Test
	public void testUserLogin() {
		LoginService logiserv = new LoginService();
		userInfo uinfo = new userInfo("pikachu@revature.com", "pokeballssuck666");
		User u = new User(25, "Pikachu", "Ketchum", "pikapower", "pikachu@revature.com", 500, "pokeballssuck666",
				6664202019);
		assertEquals(u.auth.isUserValid(uinfo));
	}
	
	@Test
	public void testIncorrectUserPassword() {
		userInfo uinfo = new userInfo("pikachu@revature.com", "y");
		User u = new User(25, "Pikachu", "Ketchum", "pikapower", "pikachu@revature.com", 500, "pokeballssuck666",
				6664202019);
		assertFalse(u.equals(auth.isUserValid(uinfo)));
	}
	
}
