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

import com.krowd.beans.Comments;
import com.krowd.beans.Events;
import com.krowd.beans.Users;
import com.krowd.service.CommentService;
import com.krowd.service.EventService;
import com.krowd.service.EventServiceImpl;

/*
 * The Controller that is for the Comments in the application. Contains many different
 * methods that will grab the comments and return them to the user in a list.
 */
@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
//	comments u1 = new comments(200,"The","Greatest","ImTheMan","WhoAmI23@gmail.com",100,"ImBetterThanTheBest","BetterThanYou.url");
	/*
	 * This method grabs ALL of the comments and simply returns them when the url
	 * has the mapping at end of it as "/all".
	 */
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Comments>> getAllcomments(){
		return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);
	}
	
	/*
	 * This method grabs the comments by the comment Id itself, and returns it to the user.
	 * This method also will send an HttpStatus of I am a TeaPot if there are no comments found
	 * under that specific id. The method is mapped by having the specific id at the end of the 
	 * url "/{id}".
	 */
	@GetMapping(value="/{id}")
	@ResponseBody
	public ResponseEntity<Comments> getcommentById(@PathVariable int id){
		Comments u = commentService.getCommentById(id);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
	}
	
	/*
	 * This method grabs all the comments by a specific UserId that is provided. The method
	 * enlists the help of the commentService and if it finds comments, it returns them in a list,
	 * if it does not, it will give the HttpStatus of I Am a Teapot. The method must be mapped
	 * with "/user/{id}" in order to be executed.
	 */
	@GetMapping(value="/user/{id}")
	@ResponseBody
	public ResponseEntity<List<Comments>> getcommentsByUserId(@PathVariable int id){
		List<Comments> u = commentService.getCommentsByUserId(id);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
	}
	
	/*
	 * This method grabs all comments by Event Id and it returns them to the user if there
	 * are comments present. If there are no comments to be returned, the user will be given
	 * a HttpStatus of I Am a Teapot.
	 */
	@GetMapping(value="/event/{id}")
	@ResponseBody
	public ResponseEntity<List<Comments>> getcommentsByEventId(@PathVariable int id){
		List<Comments> u = commentService.getCommentsByEventId(id);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
	}
	
	/*
	 * This method adds a comment to the application. The URL must end with "/add" in
	 * order for the method to be mapped and executed. If the comment is added successfully
	 * then a string response will let the user know it was successfully created. If it was
	 * not created successfully then the user will get a string stating the usre must try again
	 * and that it was a bad request.
	 */
	@PostMapping(value="/add/{id}")
  @ResponseBody
	public ResponseEntity<String> addcomment(@PathVariable int id, @RequestBody Comments comment){
		ResponseEntity<String> resp = null;
		System.out.println(comment);
		try {
			commentService.createComment(comment);
			resp = new ResponseEntity<>("", HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			resp = new ResponseEntity<>("No comment Created, Try Again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	/*
	 * This method allows a comment to be updated. The method must have the URL end with
	 * "/update" in order for the method to be executed. If the comment goes through and is
	 * updated properly, the HTTP status of "ok" will be returned to the user. If the updated comment
	 * does not go through, then an exception will be thrown to try again. The URL must end with
	 * "/update" to be mapped.
	 */
@PutMapping(value="/update/{id}")
@ResponseBody
	public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody Users user){
		ResponseEntity<String> resp = null;
		try {
			
			
			resp = new ResponseEntity<>("User Updated!", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("User Not Updated, Try Again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
}
