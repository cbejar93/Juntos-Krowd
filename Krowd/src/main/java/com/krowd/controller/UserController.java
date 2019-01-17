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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.krowd.beans.Users;
import com.krowd.service.UserService;

/*
 * Controller for the Users in the application.
 */
@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
//	Users u1 = new Users(200,"The","Greatest","ImTheMan","WhoAmI23@gmail.com",100,"ImBetterThanTheBest","BetterThanYou.url");
	
	/*
	 * This method grabs all users from the Users table in the database.
	 */
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Users>> getAllUsers(){
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	/*
	 * This method grabs all the Users by their Id. If there are no users by that Id,
	 * then the it returns with a HTTP status request of I am a teapot. If the users are
	 * returned successfully then it returns with a status of "ok". This method calls on
	 * the UserService to handle the grabbing of the users by Id. The url mapping must be
	 * "/{id}" for the method to be executed.
	 */
	@GetMapping(value="/{id}")
	@ResponseBody
	public ResponseEntity<Users> getUserById(@PathVariable int id){
		Users u = userService.getUserById(id);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value="/fid/{fId}")
	@ResponseBody
	public ResponseEntity<List<Users>> getUserByFID(@PathVariable String fId){
		List<Users> u = userService.getUserByFID(fId);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
	}
	
	/*
	 * This method is utilized in adding a user. If a user is successfully created then
	 * the user will be prompted "User Created", if not, there will be an exception thrown 
	 * that states the user must try again. The URL mapping must have "/add" at the end for the
	 * method to execute.
	 */
	@PostMapping(value="/add")
	@ResponseBody
	public ResponseEntity<String> addUser(@RequestBody Users user){
		ResponseEntity<String> resp = null;
		try {
			userService.addUser(user);
			System.out.println(user);
			resp = new ResponseEntity<>("User Created!", HttpStatus.OK);
			
			
		} catch (Exception e) {
			resp = new ResponseEntity<>("No User Created, Try Again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	/*
	 * This method updates a certain user. It requires the user to set his/her first and last name, 
	 * give a URL for there profile picture. This information will be stored in the database, and will
	 * be prompted to the user when it is successfully executed. If the user is not correctly updated, 
	 * then the user will be prompted with an exception to try again.
	 */
	@PutMapping(value="/update/{id}")
	@ResponseBody
	public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody Users user){
		ResponseEntity<String> resp = null;
		try {
			
			Users u = userService.getUserById(id);
			System.out.println("pre-switch " + u);
			u.setFirstname(user.getFirstname());
			u.setLastname(user.getLastname());
			u.setPhoto_url(user.getPhoto_url());
			
			userService.updateUsers(u);
			
			System.out.println(u);
			
			resp = new ResponseEntity<>("User Updated!", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("User Not Updated, Try Again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	
	
}
