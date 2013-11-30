package main.java.com;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
import java.io.Serializable;
 
@ManagedBean
@SessionScoped
public class PageController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	public String processPageStringTask(){
		return "success";
	}
	
	public String processPageCalculator(){
		return "success";
	}
	
}