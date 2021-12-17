/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.eventmanagementsystem.dao;

import app.eventmanagementsystem.pojo.Owner;
import app.eventmanagementsystem.pojo.Venue;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author aksha
 */
public class VenueDAO extends DAO  {
    
    // this class extends DAO class for the Hibernate ORM code
    // This class performs CRUD operations on POJO
    
    public void createVenue(Venue venue) {
        try {
            // methods: begin(), getSession(), commit(), rollback() are from DAO.java
        begin(); 
        getSession().save(venue);
        commit();
        System.out.println("Venue create query commit done.");
        } catch(Exception e) {
        System.out.println("Venue create query error.");
        System.out.println(e);
            rollback();
        }
        System.out.println("Venue Saved in the DB.");
    }
    // --------------------------------------------------------------------------------
    
//    public Venue getVenue(int venueid) {
//        
//         try {
//            begin();
//            Criteria crit = getSession().createCriteria(Category.class);
//    		crit.add(Restrictions.eq("title", title));
//    		Category category = (Category) crit.uniqueResult();
//            commit();
//            return category;
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdvertException("Could not obtain the named category " + title + " " + e.getMessage());
//        }
//        
//        
//        
//        return getSession().get(Venue.class, venueid);
//    }
    
    // ------------------------------------------------------------------------------------
    public void deleteVenue(Venue venue) {
        begin();
        getSession().delete(venue);
        commit();
    }
    
    // ----------------------------------------------------------------------------------------
    public void updateVenue(Venue venue) {
        begin();
        getSession().update(venue);
        commit();
    }
    
    // -------------------------------------------------------------------------------------
    public List<Venue> getVenueList() throws Exception {
    	List<Venue> venues = new ArrayList<Venue>();
		
		try {
			begin();
			Criteria crit = getSession().createCriteria(Venue.class);
			venues = crit.list();
		    commit();
			return venues;
		} catch (HibernateException e) {
            rollback();
            throw new Exception("Could not list the Venue", e);
        }
    }
    
    // ---------------------------------------------------------------------------------------
    public Venue getVenuebyId(long venueid){
		Venue venue = null;
        try {
            begin();
            //Query q = getSession().createQuery("from Message where userName= :username");
            
            Query q = getSession().createQuery("from Venue where venueid= :venueid");
            
            q.setLong("venueid", venueid);
            
            venue = (Venue) q.uniqueResult();
            
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        } finally {
            close();
        }
        return venue;		
	}
    
    
    // ------------------------------------------------------------------------------------
    
        public List<Venue> getVenuebyOwner(Owner owner){
		List<Venue> v = new ArrayList<Venue>();
        try {
            begin();
            
            Query q = getSession().createQuery("from Venue where owner= :owner");
            
            q.setEntity("owner", owner);
            
            v = (List<Venue>) q.list();
           
           // System.out.println("Size in sout"+v.size());
            
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        } finally {
            close();
        }
        return v;		
	}
        
     // ---------------------------------------------------------------------------
	 
}

