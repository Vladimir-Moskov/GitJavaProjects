package main.java.com;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StringTaskBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String firstString = "";
	private String secondString = "";
	
	private String resultString;
	
	public String getFirstString() {
		return firstString;
	}

	public void setFirstString(String firstString) {
		this.firstString = firstString;
	}

	public String getSecondString() {
		return secondString;
	}

	public void setSecondString(String secondString) {
		this.secondString = secondString;
	}

	public String getResultString() {
		resultString = firstString + secondString;
		return resultString;
	}
	
	public String getResultStringLen() {
		Integer len = firstString.length() + secondString.length();
		return Integer.toString(len);
	}
}
