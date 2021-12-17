/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.eventmanagementsystem.controller;

import app.eventmanagementsystem.dao.OrganizerDAO;
import app.eventmanagementsystem.pojo.Organizer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;


/**
 *
 * @author aksha
 */
@Controller
public class OrganizerController {
    
   
    @GetMapping("/organizer/save.htm")
    public String saveOrganizerrGet(ModelMap model, Organizer organizer) { // this is a service method
        //formBackingObject
        //this is needed mainly for the update functionality.
        //We want to show old values so that the user could see the existing values
        
        //name of the model object must match the modelAttribute in the user-form view
        model.addAttribute("organizer", organizer);
        return "organizer-form";
    }
    
    @PostMapping("/organizer/save.htm")
    public String saveOrganizerPost(@ModelAttribute("organizer") Organizer organizer, BindingResult result, SessionStatus status, OrganizerDAO organizerdao) {

// ModelAttribute annotation is used to define Command Class for (SimpleFormController)
// "user" written there is Command Class Name, alias for (SimpleFormController)
// its name has to match with the modelattribute given in user-form.jsp view file

// we have used above UserDao userdao
// in order to use it: define a bean in application.conetxt.xml and then inject it into handler method 
// bean name/id should match the instance name 'userdao' 


//save the user instance using the dao class
        organizerdao.createOrganizer(organizer);
  
        String view = null;
        if (result.hasErrors()) //BindingResult
            view = "organizer-form";
        else {
            status.setComplete();
            view = "organizer-success";
        }
        return view;
    }
    
    @GetMapping("/organizer/search.htm")
    public String searchOrganizerGet() {
        
        return "";
    }
    
    @PostMapping("/organizer/search.htm")
    public String searchOrganizerPost() {
        
        return "";
    }
}


