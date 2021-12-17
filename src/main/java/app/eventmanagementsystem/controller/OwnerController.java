/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.eventmanagementsystem.controller;

import app.eventmanagementsystem.dao.OwnerDAO;
import app.eventmanagementsystem.pojo.Owner;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author aksha
 */
@Controller
public class OwnerController {
    

    @GetMapping("/owner/save.htm")
    public String saveOwnerGet(ModelMap model, Owner owner) { // this is a service method
        //formBackingObject
        //this is needed mainly for the update functionality.
        //We want to show old values so that the user could see the existing values
        
        //name of the model object must match the modelAttribute in the user-form view
        model.addAttribute("owner", owner);
        return "owner-form";
    }
    
    @PostMapping("/owner/save.htm")
    public String saveOwnertPost(@ModelAttribute("owner") Owner owner, BindingResult result, SessionStatus status, OwnerDAO ownerdao) {

// ModelAttribute annotation is used to define Command Class for (SimpleFormController)
// "user" written there is Command Class Name, alias for (SimpleFormController)
// its name has to match with the modelattribute given in user-form.jsp view file

// we have used above UserDao userdao
// in order to use it: define a bean in application.conetxt.xml and then inject it into handler method 
// bean name/id should match the instance name 'userdao' 


//save the user instance using the dao class
        ownerdao.createOwner(owner);
  
        String view = null;
        if (result.hasErrors()) //BindingResult
            view = "owner-form";
        else {
            status.setComplete();
            view = "owner-success";
        }
        return view;
    }
    
    @GetMapping("/owner/search.htm")
    public String searchOwnerGet() {
        
        return "";
    }
    
    @PostMapping("/owner/search.htm")
    public String searchOwnerPost() {
        
        return "";
    }
    
    
    @RequestMapping(value = "/owner/dashboard.htm", method = RequestMethod.GET)
	public String ownerdashboard(Locale locale, Model model,HttpServletRequest request) {
		      System.out.println("CALL FOR OWNER DASHBOARD RETURN!!");
		return "owner-dashboard";
	}
}



