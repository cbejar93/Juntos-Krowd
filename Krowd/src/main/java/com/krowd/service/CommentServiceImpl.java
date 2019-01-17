package com.krowd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krowd.beans.Comments;
import com.krowd.dao.CommentDAO;
import com.krowd.dao.CommentDAOImpl;

/*
 * Service class that implements the methods from CommentService interface.
 */
@Service(value="commentService")
public class CommentServiceImpl implements CommentService {

	/*
	 * Creates an instance of the CommentDAOImpl.
	 */
	private CommentDAO ud = new CommentDAOImpl();

	/*
	 * Method that gets all comments. Makes a call to the CommentDAOImpl method
	 * getAllComments.(non-Javadoc)
	 * @see com.krowd.service.CommentService#getAllComments()
	 */
	@Override
	public List<Comments> getAllComments() {
		return ud.getAllComments();
	}

	/*
	 * Method that will create comments, by making a call to the CommentDAOImpl method
	 * createComment.(non-Javadoc)
	 * @see com.krowd.service.CommentService#createComment(com.krowd.beans.Comments)
	 */
	@Override
	public void createComment(Comments comment) {
		System.out.println(comment);
		ud.createComment(comment);
	}

	/*
	 * Method that updates comments. This also makes a call to the CommentDAOImpl and the method,
	 * updateComment.(non-Javadoc)
	 * @see com.krowd.service.CommentService#updateComment(com.krowd.beans.Comments)
	 */
	@Override
	public void updateComment(Comments comment) {
		ud.updateComment(comment);
	}

	/*
	 * This method deletes the comments (non-Javadoc)
	 * @see com.krowd.service.CommentService#deleteComment(com.krowd.beans.Comments)
	 */
	@Override
	public void deleteComment(Comments comments) {
		ud.deleteComment(comments);
	}

	/*
	 * This method gets comments by a particular Id. It does this by making a call to the CommentDAOImpl
	 * method getCommentById.(non-Javadoc)
	 * @see com.krowd.service.CommentService#getCommentById(int)
	 */
	@Override
	public Comments getCommentById(int id) {
		return ud.getCommentById(id);
	}

	/*
	 * This method gets comments by a particular UserId. It makes a call to the CommentDOAImpl method
	 * getCommentsByUserId.(non-Javadoc)
	 * @see com.krowd.service.CommentService#getCommentsByUserId(int)
	 */
	@Override
	public List<Comments> getCommentsByUserId(int user_Id) {
		
		return ud.getCommentsByUserId(user_Id);
	}

	/*
	 * This method gets comments by a particular Event Id. It makes a call to the CommentsDAOImpl method
	 * getCommentsByEventId, and returns a list of those comments.(non-Javadoc)
	 * @see com.krowd.service.CommentService#getCommentsByEventId(int)
	 */
	@Override
	public List<Comments> getCommentsByEventId(int event_Id) {
		return ud.getCommentsByEventId(event_Id);
	}


}
