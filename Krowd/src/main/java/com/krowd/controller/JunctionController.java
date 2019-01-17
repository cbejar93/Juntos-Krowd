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

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/junction")
public class JunctionController {


	@Autowired
	private JunctionService junctionService;
	
	@GetMapping(value="/{user_Id}/following")
	@ResponseBody
	public ResponseEntity<List<Users>> getUserFollowingList(int user_Id) {
		return new ResponseEntity<>(junctionService.getUserFollowingList(user_Id), HttpStatus.OK);
	}
	
	@GetMapping(value="/{user_Id}/followers")
	@ResponseBody
	public ResponseEntity<List<Users>> getUserFollowerList(int user_Id) {
		return new ResponseEntity<>(junctionService.getUserFollowerList(user_Id), HttpStatus.OK);
	}
	
	
	
	@GetMapping(value="/{event_Id}/attending")
	@ResponseBody
	public ResponseEntity<List<Users>> getAttendingUsersList(int event_Id) {
		return new ResponseEntity<>(junctionService.getAttendingUsersList(event_Id),HttpStatus.OK);
	}
	
	@GetMapping(value="/{user_Id}/attending")
	@ResponseBody
	public ResponseEntity<List<Events>> getEventUserIsAttendingList(int user_Id) {
		return new ResponseEntity<>(junctionService.getEventUserIsAttending(user_Id),HttpStatus.OK);
	}
}
