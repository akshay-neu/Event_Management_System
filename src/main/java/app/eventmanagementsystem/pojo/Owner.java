/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.eventmanagementsystem.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author aksha
 */
@Entity
@Table(name="ownertable")
public class Owner {
    
    // variables
        @Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="ownerid")
        private long ownerid;
        
        @Basic
        @Column(name="ownername")
	private String ownername;
                
        @Column(unique = true)
	private String emailid;
        
        @Basic
        @Column(name="password")
	private String password;
        
        // foreign key
//        @OneToMany(mappedBy = "owner",fetch = FetchType.EAGER,cascade=CascadeType.ALL)
//	private Set<Venue> venues = new HashSet<Venue>();

        
    /* 
    -------------------------------------------------------------------------------------------------------
    */
    
        
        
        
        // default constructor
        public Owner(){}
        
        
        // Getter Setter
    public long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
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

//    public Set<Venue> getVenues() {
//        return venues;
//    }
//
//    public void setVenues(Set<Venue> venues) {
//        this.venues = venues;
//    }
//    
//    public void addVenue(Venue venue) {
//	venues.add(venue);
//    }
}
