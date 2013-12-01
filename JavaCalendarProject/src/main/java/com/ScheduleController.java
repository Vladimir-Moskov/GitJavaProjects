package main.java.com;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import main.java.com.dao.DAOFactory;
import main.java.com.dto.EventDTO;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import antlr.debug.Event;

@ManagedBean
@SessionScoped
public class ScheduleController implements Serializable {
 
	    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

		private ScheduleModel eventModel;  
     
	    private ScheduleEvent event = new DefaultScheduleEvent();  
	    private String description;  
	    
	    public ScheduleController() {  
	       
	        List<EventDTO> allEvents = DAOFactory.getInstance().getEventDAO().getAllEvents();
	        
	        eventModel = new DefaultScheduleModel();  
	        DefaultScheduleEvent tempEvent;
	        for (EventDTO event: allEvents)
	        {
	        	tempEvent = new DefaultScheduleEvent(event.getTitle(), event.getStartTime(),  event.getEndTime());
	        	tempEvent.setId(String.valueOf(event.getId()));
	        	eventModel.addEvent(tempEvent);
	        }
 
	    }  

	    public Date getInitialDate() {  
	        Calendar calendar = Calendar.getInstance();  
	        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);  
	          
	        return calendar.getTime();  
	    }  
	      
	    public ScheduleModel getEventModel() {  
	        return eventModel;  
	    }  
	      
	    private Calendar today() {  
	        Calendar calendar = Calendar.getInstance();  
	        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);  
	  
	        return calendar;  
	    }  

	    public ScheduleEvent getEvent() {  
	        return event;  
	    }  
	  
	    public void setEvent(ScheduleEvent event) {  
	        this.event = event;  
	    }  
	      
	    public void addEvent(ActionEvent actionEvent) {  
	        if(event.getId() == null){
	        	EventDTO newEvent = new EventDTO();
	        	newEvent.setDescription(description);
	        	newEvent.setTitle(event.getTitle());
	        	newEvent.setStartTime(event.getStartDate());
	        	newEvent.setEndTime(event.getEndDate());
	        	event.setId(DAOFactory.getInstance().getEventDAO().addEvent(newEvent).toString());
	       	 	eventModel.addEvent(event);
	        }
	        else{
	        	 eventModel.updateEvent(event);  
	        	 EventDTO updateEvent = new EventDTO();
	        	 updateEvent.setDescription(description);
	        	 updateEvent.setTitle(event.getTitle());
	        	 updateEvent.setStartTime(event.getStartDate());
	        	 updateEvent.setEndTime(event.getEndDate());
	        	 updateEvent.setId(Long.valueOf(event.getId()));
	        	 DAOFactory.getInstance().getEventDAO().updateEvent(updateEvent) ;
	        }

	    }  
	      
	    public void onEventSelect(SelectEvent selectEvent) {  
	        event = (ScheduleEvent) selectEvent.getObject();  
	    }  
	      
	    public void onDateSelect(SelectEvent selectEvent) {  
	        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());  
	    }  

	    public void onEventMove(ScheduleEntryMoveEvent eventMove) {  
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + eventMove.getDayDelta() + ", Minute delta:" + eventMove.getMinuteDelta());  
	          
	        addMessage(message);  
	        
	         eventModel.updateEvent(event);  
	       	 EventDTO updateEvent = new EventDTO();
	       	 updateEvent.setDescription(description);
	       	 updateEvent.setTitle(event.getTitle());
	       	 updateEvent.setStartTime(event.getStartDate());
	       	 updateEvent.setEndTime(event.getEndDate());
	       	 updateEvent.setId(Long.valueOf(event.getId()));
	       	 DAOFactory.getInstance().getEventDAO().updateEvent(updateEvent) ;
	    }  
	      
	    public void onEventResize(ScheduleEntryResizeEvent event) {  
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());  
	          
	        addMessage(message);  
	    }  
	      
	    private void addMessage(FacesMessage message) {  
	        FacesContext.getCurrentInstance().addMessage(null, message);  
	    }  
}
