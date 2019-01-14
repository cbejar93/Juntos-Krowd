package com.krowd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.krowd.beans.Users;
import com.krowd.service.AuthenticationServiceImpl;

@Controller
public class LoginController {
	
	@Autowired
	public LoginController(AuthenticationServiceImpl authService) {
		super();
		this.authService = authService;
		
	}
	
	
	private AuthenticationServiceImpl authService;
	
	@GetMapping(value = "/login")
	public String getLoginPage() {
		
		//Get the login page
		return "login.html";
	}
	
	//handle the form data sent to the login page
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public RedirectView handleFormRequest(@RequestBody MultiValueMap<String, String> formParams, RedirectAttributes attributes) {
		//to process the data entered into the form
		Users u = authService.authenticateUsers(formParams.getFirst("username"), formParams.getFirst("password"));
		if (u == null) {
			//Redirect to the error page
			return new RedirectView("error");
		} else {
			//Redirect to the profile page
			attributes.addFlashAttribute("user", u);
			return new RedirectView("profile");
		}
	}
	
	@GetMapping(value = "/error")
	public String getErrorPage() {
		return "error";
	}
	
	

}
