package main.java.hibirnate;

import java.io.File;

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
	    
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	
	public static void main(String[] args) {
		
      try{
         factory = configureSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
		      
      Session session = factory.openSession();
      Transaction tx = null;
      Integer clientID = null;
      try{
         tx = session.beginTransaction();
         Client client = new Client();
         client.setMail("mail");
         client.setName("name");
         client.setPhone("phone");
         clientID = (Integer) session.save(client); 
         tx.commit();
         System.out.println("clientID = " + clientID);
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
     }
	
}
