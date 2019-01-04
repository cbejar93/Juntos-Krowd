package src.main.test

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;

public class KrowdTest {
	
	private static final EvaluationService evaluationService = new EvaluationService();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	/*********************************************************************
	 * MOKITO STUFF
	 *********************************************************************/
	
	// mock creation
	List mockedList = mock(List.class);

	// using mock object - it does not throw any "unexpected interaction" exception
	mockedList.add("one");
	mockedList.clear();

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
	
	/*********************************************************************
	 * COMMENTS
	 *********************************************************************/
	@Test
	public void testPostComment() {
        //  create mock
        MyClass test = mock(MyClass.class);

        // define return value for method getUniqueId()
        when(test.getUniqueId()).thenReturn(43);

        // use mock in test....
        assertEquals(test.getUniqueId(), 43);
	}
	
	@Test
	public void testDeleteComment() {
        Iterator<String> i= mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result= i.next()+" "+i.next();
        //assert
        assertEquals("Mockito rocks", result);
	}
	
	@Test
	public void testDownvoteComment() {
        Comparable<String> c= mock(Comparable.class);
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        //assert
        assertEquals(1, c.compareTo("Mockito"));
	}
	
	@Test
	public void testUpvoteComment() {
        Comparable<Integer> c= mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        //assert
        assertEquals(-1, c.compareTo(9));
	}	
	
	@Test
	public void testGoogleMapSearchEvent() {
        Comparable<Todo> c= mock(Comparable.class);
        when(c.compareTo(isA(Todo.class))).thenReturn(0);
        //assert
        assertEquals(0, c.compareTo(new Todo(1)));
	}
	
	@Test
	public void testEarnTokens() {
	}
	
	@Test
	public void testSpendTokens() {
	}
	
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
	@Test
	public void testUserRegister() {	
	}
	
	@Test
	public void testUserLogout() {	
	}
	
	@Test
	public void testUserLogin() {	
	}
	/*********************************************************************
	 * ADMIN
	 *********************************************************************/
	@Test
	public void testAdminDeleteComment() {	
	}
	
	@Test
	public void testAdminDeleteUser() {	
	}
	
	@Test
	public void testAdminDeleteEvent() {	
	}

	/*********************************************************************
	 * EVENTS
	 *********************************************************************/
	
	@Test
	public void testHostCreateEvent() {	
	}
	
	@Test
	public void testHostCustomizeEvent() {	
	}
	
	@Test
	public void testHostDeleteEvent() {	
	}
	
	@Test
	public void testHostSendEventInvitation() {	
	}
	
	@Test
	public void testHostUploadImage() {	
	}
	
	@Test
	public void testHostGoogleMapsToCreateEvent() {	
	}
	
	@Test
	public void testEventCharts() {	
	}

}
