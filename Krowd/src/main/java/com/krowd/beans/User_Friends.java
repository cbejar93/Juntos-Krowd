package com.krowd.beans;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "USER_FRIENDS")
public class User_Friends {

	public User_Friends() {
		super();
	}
	
	public User_Friends(int userid, int following_user_id) {
		super();
		this.userid = userid;
		this.following_user_id = following_user_id;
	}
	
	@Id
	@JoinColumn(name="USER_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private int userid;
	@JoinColumn(name="FOLLOWING_USER_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private int following_user_id;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getFollowing_user_id() {
		return following_user_id;
	}
	public void setFollowing_user_id(int following_user_id) {
		this.following_user_id = following_user_id;
	}
	@Override
	public String toString() {
		return "User_Friends [userid=" + userid + ", following_user_id=" + following_user_id + "]";
	}

}
