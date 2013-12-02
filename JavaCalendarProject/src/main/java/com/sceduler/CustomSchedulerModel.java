package main.java.com.sceduler;

import main.java.com.dto.EventDTO;

import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;

public class CustomSchedulerModel extends DefaultScheduleModel {

	@Override
	public void addEvent(ScheduleEvent event) {
		getEvents().add(event);
	}
	
	public void addEvent(EventDTO event) {
		CustomScheduleEvent tempEvent;
		tempEvent = new CustomScheduleEvent(event.getTitle(), event.getStartTime(),  event.getEndTime());
    	tempEvent.setId(String.valueOf(event.getId()));
		getEvents().add(tempEvent);
	}
}
