package main.java.com.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import main.java.com.CalendarDateUtils;

@ManagedBean
@SessionScoped
public class MonthsBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Date monthStartDate;
	private Date monthEndDate;
	
	@PostConstruct
    public void init(){
		monthStartDate = new Date();
		monthEndDate = new Date();

	    Calendar calendar =  (Calendar) GregorianCalendar.getInstance().clone();
	    calendar.setTime(monthStartDate);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        monthStartDate = calendar.getTime();
 
        calendar = (Calendar)  GregorianCalendar.getInstance().clone();
        calendar.setTime(monthStartDate);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        monthEndDate = calendar.getTime();
    }
	
	public Date getMonthStartDate() {
		return monthStartDate;
	}

	public void setMonthStartDate(Date monthStartDate) {
		this.monthStartDate = monthStartDate;
	}

	public Date getMonthEndDate() {
		return monthEndDate;
	}

	public void setMonthEndDate(Date monthEndDate) {
		this.monthEndDate = monthEndDate;
	}
	
	public void navigateToNextMonth(){
		monthStartDate = CalendarDateUtils.getDateAfter(monthEndDate, 1);
		
		Calendar calendar = (Calendar)  GregorianCalendar.getInstance().clone();
		calendar.setTime(monthStartDate);
	    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	    monthEndDate = calendar.getTime();
	}
	
	public void navigateToPrevMonth(){
		monthEndDate = CalendarDateUtils.getDateAfter(monthStartDate, -1);
		
	    Calendar calendar =  (Calendar) GregorianCalendar.getInstance().clone();
	    calendar.setTime(monthEndDate);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        monthStartDate = calendar.getTime();
	}
}
