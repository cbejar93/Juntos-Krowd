package com.krowd.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.krowd.beans.Comments;
import com.krowd.util.HibernateUtil;

/*
 * Interface that implements the CommentDAO methods.
 */
public class CommentDAOImpl implements CommentDAO {
	
	/*
	 * This creates a session factory for the methods to be able to execute.
	 */
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	
	/*
	 * This method deletes comments that are made.(non-Javadoc)
	 * @see com.krowd.dao.CommentDAO#deleteComment(com.krowd.beans.Comments)
	 */
	@Override
	public void deleteComment(Comments comments) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(comments);
			tx.commit();
			s.close();
		}
		
	}

	/*
	 * This method updates the comments (non-Javadoc)
	 * @see com.krowd.dao.CommentDAO#updateComment(com.krowd.beans.Comments)
	 */
	@Override
	public void updateComment(Comments comments) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(comments);
			tx.commit();
			s.close();
		}
		
	}

	/*
	 * This method creates comments.(non-Javadoc)
	 * @see com.krowd.dao.CommentDAO#createComment(com.krowd.beans.Comments)
	 */
	@Override
	public void createComment(Comments comments) {
		System.out.println(comments);
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(comments);
			tx.commit();
			s.close();
		}
		
	}
	
	/*
	 * This method grabs certain comments by a particular Comment Id.(non-Javadoc)
	 * @see com.krowd.dao.CommentDAO#getCommentById(int)
	 */
	@Override
	public Comments getCommentById(int comment_Id) {
		Comments comt = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			comt = (Comments) s.get(Comments.class, comment_Id);
			tx.commit();
			s.close();
		}
		return comt;
	}
	
	/*
	 * This method simply gets all comments.(non-Javadoc)
	 * @see com.krowd.dao.CommentDAO#getAllComments()
	 */
	@Override
	public List<Comments> getAllComments() {
		List<Comments> comments = new ArrayList<>();
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			comments = s.createQuery("from Comments").getResultList();
			tx.commit();
			s.close();
		}
		return comments;
	}

	/*
	 * This method gets comments by a UserId. The method will create a query to where
	 * the Comments that are made only by that particular User Id will display.(non-Javadoc)
	 * @see com.krowd.dao.CommentDAO#getCommentsByUserId(int)
	 */

	@Override
	public List<Comments> getCommentsByUserId(int user_Id) {
		List<Comments> comments = new ArrayList<>();
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			comments = s.createQuery("from Comments where USER_ID = " + user_Id).getResultList();
			tx.commit();
			s.close();
		}
		return comments;
		
	}

	/*
	 * This method grabs comments by a certain event. The way this happens, is that the 
	 * comments are grabbed by a certain Event Id.(non-Javadoc)
	 * @see com.krowd.dao.CommentDAO#getCommentsByEventId(int)
	 */
	@Override
	public List<Comments> getCommentsByEventId(int event_Id) {
		List<Comments> comments = new ArrayList<>();
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			comments =s.createQuery("from Comments where EVENT_ID = " + event_Id).getResultList();
			tx.commit();
			s.close();
		}
		return comments;

	}
}
