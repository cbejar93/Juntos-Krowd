package com.krowd.revature;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.krowd.beans.Comments;
import com.krowd.beans.Events;
import com.krowd.beans.Users;
import com.krowd.dao.CommentDAO;
import com.krowd.dao.CommentDAOImpl;
import com.krowd.dao.EventDAO;
import com.krowd.dao.EventDAOImpl;
import com.krowd.dao.UserDAO;
import com.krowd.dao.UserDAOImpl;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("deprecation")
public class UserDAOImplTest {
	@InjectMocks
UserDAOImpl userdaoi;
@InjectMocks
CommentDAOImpl commentdaoi;
@InjectMocks
EventDAOImpl moviedaoi;
@Mock
CommentDAO reviewdao;
@Mock
UserDAO userdao;
@Mock
EventDAO eventdao;
@Mock
CommentDAO commentdao;
@Mock
private SessionFactory hibernateSessionFactory;
@Mock
Users users;
@Mock
Comments comm;
@Mock
Events events;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetAllUsers() {
		List<Users> uList = new ArrayList<>();
		uList = UserDAO.getAllUsers();
		assertEquals(666, uList.get(4).getUserid());
	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserById() {
		fail("Not yet implemented");
	}

}
