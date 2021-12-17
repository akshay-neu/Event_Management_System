
package app.eventmanagementsystem.dao;

import app.eventmanagementsystem.pojo.User;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author aksha
 */
public class UserDAO extends DAO 
{
    // this class extends DAO class for the Hibernate ORM code
    // This class performs CRUD operations on POJO
    
    public void createUser(User user) {
        try {
            // methods: begin(), getSession(), commit(), rollback() are from DAO.java
        begin(); 
        getSession().save(user);
        commit();
        } catch(Exception e) {
            rollback();
        }
        System.out.println("User Saved in the DB");
    }
    
    
     public User getUser(String emailid, String password)
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
     
     
     User user  = new User();
	        try {
	            begin();
	            //Query q = getSession().createQuery("from Message where userName= :username");
	            Query q = getSession().createQuery("from User where emailid= :emailid and password= :password");
	            q.setString("emailid", emailid);
	            q.setString("password", password);
	            user = (User) q.uniqueResult();
	            commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            rollback();
	            throw e;
	        } finally {
	            close();
	        }
	        return user;
     }
   
    
    
//    public User getUser(int userid) {
//        return getSession().get(User.class, userid);
//    }
    
    public void deleteUser(User user) {
        begin();
        getSession().delete(user);
        commit();
    }
    
//    public void updateUser(User user) {
//        begin();
//        getSession().update(user);
//        commit();
//    }
    
    public int updateUser(User user) throws Exception{
	    	int ret = 0;
	    	 try {
	             begin();
	            getSession().update(user);
	             System.out.println("updated user from here");
	             ret=1;
	             commit();
	         } catch (HibernateException e) {
	        	 e.printStackTrace();
		         rollback();
		         throw e;
	         }finally {
		            close();
		        }
	    	 return ret;
	    }
	    
    
    
    
}