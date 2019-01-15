package com.krowd.dao;

import java.util.List;

import com.krowd.beans.Comments;

public interface CommentDAO {
	
	static List<Comments> getAllComments() {
		// TODO Auto-generated method stub
		return null;
	}
	public Comments getCommentById(int comment_Id);
	List<Comments> getCommentsByUserId(int user_Id);
	List<Comments> getCommentsByEventId(int event_Id);
	public void deleteComment(int comment_Id);
	public void updateComment(Comments comments);
	public void createComment(Comments comments);


}
