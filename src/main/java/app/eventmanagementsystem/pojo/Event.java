/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.eventmanagementsystem.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author aksha
 */

@Entity
@Table(name="eventtable")
public class Event {
    
    @Id
    @Column(name="eventid")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long eventid;
    
    @Basic
    @Column(name="eventname")
    private String eventname;
    
    @Basic
    @Column(name="details")
    private String details;
    
    @Basic
    @Column(name="status")
    private String status;
    
    @Basic
    @Column(name="seats_available")
    private long seats_available;
    
    @Temporal(value=TemporalType.DATE)
    private Date eventdate;

    
    @ManyToOne
    @JoinColumn(name="venueid", foreignKey= @ForeignKey(name="Venue_ID_FK"))
    private Venue venue;
    
    
    @ManyToOne
    @JoinColumn(name="organizerid", foreignKey= @ForeignKey(name="ORGANIZER_ID_FK"))
    private Organizer organizer; 
    
   
    // EVENT is PARENT ENTITY OF USER
    @ManyToMany(fetch = FetchType.EAGER) //, cascade = {CascadeType.PERSIST, CascadeType.MERGE}   
    @JoinTable(name="Event_User",
      joinColumns={@JoinColumn(name="fk_event")},  // Parent
      inverseJoinColumns={@JoinColumn(name="fk_user")})     // Child                      
    private List<User> users = new ArrayList<User>();  
    
  
    
    /* 
    -------------------------------------------------------------------------------------------------------
    */
    
    
    // default constructor
    public Event() {}
    
    // Getter Setter
    public long getEventid() {
        return eventid;
    }

    public void setEventid(long eventid) {
        this.eventid = eventid;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

//    public Date getEventdate() {
//        return eventdate;
//    }
//
//    public void setEventdate(Date eventdate) {
//        this.eventdate = eventdate;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getSeats_available() {
        return seats_available;
    }

    public void setSeats_available(long seats_available) {
        this.seats_available = seats_available;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    public void addUser(User user){
        System.out.println("IN THE ADD USER METHOD OF EVENT POJO");
        users.add(user);
       // user.getEvents().add(this);
        System.out.println("IN THE ADD USER METHOD OF EVENT POJO -- after");
    }
    public void removeUser(User user){
        users.remove(user);
        user.getEvents().remove(this);
    }

    public Date getEventdate() {
        return eventdate;
    }

    public void setEventdate(Date eventdate) {
        this.eventdate = eventdate;
    }
    
    
}
