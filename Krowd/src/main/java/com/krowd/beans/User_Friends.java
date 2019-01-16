package com.krowd.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_FRIENDS")
public class User_Friends {

	

	@ManyToMany(cascade = { CascadeType.ALL, CascadeType.REMOVE })
	@JoinTable(name = "USER_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT), joinColumns = @JoinColumn(referencedColumnName ="USER_ID"))
	private List<Users> user = new ArrayList<>();

	@ManyToMany(cascade = { CascadeType.ALL, CascadeType.REMOVE })
	@JoinTable(name = "FOLLOWING_USER_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT), joinColumns = @JoinColumn(referencedColumnName ="USER_ID"))
	private List<Users> following_user = new ArrayList<>();

	public User_Friends(List<Users> user, List<Users> following_user) {
		super();
		this.user = user;
		this.following_user = following_user;
	}

	@Override
	public String toString() {
		return "User_Friends [user=" + user + ", following_user=" + following_user + "]";
	}


	public User_Friends() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Users> getUser() {
		return user;
	}

	public void setUser(List<Users> user) {
		this.user = user;
	}

	public List<Users> getFollowing_user() {
		return following_user;
	}

	public void setFollowing_user(List<Users> following_user) {
		this.following_user = following_user;
	}

	
	
}
