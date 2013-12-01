package main.java.com.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.java.com.HibernateUtil;
import main.java.com.dto.EventDTO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EventDAO {

	public Long addEvent(EventDTO event){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
	    Long id = -1l;
	    try{
	    	 tx = session.beginTransaction();
	         id = (Long) session.save(event); 
	         tx.commit();
	         System.out.println("ID = " + id);
	      }catch (HibernateException e) {
	         if (tx != null) tx.rollback();
	         		e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return id;
	}
	
	public Boolean updateEvent(EventDTO event){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Boolean isUpdates = true;
	    try{
	    	 tx = session.beginTransaction();
	         session.update(event); 
	         tx.commit();
	    }catch (HibernateException e) {
	         if (tx != null) tx.rollback();
	         		e.printStackTrace(); 
	         isUpdates = false;
	      }finally {
	         session.close(); 
	      }
		return isUpdates;
	}
	
	public List<EventDTO> getAllEvents(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<EventDTO> events = new ArrayList<EventDTO>();

	    try{
	    	events = (List<EventDTO>) session.createCriteria(EventDTO.class).list(); 
	      }catch (HibernateException e) {
	    	  e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return events;
	}
	
	public List<EventDTO> getRangeEvent(Date startDate, Date endDate){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<EventDTO> events = new ArrayList<EventDTO>();

	    try{
	    	events = (List<EventDTO>) session.createCriteria(EventDTO.class).list(); 
	      }catch (HibernateException e) {
	    	  e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return events;
	}
}
