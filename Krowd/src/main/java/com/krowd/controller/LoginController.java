package com.krowd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krowd.beans.Credentials;
import com.krowd.beans.Users;
import com.krowd.service.AuthenticationService;
import com.krowd.service.AuthenticationServiceImpl;

@RestController
@RequestMapping (value="/login")
public class LoginController {

	@Autowired
	public LoginController(AuthenticationServiceImpl authService) {
		super();
		this.authService = authService;

	}

	private AuthenticationService authService;

	// handle the form data sent to the login page
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value ="/sent")
	public ResponseEntity<Users> handleFormRequest(@RequestBody Credentials creds, HttpServletRequest req)
	{	
		System.out.println(creds);
		
		HttpSession session = req.getSession();
		
		Users u = authService.authenticateUsers(creds);
		System.out.println("Here");
		if (u == null) {

			System.out.println("for the night");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			System.out.println("for the Weekend");
			
			session.setAttribute("User_Id", u.getUserid());
			session.setAttribute("firstname", u.getFirstname());
			session.setAttribute("lastname", u.getLastname());
			session.setAttribute("username", u.getUsername());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("token_score", u.getToken_score());
			session.setAttribute("password", u.getPassword());
			session.setAttribute("photo_url", u.getPhoto_url());
			
			session.setAttribute("problem", null);
			
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
	}

	
}
