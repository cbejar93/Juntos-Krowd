package com.krowd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.krowd.beans.Events;
import com.krowd.beans.Users;
import com.krowd.service.JunctionService;

/*
 * This class is a Controller for all the Junction tables. It has the proper methods
 * that will get Users following list as well as get a list for Users attending an
 * event.
 */
@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/junction")
public class JunctionController {


	/*
	 * This creates an junction service that is restrictive to this Controller.
	 */
	@Autowired
	private JunctionService junctionService;
	
	/*
	 * This method gets a list of the users that a particular User is following. The method
	 * intakes the User Id of the user, then returns a Following list by making a call to the
	 * junction service method, getUserFollowingList()
	 */
	@GetMapping(value="/{user_Id}/following")
	@ResponseBody
	public ResponseEntity<List<Users>> getUserFollowingList(int user_Id) {
		return new ResponseEntity<>(junctionService.getUserFollowingList(user_Id), HttpStatus.OK);
	}
	
	/*
	 * This method gets the followers list for a particular user by intaking the User Id and then 
	 * returning the list of followers.
	 */
	@GetMapping(value="/{user_Id}/followers")
	@ResponseBody
	public ResponseEntity<List<Users>> getUserFollowerList(int user_Id) {
		return new ResponseEntity<>(junctionService.getUserFollowerList(user_Id), HttpStatus.OK);
	}
	
	
	/*
	 * This method gets a list of all attending users to a certain event by the Event Id. 
	 */
	@GetMapping(value="/{event_Id}/attending")
	@ResponseBody
	public ResponseEntity<List<Users>> getAttendingUsersList(int event_Id) {
		return new ResponseEntity<>(junctionService.getAttendingUsersList(event_Id),HttpStatus.OK);
	}
	
	/*
	 * This method is getting the information pertaining to whether a certain User is attending a 
	 * certain event. The method is doing this by getting the User_Id. The HTTP status OK is returned
	 * with the response.
	 */
	@GetMapping(value="/{user_Id}/attending")
	@ResponseBody
	public ResponseEntity<List<Events>> getEventUserIsAttendingList(int user_Id) {
		return new ResponseEntity<>(junctionService.getEventUserIsAttending(user_Id),HttpStatus.OK);
	}
}
