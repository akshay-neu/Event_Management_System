/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.eventmanagementsystem.dao;

import app.eventmanagementsystem.pojo.Event;
import app.eventmanagementsystem.pojo.Organizer;
import app.eventmanagementsystem.pojo.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author aksha
 */
public class EventDAO extends DAO 
{
    // this class extends DAO class for the Hibernate ORM code
    // This class performs CRUD operations on POJO
    
    public void createEvent(Event event) {
        try {
            // methods: begin(), getSession(), commit(), rollback() are from DAO.java
        begin(); 
        System.out.println("event name: "+event.getEventname());
        System.out.println("event venue: " + event.getVenue());
        getSession().save(event);
        commit();
        System.out.println("Event Created Saved in the DB.");
        } catch(Exception e) {
        System.out.println("Error in Create Event query.");
            rollback();
        }
        
    }
      // -----------------------------------------------------------------------------------------
    public Event getEvent(int eventid) {
        return getSession().get(Event.class, eventid);
    }
      // -----------------------------------------------------------------------------------------
    public void deleteEvent(Event event) {
        begin();
        getSession().delete(event);
        commit();
    }
      // -----------------------------------------------------------------------------------------
    public void updateEvent(Event event) {
        begin();
        getSession().update(event);
        commit();
    }
      // -----------------------------------------------------------------------------------------
    public List<Event> getAllEvents(){
		List<Event> v = new ArrayList<Event>();
        try {
            begin();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Event");
            
            v = (List<Event>) q.list();
           
            System.out.println("Size in sout" +v.size());
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        } finally {
            close();
        }
        return v;		
	}
    
      // -----------------------------------------------------------------------------------------
    
    	public Event getEventbyid(int eid){
		Event event = new Event();
        try {
            begin();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Event where eventid=:eid");
            
            q.setInteger("eid", eid);
            event = (Event) q.uniqueResult();
            
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        } finally {
            close();
        }
        return event;		
	}
        
        // -----------------------------------------------------------------------------------------
        public List<Event> getEvents(Organizer user){
		List<Event> v = new ArrayList<Event>();
        try {
            begin();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Event where organizer=:user");
            
            q.setEntity("user", user);
            v = (List<Event>) q.list();
           
            System.out.println("Size in sout"+v.size());
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        } finally {
            close();
        }
        return v;		
	}
	
	
	
}