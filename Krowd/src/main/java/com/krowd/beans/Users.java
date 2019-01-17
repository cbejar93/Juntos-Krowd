package com.krowd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * The bean for the Users. The annotations reference the USERS table in the database.
 */
@Entity
@Table(name = "USERS")
public class Users {

	/*
	 * The constructors for the Users bean. Some with fields, and one with a call to the Super class.
	 */
	public Users(String firstname, String lastname, String username, String email, int token_score, String password,
			String photo_url, String fID) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.token_score = token_score;
		this.password = password;
		this.photo_url = photo_url;
		this.fID = fID;
	}

	public Users(String username, String password, String email, String fID) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.fID = fID;
	}

	public Users(String firstname, String lastname, String username, String email, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * The toString that will print containing the fields.(non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", email=" + email + ", token_score=" + token_score + ", password=" + password
				+ ", photo_url=" + photo_url + ", fID=" + fID + "]";
	}

// you wont need to pass a photo_Url everytime right?
// maybe for updates
	public Users(int userid, String firstname, String lastname, String username, String email, int token_score,
			String password, String photo_url) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.token_score = token_score;
		this.password = password;
		this.photo_url = photo_url;
	}

	/*
	 * The fields for the Users bean.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
	@SequenceGenerator(allocationSize = 1, name = "userSequence", sequenceName = "SQ_Users_PK")
	@JoinTable
	@Column(name = "USER_ID")
	private int userid;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "TOKEN_SCORE")
	private int token_score;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "photo_url")
	private String photo_url;

	@Column(name = "fID")
	private String fID;

	/*
	 * The getters and setters for the Users bean.
	 */
	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getToken_score() {
		return token_score;
	}

	public void setToken_score(int token_score) {
		this.token_score = token_score;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfID() {
		return fID;
	}

	public void setfID(String fID) {
		this.fID = fID;
	}

	
}
