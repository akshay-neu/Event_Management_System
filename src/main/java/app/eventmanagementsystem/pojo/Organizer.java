/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.eventmanagementsystem.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author aksha
 */
@Entity
@Table(name="organizertable")
public class Organizer {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="organizerid")
    private long organizerid;
    
    @Basic
    @Column(name="organizername")
    private String organizername;
    
    @Column(unique = true)
    private String emailid;
        
    @Basic
    @Column(name="password")
    private String password;
    
//    @ManyToMany(mappedBy = "events_created",fetch = FetchType.EAGER)
//    private Set<Event> eventCreated = new HashSet<Event>(); // events created
//    
    
    /* 
    -------------------------------------------------------------------------------------------------------
    */
    
    
    // default constructor
    public Organizer() {}

    // Getter Setter

    public long getOrganizerid() {
        return organizerid;
    }

    public void setOrganizerid(long organizerid) {
        this.organizerid = organizerid;
    }

    public String getOrganizername() {
        return organizername;
    }

    public void setOrganizername(String organizername) {
        this.organizername = organizername;
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

//    public Set<Event> getEventCreated() {
//        return eventCreated;
//    }
//
//    public void setEventCreated(Set<Event> eventCreated) {
//        this.eventCreated = eventCreated;
//    }
}
