package main.java.com;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
    
	static {
      try {
        sessionFactory = configureSessionFactory();
      } catch (Throwable ex) {
        System.err.println("Failed to create sessionFactory object." + ex);
        throw new ExceptionInInitializerError(ex);
      }
    }

    public static SessionFactory getSessionFactory() {
      return sessionFactory;
    }
    
	private static SessionFactory configureSessionFactory() throws HibernateException {
		SessionFactory factory;
		ServiceRegistry serviceRegistry;
		Configuration configuration = new Configuration();
		//File file = new File("./src/main/resources/hibernate/hibernate.cgf.xml");
		File file = new File("C:/Users/vavas/workspace/JavaCalendarProject/src/main/resources/hibernate/hibernate.cgf.xml");
		System.out.println(file.getAbsolutePath());
	    configuration.configure(file);
		//configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    factory = configuration.buildSessionFactory(serviceRegistry);
	    return factory;
	}
}
