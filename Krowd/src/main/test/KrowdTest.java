package src.main.test

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;

public class KrowdTest {
	
	private static final EvaluationService evaluationService = new EvaluationService();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	/*********************************************************************
	 * COMMENTS
	 *********************************************************************/
	@Test
	public void testPostComment() {
	}
	
	@Test
	public void testDeleteComment() {
	}
	
	@Test
	public void testDownvoteComment() {
	}
	
	@Test
	public void testUpvoteComment() {
	}
	
	@Test
	public void testUpvoteComment() {
	}
	
	@Test
	public void testGoogleMapSearchEvent() {
	}
	
	@Test
	public void testEarnTokens() {
	}
	
	@Test
	public void testSpendTokens() {
	}
	
	@Test
	public void testSendMessage() {
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
