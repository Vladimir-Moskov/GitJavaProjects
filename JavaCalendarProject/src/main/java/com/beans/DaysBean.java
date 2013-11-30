package main.java.com.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import main.java.com.CalendarDateUtils;

@ManagedBean
@SessionScoped
public class DaysBean  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Date dayDate;
	
	@PostConstruct
    public void init(){
		setDayDate(new Date());
	}
	
	public Date getDayDate() {
		return dayDate;
	}

	public void setDayDate(Date dayDate) {
		this.dayDate = dayDate;
	}
	
	public String getCurrentDate(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE-dd-MMMM-yyyy", Locale.US); 
		String asWeek = "Today " + dateFormat.format(dayDate);
		
		return  asWeek;
	}
	
	public void navigateToNextDay(){
		dayDate = CalendarDateUtils.getDateAfter(dayDate, 1);
	}
	public void navigateToPrevDay(){
		dayDate = CalendarDateUtils.getDateAfter(dayDate, -1);
	}
	
	
	
	public List<String> getDayTime(){
		List<String> daysList = new ArrayList<String>();

		for(int i = 0; i < 25; i++){
			if(i < 10)
				daysList.add("0" + Integer.toString(i) + ":00");
			else
				daysList.add(Integer.toString(i) + ":00");
		}

		return daysList;
	}
}
