package com.krowd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krowd.beans.Comments;
import com.krowd.dao.CommentDAO;
import com.krowd.dao.CommentDAOImpl;

@Service(value="commentService")
public class CommentServiceImpl implements CommentService {

	private CommentDAO ud = new CommentDAOImpl();

	@Override
	public List<Comments> getAllComments() {
		return ud.getAllComments();
	}

	@Override
	public void createComment(Comments comment) {
		ud.createComment(comment);
	}

	@Override
	public void updateComment(Comments comment) {
		ud.updateComment(comment);
	}

	@Override
	public void deleteComment(Comments comments) {
		ud.deleteComment(comments);
	}

	@Override
	public Comments getCommentById(int id) {
		return ud.getCommentById(id);
	}

	@Override
	public List<Comments> getCommentsByUserId(int user_Id) {
		
		return ud.getCommentsByUserId(user_Id);
	}

	@Override
	public List<Comments> getCommentsByEventId(int event_Id) {
		return ud.getCommentsByEventId(event_Id);
	}


}
