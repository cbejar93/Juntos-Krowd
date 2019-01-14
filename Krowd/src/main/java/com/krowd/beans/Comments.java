package com.krowd.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTS")
public class Comments {
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comments(String data, Events event, LocalDate created, int user_id) {
		super();
		this.data = data;
		this.event = event;
		Created = created;
		this.user_id = user_id;
	}

	public Comments(int comment_id, String data, Events event, LocalDate created, int user_id) {
		super();
		this.comment_id = comment_id;
		this.data = data;
		this.event = event;
		Created = created;
		this.user_id = user_id;
	}

	@Id
	@Column(name = "COMMENT_ID")
	private int comment_id;
	@Column(name = "DATA")
	private String data;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EVENT_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Events event;
	@Column(name = "CREATED")
	private LocalDate Created;
	@Column(name = "USER_ID")
	private int user_id;

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Events getEvent() {
		return event;
	}

	public void setEvent(Events event) {
		this.event = event;
	}

	public LocalDate getCreated() {
		return Created;
	}

	public void setCreated(LocalDate created) {
		Created = created;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Comments [comment_id=" + comment_id + ", data=" + data + ", event=" + event + ", Created=" + Created
				+ ", user_id=" + user_id + "]";
	}

}
