package com.krowd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.krowd.beans.Events;
import com.krowd.service.EventService;

/*
 * This class is a Controller for the Events. This class includes methods that will grab events by
 * various parameters as well as updating and deleting events.
 */
@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/event")
public class EventController {
	@Autowired
	private EventService eventService;
	
//	Events u1 = new Events(200,"The","Greatest","ImTheMan","WhoAmI23@gmail.com",100,"ImBetterThanTheBest","BetterThanYou.url");
	
	/*
	 * This method grabs all events for the user.
	 */
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Events>> getAllEvents(){
		return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
	}
	
	/*
	 * This method grabs the events by the Event Id and puts them in a list to display
	 * to the user. If there are no events grabbed, then the user will be given an HTTP status
	 * of I Am a Teapot.
	 */
	@GetMapping(value="/{id}")
	@ResponseBody
	public ResponseEntity<Events> getEventById(@PathVariable int id){
		Events u = eventService.getEventById(id);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
	}
	
	/*
	 * This method grabs certain events by User Id. The events are put in a list and returned
	 * to the user if they are found. If there are no events found, the user is given an HTTP
	 * status of Not_Found.
	 */
	@GetMapping(value="/user/{userid}")
	@ResponseBody
	public ResponseEntity<List<Events>> getEventByUserId(@PathVariable int userid) {
		List<Events> u = eventService.getEventByUserId(userid);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
	}
	
	/*
	 * This method adds an event that is created by the user. If the event is created successfully
	 * then the user will be prompted of successful event creation. If the event is not created
	 * then the user will be prompted with an exception to try again. 
	 */
	@PostMapping(value="/add")
	@ResponseBody
	public ResponseEntity<String> createEvent(@RequestBody Events event){
		ResponseEntity<String> resp = null;
		System.out.println(event);
		try {
			eventService.createEvent(event);
			resp = new ResponseEntity<>("Event Created!", HttpStatus.OK);
			
		} catch (Exception e) {
			resp = new ResponseEntity<>("No Event Created, Try Again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	/*
	 * This method grants the user the ability to update an event. The method utilizes an try/catch to
	 * illustrate if an event is properly updated. If it is updated correctly, the user will be prompted
	 * of a successful updated event.If it is not updated, the user will be prompted to try again. The 
	 * method will execute when ending the URL with "/update"
	 */
	@PostMapping(value="/update")
	@ResponseBody
	public ResponseEntity<String> updateEvent(@RequestBody Events event){
		ResponseEntity<String> resp = null;
		try {
			eventService.updateEvents(event);
			resp = new ResponseEntity<>("Event Updated!", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("Event Not Updated, Try Again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	/*
	 * This method allows the user to delete an event. The method takes an event, and it will attempt to
	 * delete an event. If it is deleted successfully, then the user will be prompted of a successful
	 * deletion, and an HTTP status of "ok". If the comment was not deleted successfully, then the user
	 * will be prompted to try again, as well as given an HTTP status of bad request.
	 */
	@PostMapping(value="/delete")
	@ResponseBody
	public ResponseEntity<String> deleteEvent(@RequestBody Events event){
		ResponseEntity<String> resp = null;
		try {
			eventService.deleteEvents(event);
			resp = new ResponseEntity<>("Event Deleted!", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("Event Not Deleted, Try Again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	
	
	
	
}
