package com.krowd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.krowd.beans.Users;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6035723100739982453L;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//grab current session, if it exits
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			try {
			int userid = Integer.parseInt(session.getAttribute("id").toString());
			String firstname =session.getAttribute("firstname").toString();
			String lastname = session.getAttribute("lastname").toString();
			String username = session.getAttribute("username").toString();
			String email = session.getAttribute("email").toString();
			int token_score = Integer.parseInt(session.getAttribute("tokenscore").toString());
			String password = session.getAttribute("password").toString();
			String photo_url = session.getAttribute("photo_url").toString();
			Users u = new Users( userid, firstname, lastname, username, email, token_score, password, photo_url);
			response.getWriter().write((new ObjectMapper()).writeValueAsString(u));
			} catch (Exception e ) {
				response.getWriter().write("{\"session\":null}");
			} 
		} else {
			response.getWriter().write("{\"session\":null}");
		}
	}

}
