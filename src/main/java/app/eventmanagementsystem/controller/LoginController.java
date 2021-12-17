/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.eventmanagementsystem.controller;

import app.eventmanagementsystem.dao.EventDAO;
import app.eventmanagementsystem.dao.OrganizerDAO;
import app.eventmanagementsystem.dao.OwnerDAO;
import app.eventmanagementsystem.dao.UserDAO;
import app.eventmanagementsystem.dao.VenueDAO;
import app.eventmanagementsystem.pojo.Event;
import app.eventmanagementsystem.pojo.Home;
import app.eventmanagementsystem.pojo.Organizer;
import app.eventmanagementsystem.pojo.Owner;
import app.eventmanagementsystem.pojo.User;
import app.eventmanagementsystem.pojo.Venue;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aksha
 */
@Controller
public class LoginController {

    @GetMapping("/login.htm")
    public String loginGet(Model model, Home home) { // this is a service method
        //formBackingObject
        //this is needed mainly for the update functionality.
        //We want to show old values so that the user could see the existing values

        //name of the model object must match the modelAttribute in the user-form view
        model.addAttribute("home", home);
        return "login-form";
    }

    @PostMapping("/login.htm")
    public ModelAndView loginPost(@ModelAttribute("home") Home home, Model model, BindingResult result, SessionStatus status, HttpServletRequest request) {

        //save the user instance using the dao class
//        userdao.createUser(user);
        ModelAndView mv = null;
        HttpSession session = request.getSession();

        String emailid = request.getParameter("emailid");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

//        System.out.println("emailid: " + emailid);
//        System.out.println("password: " + password);
//        System.out.println("role: " + role);
//        System.out.println("111");
//        String role_v = role;
   //     System.out.println("222");
      //  if(role_v==null)
        

        System.out.println("just before the if condition-----------");
        if (!emailid.isEmpty() && !password.isEmpty() && role!=null ) {
            System.out.println("in the if condition block");
// USER ----------------------------------------------------------------------------------------    
            if (role.equalsIgnoreCase("user")) {

                User loggedUser = null;
                UserDAO userdao = new UserDAO();

                try {
                    loggedUser = userdao.getUser(emailid, password);
                } catch (Exception e) {
                    System.out.println("ERROR CATCH");
//                    mv = new ModelAndView("index");
//                    model.addAttribute("invalidUser", "Invalid credentials");
//                    
            System.out.println("ID-PASSWORD not matched!!");
            mv = new ModelAndView("login-form");
            model.addAttribute("notmatched", "Please enter correct credentials!");
   
                }

                if (loggedUser != null) {
                    session.setAttribute("user", loggedUser);
                    //status.setComplete();
       
                    mv = new ModelAndView("user-dashboard");
                    mv.addObject("user", loggedUser);
                    
                    // -------------------------------------------------------------------------
                    
                 
		EventDAO eventdao = new EventDAO();
		
		List<Event> events = new ArrayList<Event>();
		events =  loggedUser.getEvents(); // user registered events
                
                model.addAttribute("events", events);
                    
                    
                    
                } else {
                   // mv = new ModelAndView("index");
                   // model.addAttribute("invalidUser", "Invalid credentials");
                     System.out.println("ID-PASSWORD not matched!!");
            mv = new ModelAndView("login-form");
            model.addAttribute("notmatched", "Please enter correct credentials!");
   
                }
            } 
// ORGANIZER ----------------------------------------------------------------------------------------
            else if (role.equalsIgnoreCase("organizer")) {
                Organizer loggedUser = null;
                OrganizerDAO organizerdao = new OrganizerDAO();
                try {
                    loggedUser = organizerdao.getOrganizer(emailid, password);
                } catch (Exception e) {
                   // mv = new ModelAndView("index", "invalidUser", "Invalid credentials");
                    System.out.println("ID-PASSWORD not matched!!");
            mv = new ModelAndView("login-form");
            model.addAttribute("notmatched", "Please enter correct credentials!");
   
                }

                if (loggedUser != null) {
                    session.setAttribute("organizer", loggedUser);
                   // model.addAttribute("msg", "Login Successfull");
                            mv = new ModelAndView("organizer-dashboard");
                    mv.addObject("organizer", loggedUser);
                    
                   // mv = new ModelAndView("organizer-dashboard", "message", "Welcome " + loggedUser.getOrganizername() + " to The Adda");
                } else {
                    //mv = new ModelAndView("index", "invalidUser", "Invalid credentials");
                     System.out.println("ID-PASSWORD not matched!!");
            mv = new ModelAndView("login-form");
            model.addAttribute("notmatched", "Please enter correct credentials!");
   
                }
            } 
// OWNER --------------------------------------------------------------------------------------
            else if (role.equalsIgnoreCase("owner")) {
                System.out.println("IN THE OWNER -- LOGIN CONTROLLER");
                Owner loggedUser = null;
                OwnerDAO ownerdao = new OwnerDAO();
                System.out.println("IN THE OWNER LOGIN CONTROLLER");
                try {
                     System.out.println("IN THE OWNER -- TRY ");
                    loggedUser = ownerdao.getOwner(emailid, password);
                } catch (Exception e) {
                     System.out.println("IN THE OWNER -- CATCH");
                   // mv = new ModelAndView("index", "invalidUser", "Invalid credentials");
                    System.out.println("ID-PASSWORD not matched!!");
            mv = new ModelAndView("login-form");
            model.addAttribute("notmatched", "Please enter correct credentials!");
   
                }

                if (loggedUser != null) {
           
                    session.setAttribute("owner", loggedUser);
                   
                 //   mv = new ModelAndView("owner-dashboard", "message", "Welcome " + loggedUser.getOwnername() + " to The Adda");
                    
                       mv = new ModelAndView("owner-dashboard");
                   
                       mv.addObject("owner", loggedUser);
                  
                    VenueDAO venuedao = new VenueDAO();
                    List<Venue> v = new ArrayList<Venue>();
                    v = venuedao.getVenuebyOwner(loggedUser);
                    
                    //model.addAttribute("venuelist", v);
                    //**************************************************************
                    request.getSession().setAttribute("venuelist", v);
                    
                    
                } else {
                   // mv = new ModelAndView("index", "invalidUser", "Invalid credentials");
                    System.out.println("ID-PASSWORD not matched!!");
            mv = new ModelAndView("login-form");
            model.addAttribute("notmatched", "Please enter correct credentials!");
   
                }
            }
// ELSE --------------------------------------------------------------------------------------
        } 
        else {
            System.out.println("login credentials not entered!!");
            mv = new ModelAndView("login-form");
            model.addAttribute("nocredentials", "Please enter credentials!");
        }
        return mv;
    }
    
    
	// Logout 
	@RequestMapping("/logout.htm")
	public ModelAndView getLogout(HttpSession session){
            System.out.println("IN LOG OUT Method");
		session.invalidate();
                System.out.println("Session ended, modelview will be returned");
		ModelAndView model = new ModelAndView("redirect:/login.htm");
		return model;
	}
}
