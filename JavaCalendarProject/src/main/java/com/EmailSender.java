package main.java.com;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSender {

	public void sendMail(String emailTo){
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("bobaa.amockob@gmail.com", "avovkam44"));
		email.setSSLOnConnect(true);
		
		try{
			email.setFrom("bobaa.mockob@gmail.com");
			email.setSubject("TestMail");
			email.setMsg("This is a test mail ... :-)");
			email.addTo(emailTo);
			email.send();
		}
		catch(EmailException e){
			
		}
		finally{
			
		}
		
	}
	

}
