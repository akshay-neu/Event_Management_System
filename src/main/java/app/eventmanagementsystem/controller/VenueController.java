/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.eventmanagementsystem.controller;

import app.eventmanagementsystem.dao.VenueDAO;
import app.eventmanagementsystem.pojo.Owner;
import app.eventmanagementsystem.pojo.Venue;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aksha
 */
@Controller
public class VenueController {
    

    @GetMapping("/venue/save.htm")
    public String saveVenueGet(ModelMap model) { // this is a service method
        //formBackingObject
        //this is needed mainly for the update functionality.
        //We want to show old values so that the user could see the existing values
        
        //name of the model object must match the modelAttribute in the user-form view
        Venue venue = new Venue(); // form backing obj
        model.addAttribute("venue", venue);
        System.out.println("BRING THE VENUE-FORM UP!!");
        return "venue-form";
    }
    
    @PostMapping("/venue/save.htm")
    public String saveVenuePost(@ModelAttribute("venue") Venue venue,HttpServletRequest request, BindingResult result, SessionStatus status, VenueDAO venuedao) {

// ModelAttribute annotation is used to define Command Class for (SimpleFormController)
// "user" written there is Command Class Name, alias for (SimpleFormController)
// its name has to match with the modelattribute given in user-form.jsp view file

// we have used above UserDao userdao
// in order to use it: define a bean in application.conetxt.xml and then inject it into handler method 
// bean name/id should match the instance name 'userdao' 


//save the user instance using the dao class


    System.out.println("IN THE CREATE VENUE");
        
        HttpSession session = request.getSession();
        System.out.println("request session!!");
        Owner ownersession = (Owner) session.getAttribute("owner");
        System.out.println("Owner session!!");
        System.out.println(":: " + ownersession.getOwnerid());
        System.out.println("In Create Venue -- Owner Name : " + ownersession.getOwnername() );


        venue.setOwner(ownersession);

        venuedao.createVenue(venue);
  
        String view = null;
        if (result.hasErrors()) //BindingResult
            view = "venue-form";
        else {
            status.setComplete();
            
            view = "owner-dashboard"; // venue-success
        }
        return view;
    }
    
    @GetMapping("/venue/search.htm")
    public String searchvenueGet() {
        
        return "";
    }
    
    @PostMapping("/venue/search.htm")
    public String searchVenuePost() {
        
        return "";
    }
    
    
    @GetMapping("/venuelist.htm")
    public ModelAndView allvenuesforevents(Locale locale, Model model,HttpServletRequest request) throws Exception {
		
		ModelAndView mv = null;
                VenueDAO venuedao = new VenueDAO();
                List<Venue> venues = venuedao.getVenueList();
                //model.addAttribute("venues", venues);
	
		//VenueDAO vd = new VenueDAO();
		//List<Venue> v= new ArrayList<Venue>();
		//v = vd.getVenues();
		mv = new ModelAndView("venues-list", "venues", venues);
		return mv;
	}
    
    @GetMapping("/updatevenue.htm")
     public String updateVenueGet (Locale locale, Model model,HttpServletRequest request, VenueDAO venuedao) throws Exception {
		
         ModelAndView mv = null;
         Venue venue = new Venue();
       // VenueDAO venuedao = new VenueDAO();
         
         String updateButton = request.getParameter("update");
         String DeleteButton = request.getParameter("delete");
         String venueidupdatestring = request.getParameter("venueidupdate");
         String venueiddeletestring = request.getParameter("venueiddelete");
         
         System.out.println("1:" + updateButton);
         System.out.println("2:" + DeleteButton);
         System.out.println("3:" + venueidupdatestring);
         System.out.println("4:" + venueiddeletestring);
         
         if( updateButton !=null && !venueidupdatestring.isEmpty() &&updateButton.equalsIgnoreCase("update")){
             
             System.out.println("there!!!!!!!!");
             mv = new ModelAndView("owner-dashboard");
            model.addAttribute("errorselection", "Please select one operation!");
            
        System.out.println("VENUE ID TO BE UPDATED : " + venueidupdatestring);
        long venueid = Long.parseLong(venueidupdatestring);
        
        
        venue = venuedao.getVenuebyId(venueid);
		
               // mv = new ModelAndView("update-venue");
                //mv.addObject("venue", venue);
                model.addAttribute("venue", venue);
		return "update-venue";
         
         }
        else if(DeleteButton!=null && !venueiddeletestring.isEmpty() && DeleteButton.equalsIgnoreCase("Delete") ){
                long venueid = Long.parseLong(venueiddeletestring);
                venue = venuedao.getVenuebyId(venueid);
                venuedao.deleteVenue(venue);
         
                
                
                return "owner-dashboard";
         }
        else {
            return "owner-dashboard";
        }
             
	}
     
     
     @GetMapping("/updatevenueq.htm")
     public String updateVenueQGet (Locale locale, Model model,HttpServletRequest request, VenueDAO venuedao) throws Exception {
	
         String venueidstring = request.getParameter("venueid");
         System.out.println("Venue ID selected for operation : " + venueidstring);
         
         if( venueidstring != null) {
         
         
         long venueid = Long.parseLong(venueidstring);
        
         Venue venue = new Venue();
         venue = venuedao.getVenuebyId(venueid);
               
         String updateButton = request.getParameter("update");
         String DeleteButton = request.getParameter("delete");
         
        if( updateButton !=null && updateButton.equalsIgnoreCase("update")){
            
            model.addAttribute("venue", venue);
            return "update-venue";
        }
         
        if(DeleteButton!=null && DeleteButton.equalsIgnoreCase("Delete") ){
             venuedao.deleteVenue(venue);
             return "owner-dashboard";
        }
        }
        
        return "owner-dashboard";
     
     } 
     
         @PostMapping("/updatevenueq.htm")
         @ResponseStatus(value=HttpStatus.OK)
     public String updateVenuePost (@ModelAttribute("venue") Venue venue, Locale locale, Model model,HttpServletRequest request, VenueDAO venuedao) throws Exception {
		           System.out.println("UPDATE VENUE POST CALL!!!");
         HttpSession session = request.getSession();
        Owner ownersession = (Owner) session.getAttribute("owner");
        venue.setOwner(ownersession);
        
         venuedao.updateVenue(venue);
         
     return "owner-dashboard";
        
	
	}
    
    
    
}




