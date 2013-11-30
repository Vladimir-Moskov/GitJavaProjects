package main.java.com;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class CalculatorBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private long firstNum;
	private long secondNum;
	
	private long resultNum;
	
	public long getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(long firstNum) {
		this.firstNum = firstNum;
	}

	public long getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(long secondNum) {
		this.secondNum = secondNum;
	}

	public long getResultNum() {
		resultNum = secondNum + firstNum;
		return resultNum;
	}

}