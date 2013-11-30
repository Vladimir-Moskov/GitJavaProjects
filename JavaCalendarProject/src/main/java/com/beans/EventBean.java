package main.java.com.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import main.java.com.dao.DAOFactory;
import main.java.com.dto.EventDTO;



@ManagedBean
@SessionScoped
public class EventBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private Date startTime;
	private Date endTime;
	private String title;
	private String description;
	
	@PostConstruct
    public void init(){
		
    }
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
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
	
	public void createEvent(){
		System.out.println("title = " + getTitle());
		System.out.println("sescription = " + getDescription());
		
		EventDTO event = new EventDTO();
		event.setTitle(title);
		event.setDescription(description);
		
		if(startTime != null)
			event.setStartTime(startTime);
		else
			event.setStartTime(new Date());
		
		if(endTime != null)
			event.setEndTime(endTime);
		else
			event.setEndTime(new Date());
        
		Long id = DAOFactory.getInstance().getEventDAO().addEvent(event);
		
	}
	
	public List<EventDTO> getEvents(){
		List<EventDTO> returnList = new ArrayList<EventDTO>();
		returnList = DAOFactory.getInstance().getEventDAO().getAllEvents();
		return returnList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EventBean [id=");
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
