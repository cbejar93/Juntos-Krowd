package com.krowd.beans;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "USER_EVENTS")
public class User_Events {
	
	public User_Events() {
		super();
	}
	public User_Events(int userid, int event_id) {
		super();
		this.userid = userid;
		this.event_id = event_id;
	}
	
	@Id
	@JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private int userid;
	@JoinColumn(name = "EVENT_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private int event_id;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	
	@Override
	public String toString() {
		return "User_Events [userid=" + userid + ", event_id=" + event_id + "]";
	}

}
