
package app.eventmanagementsystem.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
// for using hibernate, add the maven dependency
// for using mysql db, add the maven dependency

/**
 *
 * @author aksha
 */
public abstract class DAO {
    // we do not want this class to be instantiated
    // thus made it an abstract class
    // this class contains the Hibernate ORM Code

    private static final Logger log = Logger.getAnonymousLogger();

    private static final ThreadLocal sessionThread = new ThreadLocal();
    // Class ThreadLocal provide thread-local variables.
    // These variables differ from their normal counterparts in that each thread
    // that accesses one(via its get or set method) has its own independently initialized 
    // copy of the variable.
    private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    

    protected DAO() {
    }

    public static Session getSession() {
        Session session = (Session) DAO.sessionThread.get();

        if (session == null) {
            session = sessionFactory.openSession();
            DAO.sessionThread.set(session);
        }
        return session;
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot close", e);
        }
        DAO.sessionThread.set(null);
    }

    public static void close() {
        getSession().close();
        DAO.sessionThread.set(null);
    }
}

