package com.krowd.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * The bean for the Events in the application. The annotations reference our EVENTS table in
 * the database.
 */
@Entity
@Table(name = "EVENTS")
public class Events {

	/*
	 * The constructors for Events bean. One with call to super class, and the others with fields.
	 */
	public Events() {
		super();
	}

	public Events(int event_id, String event_name, String event_location, String event_description, String event_type,
			LocalDate event_date, int user_id, String photo_url, LocalDate created, int eventGuests) {
		super();
		this.event_id = event_id;
		this.event_name = event_name;
		this.event_location = event_location;
		this.event_description = event_description;
		this.event_type = event_type;
		this.event_date = event_date;
		this.user_id = user_id;
		this.photo_url = photo_url;
		this.created = created;
		this.eventGuests = eventGuests;
	}

	public Events(String event_name, String event_location, String event_description, String event_type,
			LocalDate event_date, int user_id, String photo_url, LocalDate created, int eventGuests) {
		super();
		this.event_name = event_name;
		this.event_location = event_location;
		this.event_description = event_description;
		this.event_type = event_type;
		this.event_date = event_date;
		this.user_id = user_id;
		this.photo_url = photo_url;
		this.created = created;
		this.eventGuests = eventGuests;
	}

	
	public Events(String event_name, String event_description, int user_id) {
		super();
		this.event_name = event_name;
		this.event_description = event_description;
		this.user_id = user_id;
	}

	/*
	 * The fields for the Events bean.
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eventSequence")
	@SequenceGenerator(allocationSize = 1, name = "eventSequence", sequenceName = "SQ_Events_PK")
	@JoinTable
	@Column(name = "EVENT_ID")
	private int event_id;
	@Column(name = "EVENT_NAME")
	private String event_name;
	@Column(name = "EVENT_LOCATION")
	private String event_location;
	@Column(name = "EVENT_DESCRIPTION")
	private String event_description;
	@Column(name = "EVENT_TYPE")
	private String event_type;
	@Column(name = "EVENT_DATE")
	private LocalDate event_date;
	@JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private int user_id;
	@Column(name = "PHOTO_URL")
	private String photo_url;
	@Column(name = "CREATED")
	private LocalDate created;
	@Column(name = "EVENTS_MAXGUESTS")
	private int eventGuests;

	/*
	 * The getters and setters for the fields.
	 */
	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getEvent_location() {
		return event_location;
	}

	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}

	public String getEvent_description() {
		return event_description;
	}

	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public LocalDate getEvent_date() {
		return event_date;
	}

	public void setEvent_date(LocalDate event_date) {
		this.event_date = event_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	/*
	 * The toString that will print that contains the fields.(non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Events [event_id=" + event_id + ", event_name=" + event_name + ", event_location=" + event_location
				+ ", event_description=" + event_description + ", event_type=" + event_type + ", event_date="
				+ event_date + ", user_id=" + user_id + ", photo_url=" + photo_url + ", created=" + created
				+ ", eventGuests=" + eventGuests + "]";
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	public int getEventGuests() {
		return eventGuests;
	}

	public void setEventGuests(int eventGuests) {
		this.eventGuests = eventGuests;
	}
	
	

}
