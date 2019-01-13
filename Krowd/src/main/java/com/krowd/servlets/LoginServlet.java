package com.krowd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.krowd.beans.Credentials;
import com.krowd.beans.Users;
import com.krowd.service.AuthenticationServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	AuthenticationServiceImpl authServImp = new AuthenticationServiceImpl();
	
	//Return the Login page for the Get request that is sent
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	//Handling of the Post request from the Forms from the login
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		 
		resp.setContentType("text/html");
		//grab params from request 
		Credentials cred = new Credentials(req.getParameter("username"),req.getParameter("password"));
		//attempt to authenticate the user
		Users u = authServImp.isValidUser(cred);
		//set user information as session attributes
		if (u != null) {
			session.setAttribute("userid", u.getUserid());
			session.setAttribute("firstname", u.getFirstname());
			session.setAttribute("lastname", u.getLastname());
			session.setAttribute("username", u.getUsername());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("token_score", u.getToken_score());
			session.setAttribute("password", u.getPassword());
			session.setAttribute("photo_url", u.getPhoto_url());
			//redirect user to profile page if authenticated
			resp.sendRedirect("profile");
		} else {
			session.setAttribute("problem", "invalid credentials");
			//redirect user to login page if authentication fails
			resp.sendRedirect("login");
		}
		
	  }


	}

