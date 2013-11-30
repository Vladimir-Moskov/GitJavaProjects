package main.java.com.dao;

public class DAOFactory {
	private static DAOFactory instance = null;
	
	private static EventDAO eventDAO = null;


	  public static synchronized DAOFactory getInstance(){
	    if (instance == null){
	      instance = new DAOFactory();
	    }
	    return instance;
	  }
	
	  public EventDAO getEventDAO(){
	    if (eventDAO == null){
	    	eventDAO = new EventDAO();
	    }
	    return eventDAO;
	  }
}
