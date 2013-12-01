package main.java.com;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;

public class EmailSender {

	public void sendMail(String emailTo){
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("boba.mockob@gmail.com", "vovkam44"));
		email.setSSLOnConnect(true);
		
		try{
			email.setFrom("boba.mockob@gmail.com");
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
