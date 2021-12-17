/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.eventmanagementsystem.dao;

import app.eventmanagementsystem.pojo.Organizer;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author aksha
 */
public class OrganizerDAO extends DAO{
    

    // this class extends DAO class for the Hibernate ORM code
    // This class performs CRUD operations on POJO
    
    public void createOrganizer(Organizer organizer) {
        try {
            // methods: begin(), getSession(), commit(), rollback() are from DAO.java
        begin(); 
        getSession().save(organizer);
        commit();
        System.out.println("Organizer Saved in the DB");
        } catch(Exception e) {
            System.out.println("Organizer NOT saved in the DB");
            rollback();
            
        }
        
    }
    
    
     public Organizer getOrganizer(String emailid, String password)
            throws Exception {
     
     
     Organizer organizer  = new Organizer();
	        try {
	            begin();
	            Query q = getSession().createQuery("from Organizer where emailid= :emailid and password= :password");
	            q.setString("emailid", emailid);
	            q.setString("password", password);
	            organizer = (Organizer) q.uniqueResult();
	            commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            rollback();
	            throw e;
	        } finally {
	            close();
	        }
	        return organizer;
     }
   
    
    public void deleteOrganizer(Organizer organizer) {
        begin();
        getSession().delete(organizer);
        commit();
    }
    
    public void updateOrganizer(Organizer organizer) {
        begin();
        getSession().update(organizer);
        commit();
    }
}
