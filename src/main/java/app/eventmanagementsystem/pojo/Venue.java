package app.eventmanagementsystem.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
import javax.persistence.Table;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aksha
 */
@Entity
@Table(name="venuetable")
public class Venue {
    
    @Id
    @Column(name="venueid")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long venueid;

    @Column(unique = true)
    private String venuename;
    
    @Basic
    @Column(name="address")
    private String address;
    
    @Basic
    @Column(name="capacity")
    private long capacity;
    
//    // not yet mapped
//    private Set<Date> bookedDates = new HashSet<Date>();
//   
    
    
    @ElementCollection(fetch = FetchType.EAGER)
	@Column(name="bookeddate")
	private Set<Date> bookedDates = new HashSet<Date>();
	
    
    @ManyToOne
    @JoinColumn(name="ownerid", foreignKey= @ForeignKey(name="Owner_ID_FK"))
    private Owner owner;
    
  
    
    /* 
    -------------------------------------------------------------------------------------------------------
    */
    
    // default constructor
    public Venue(){}
    
    
    // Getter Setter
    public long getVenueid() {
        return venueid;
    }

    public void setVenueid(long venueid) {
        this.venueid = venueid;
    }

    public String getVenuename() {
        return venuename;
    }

    public void setVenuename(String venuename) {
        this.venuename = venuename;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

//    public Set<Date> getBookedDates() {
//        return bookedDates;
//    }
//
//    public void setBookedDates(Set<Date> bookedDates) {
//        this.bookedDates = bookedDates;
//    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

//    public Set<Event> getEvents() {
//        return events;
//    }
//
//    public void setEvents(Set<Event> events) {
//        this.events = events;
//    }

    public Set<Date> getBookedDates() {
        return bookedDates;
    }

    public void setBookedDates(Set<Date> bookedDates) {
        this.bookedDates = bookedDates;
    }
    public void addBookedDate(Date d) {
		bookedDates.add(d);
	}
	
	public void removeBookedDate(Date d) {
		bookedDates.remove(d);
	}
    
}
