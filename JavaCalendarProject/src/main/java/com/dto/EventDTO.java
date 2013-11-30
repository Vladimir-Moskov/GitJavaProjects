package main.java.com.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "eventstable")
public class EventDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="ID")
	private long id;
	//private long eventId;
	//private long userId;
	
	
	@NotNull
    @Column(name="START_DATE")
	private Date startTime;
	
	@NotNull
    @Column(name="END_DATE")
	private Date endTime;
	
	@NotNull
    @Column(name="TITLE")
	private String title;
	
	@NotNull
    @Column(name="DESCRIPTION")
	private String description;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/*
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}*/
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EventDTO [id=");
		builder.append(id);
		builder.append(", ");
		if (startTime != null) {
			builder.append("startTime=");
			builder.append(startTime);
			builder.append(", ");
		}
		if (endTime != null) {
			builder.append("endTime=");
			builder.append(endTime);
			builder.append(", ");
		}
		if (title != null) {
			builder.append("title=");
			builder.append(title);
			builder.append(", ");
		}
		if (description != null) {
			builder.append("description=");
			builder.append(description);
		}
		builder.append("]");
		return builder.toString();
	}
}
