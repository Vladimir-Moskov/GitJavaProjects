package main.java.com;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
import java.io.Serializable;
 
@ManagedBean
@SessionScoped
public class PageController implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	public String processSchedule(){
		return "success";
	}
	
	public String processPageHome(){
		return "success";
	}
	
	public String processPageDay(){
		return "success";
	}
	
	public String processPageWeek(){
		return "success";
	}
	
	public String processPageMonth(){
		return "success";
	}
	
	public String processPageNewEvent(){
		return "success";
	}
}