package main.java.com.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;


@ManagedBean
@SessionScoped
public class UserBean  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String password;
	private String name;
	private String firstName;
	private String lastName;
	private String confpassword;
	private String email;
	private Boolean isLoged = false;
	
	public void login(){
		 RequestContext context = RequestContext.getCurrentInstance();  
		 FacesMessage msg = null;  
		      
		 if(name != null  && name.equals("admin") && password != null  && password.equals("admin")) {  
			 isLoged = true;  
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", name);  
		 } else {  
			 isLoged = false;  
		    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");  
		}  
		  
		FacesContext.getCurrentInstance().addMessage(null, msg);  
		context.addCallbackParam("loggedIn", isLoged);  
	}
	
	public void forgot(){
		
	}
	
	public void registrate(){
		
	}
	
	public void logout(){
		
	}
	
	public boolean isUserAdmin(){
		return getRequest().isUserInRole("ADMIN");
	}
	
	private String logOut() throws ServletException{
		getRequest().getSession().invalidate();
		getRequest().logout();
		return "logout";
	}
	
	private String logIn() throws ServletException{
		getRequest().login(name, password);
		//getRequest().logout();
		return "logout";
	}
	
	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserBean [id=");
		builder.append(id);
		builder.append(", ");
		if (password != null) {
			builder.append("passwrd=");
			builder.append(password);
			builder.append(", ");
		}
		if (name != null) {
			builder.append("name=");
			builder.append(name);
		}
		builder.append("]");
		return builder.toString();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passwrd) {
		this.password = passwrd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getConfpassword() {
		return confpassword;
	}

	public void setConfpassword(String confpassword) {
		this.confpassword = confpassword;
	}

	public Boolean getIsLoged() {
		return isLoged;
	}

	public void setIsLoged(Boolean isLoged) {
		this.isLoged = isLoged;
	}
}
