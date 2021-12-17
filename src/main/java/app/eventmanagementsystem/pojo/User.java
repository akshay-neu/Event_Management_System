/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.eventmanagementsystem.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author aksha
 */
@Entity
@Table(name="usertable")
public class User {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="userid")
    private long userid;
    
    @Basic
    @Column(name="username")
    private String username;
    
    @Column(unique = true)
    private String emailid;
    
    @Basic
    @Column(name="password")
    private String password;


    
    // foreign key
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "usertable_eventtable", joinColumns = { @JoinColumn(name = "userid")}, inverseJoinColumns = { @JoinColumn(name = "eventid") })
//    private Set<Event> eventorders = new HashSet<Event>(); // events registered
    
    @ManyToMany( mappedBy = "users", fetch = FetchType.EAGER)
    private List<Event> events = new ArrayList<Event>();    // CHILD 
   
// private Set<Event> eventfavorite = new HashSet(); // events created        
//    private String phonenumber;
//    private String photopath;
    
    
    
    /* 
    -------------------------------------------------------------------------------------------------------
    */
    

    // Default Constructor
    public User(){
    }
    
    // Getter Setter
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<Event> getEventorders() {
//        return eventorders;
//    }
//
//    public void setEventorders(Set<Event> eventorders) {
//        this.eventorders = eventorders;
//    }

//    public Set<Event> getEventfavorite() {
//        return eventfavorite;
//    }
//
//    public void setEventfavorite(Set<Event> eventfavorite) {
//        this.eventfavorite = eventfavorite;
//    }
//    
//    public void addEventfavourite(Event e) {
//		eventfavorite.add(e);
//    }
//	
//    public void removeEventfavorite(Event e) {
//		eventfavorite.remove(e);
//    }
    
//    public void addEventorders(Event e) {
//		eventorders.add(e);
//    }
//	
//    public void removeEventorders(Event e) {
//		eventorders.remove(e);
//    }
//     

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
    
    public void addEvent(Event e) {
        System.out.println("in User pojo -start");
		events.add(e);
                System.out.println("in user pojo - end");
	}

//    public List<Event> getEvent() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//    
    
    
    
}
