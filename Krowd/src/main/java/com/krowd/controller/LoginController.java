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
import com.krowd.service.AuthenticationService;

@Controller
public class LoginController {

	@Autowired
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}
	
	private AuthenticationService authenticationService;
	
	@GetMapping(value = "/login")
	public String getLoginPage() {
		return "forward:../KrowdClient/src/app/home";
	}

	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public RedirectView handleFormRequest(@RequestBody MultiValueMap<String,String> formParams, RedirectAttributes attributes) {
		Users u = authenticationService.authenticateUsers(formParams.getFirst("username"), formParams.getFirst("password"));
		if (u == null){
			return new RedirectView("error");
		} else {
			attributes.addFlashAttribute("user", u);
			return new RedirectView("profile");
		}
	}
	
}
