package main.java.com;

import java.io.File;
import java.util.Date;

import main.java.com.dto.EventDTO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibirnateDemo {

private static SessionFactory factory;
	
	private static SessionFactory configureSessionFactory() throws HibernateException {
		SessionFactory sessionFactory;
		ServiceRegistry serviceRegistry;
		Configuration configuration = new Configuration();
		File file = new File("./src/main/resources/hibernate/hibernate.cgf.xml");
		System.out.println(file.getAbsolutePath());
	    configuration.configure(file);
		//configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	
	public static void main(String[] args) {
	
		//EmailSender.sendMail(); 
		/*	
      try{
         factory = configureSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
		      
      Session session = factory.openSession();
      Transaction tx = null;
      Long id = null;
      try{
    	  tx = session.beginTransaction();
         EventDTO event = new EventDTO();
         event.setTitle("title");
         event.setDescription("description");
         event.setStartTime(new Date());
         event.setEndTime(new Date());
         id = (Long) session.save(event); 
         tx.commit();
         System.out.println("ID = " + id);
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }*/
     }
	
}
