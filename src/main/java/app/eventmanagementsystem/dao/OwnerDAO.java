/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.eventmanagementsystem.dao;

import app.eventmanagementsystem.pojo.Owner;
import app.eventmanagementsystem.pojo.Venue;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author aksha
 */
public class OwnerDAO extends DAO  {
    
    // this class extends DAO class for the Hibernate ORM code
    // This class performs CRUD operations on POJO
    
    public void createOwner(Owner owner) {
        try {
            // methods: begin(), getSession(), commit(), rollback() are from DAO.java
        begin(); 
        getSession().save(owner);
        commit();
        } catch(Exception e) {
            rollback();
        }
        System.out.println("Owner Saved in the DB.");
    }
    
    
    public Owner getOwner(String emailid, String password)
            throws Exception {
//        try {
//            begin();
//                CriteriaQuery crit = (CriteriaQuery) getSession().createCriteria(User.class);
//    		crit.add(Restrictions.eq("name", username));
//    		crit.add(Restrictions.eq("password", password));
//    		User loggedInUser = (User) crit.uniqueResult();
//    		commit();
//    		return loggedInUser;
//        } catch (HibernateException e) {
//            rollback();
//            throw new Exception("Could not get user " + username, e);
//        }
//    }
     
     
     Owner owner  = new Owner();
	        try {
	            begin();
	            Query q = getSession().createQuery("from Owner where emailid= :emailid and password= :password");
	            q.setString("emailid", emailid);
	            q.setString("password", password);
	            owner = (Owner) q.uniqueResult();
	            commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            rollback();
	            throw e;
	        } finally {
	            close();
	        }
	        return owner;
     }
   
//    public Owner getOwner(int ownerid) {
//        return getSession().get(Owner.class, ownerid);
//    }
    
    public void deleteOwner(Owner owner) {
        begin();
        getSession().delete(owner);
        commit();
    }
    
    public void updateOwner(Owner owner, Venue venue) {
        begin();
        
        //owner.addVenue(venue);
        
        getSession().update(owner);
        commit();
    }
    
 
}
