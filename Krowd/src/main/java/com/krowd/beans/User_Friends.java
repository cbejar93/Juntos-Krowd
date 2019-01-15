package com.krowd.beans;

public class User_Friends {

	public User_Friends() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User_Friends(int userid, int following_user_id) {
		super();
		this.userid = userid;
		this.following_user_id = following_user_id;
	}
	private int userid;
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
