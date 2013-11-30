package main.java.com.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import main.java.com.CalendarDateUtils;

@ManagedBean
@SessionScoped
public class WeeksBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date weekStartDate;
	private Date weekEndDate;
	
	@PostConstruct
    public void init(){
		weekStartDate = new Date();
		weekEndDate = new Date();
		
		// "calculate" the start date of the week
	    Calendar first = (Calendar) Calendar.getInstance().clone();
	    first.add(Calendar.DAY_OF_WEEK, first.getFirstDayOfWeek() - first.get(Calendar.DAY_OF_WEEK));

	    // and add six days to the end date
	    Calendar last = (Calendar) first.clone();
	    last.add(Calendar.DAY_OF_YEAR, 6);

	    weekStartDate = first.getTime();
	    weekEndDate = last.getTime();
	}
	
	public List<String> getWeekDays(){
		List<String> daysList = new ArrayList<String>();

		// EEE gives short day names, EEEE would be full length.
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE-dd", Locale.US); 
		Date tempDate;
		
		daysList.add(dateFormat.format(weekStartDate));
		for(int i = 1; i < 7; i++){
			tempDate = CalendarDateUtils.getDateAfter(weekStartDate, i);
			daysList.add(dateFormat.format(tempDate));
		}

		return daysList;
	}
	
	public Date getWeekStartDate() {
		return weekStartDate;
	}

	public void setWeekStartDate(Date weekStartDate) {
		this.weekStartDate = weekStartDate;
	}

	public Date getWeekEndDate() {
		return weekEndDate;
	}

	public void setWeekEndDate(Date weekEndDate) {
		this.weekEndDate = weekEndDate;
	}
	
	public void navigateToNextWeek(){
		weekStartDate = CalendarDateUtils.getDateAfter(weekStartDate, 7);
		weekEndDate = CalendarDateUtils.getDateAfter(weekEndDate, 7);
	}
	public void navigateToPrevWeek(){
		weekStartDate = CalendarDateUtils.getDateAfter(weekStartDate, -7);
		weekEndDate = CalendarDateUtils.getDateAfter(weekEndDate, -7);
	}
}
