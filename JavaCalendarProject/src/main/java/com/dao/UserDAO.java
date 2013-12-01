package main.java.com.dao;

import java.util.ArrayList;
import java.util.List;

import main.java.com.HibernateUtil;
import main.java.com.dto.EventDTO;
import main.java.com.dto.UserDTO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {
	
	public Long addUset(EventDTO event){
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
	
	public List<UserDTO> getAllUsers(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<UserDTO> events = new ArrayList<UserDTO>();

	    try{
	    	events = (List<UserDTO>) session.createCriteria(UserDTO.class).list(); 
	      }catch (HibernateException e) {
	    	  e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return events;
	}
	
	public List<EventDTO> checkUser(){
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
