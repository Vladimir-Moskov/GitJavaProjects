package main.java.com;

import java.util.Calendar;
import java.util.Date;

public class CalendarDateUtils {
	
	static public Date getDateAfter(Date date, int delta){
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DATE, delta);
		return c.getTime();
	}

}
