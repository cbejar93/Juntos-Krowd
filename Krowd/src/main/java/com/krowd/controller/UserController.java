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

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
//	Users u1 = new Users(200,"The","Greatest","ImTheMan","WhoAmI23@gmail.com",100,"ImBetterThanTheBest","BetterThanYou.url");
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Users>> getAllUsers(){
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
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
