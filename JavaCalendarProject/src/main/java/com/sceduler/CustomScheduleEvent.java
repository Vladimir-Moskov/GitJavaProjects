package main.java.com.sceduler;

import java.util.Date;

import org.primefaces.model.DefaultScheduleEvent;

public class CustomScheduleEvent extends DefaultScheduleEvent {
   
	private String description;  
	
	public CustomScheduleEvent() {
		super();
	}
	
	public CustomScheduleEvent(String title, Date start, Date end) {
		super(title, start, end);
	}
	
	public CustomScheduleEvent(String title, Date start, Date end, boolean allDay) {
		super(title, start, end, allDay);
	}
	
	public CustomScheduleEvent(String title, Date start, Date end, String styleClass) {
		super(title, start, end, styleClass);
	}
	
	public CustomScheduleEvent(String title, Date start, Date end, Object data) {
		super(title, start, end, data);
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
