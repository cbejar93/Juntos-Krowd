package com.krowd.beans;

/*
 * This is a Bean for our credentials that help us with Authentication.
 */

public class Credentials {
	
	/*
	 * Our various constructors.
	 */
	public Credentials(String username, String password, String email, String fID) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.fID = fID;
	}

	public Credentials() {
		super();
	}
	
	public Credentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	/*
	 * The fields for the Credentials.
	 */
	private String username;
	private String password;
	private String email;
	private String fID;
	
	/*
	 * Getters and setters for the fields.
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	 * The toString that will print, containing our fields.(non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Credentials [username=" + username + ", password=" + password + "]";
	}

	/*
	 * The hashcode for the Credentials.(non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credentials other = (Credentials) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfID() {
		return fID;
	}

	public void setfID(String fID) {
		this.fID = fID;
	}
	

}

