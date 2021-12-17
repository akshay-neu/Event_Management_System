/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.eventmanagementsystem.controller;

import app.eventmanagementsystem.dao.EventDAO;
import app.eventmanagementsystem.dao.UserDAO;
import app.eventmanagementsystem.pojo.Event;
import app.eventmanagementsystem.dao.VenueDAO;
import app.eventmanagementsystem.pojo.Organizer;
import app.eventmanagementsystem.pojo.User;
import app.eventmanagementsystem.pojo.Venue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aksha
 */
@Controller
public class EventController {

    @GetMapping("/event/save.htm")
    public String saveEventGet(ModelMap model, HttpServletRequest request) throws Exception { // this is a service method
        //formBackingObject
        //this is needed mainly for the update functionality.
        //We want to show old values so that the user could see the existing values

        Event event = new Event();
        
        //List<Venue> venuelist = venuedao.getVenueList();
        //model.addAttribute("venues", venuelist);
        //System.out.println(venuelist);
        //System.out.println(Arrays.toString(list.toArray()));
        
         VenueDAO venuedao = new VenueDAO();
         List<Venue> v = new ArrayList<Venue>();
         v = venuedao.getVenueList();
        model.addAttribute("venuelist", v);
        //request.getSession().setAttribute("venuelist", v);
        
        System.out.println("EVENT controller venues list created!");

        //name of the model object must match the modelAttribute in the user-form view
        model.addAttribute("event", event);

        return "event-form";
    }

//    	@GetMapping("/createevent.htm")
//	public ModelAndView registerEvent(@ModelAttribute("event") Event event, BindingResult result, SessionStatus status,Model model, HttpServletRequest request) {
//	
//            System.out.println("in createvent htm register EVENT!!!!!!!!!!");
//                    
//		ModelAndView mv = null;
//		String venueid = request.getParameter("venueId");
//                System.out.println("VENUE ID: " + venueid);
//		int vid = Integer.parseInt(venueid); 
//		VenueDAO venuedao = new VenueDAO();
//		Venue venue = venuedao.getVenuebyId(vid);
//		
//		mv = new ModelAndView("event-form", "venue", venue);
//		
//		return mv;
//	}
    @PostMapping("/event/save.htm")
    public void saveEventPost(Model model, BindingResult result, SessionStatus status, EventDAO eventdao, VenueDAO venuedao, HttpServletRequest request) {
// retrun STRING
// @ModelAttribute("event") Event event,
        
        
// ModelAttribute annotation is used to define Command Class for (SimpleFormController)
// "user" written there is Command Class Name, alias for (SimpleFormController)
// its name has to match with the modelattribute given in user-form.jsp view file
// we have used above UserDao userdao
// in order to use it: define a bean in application.conetxt.xml and then inject it into handler method 
// bean name/id should match the instance name 'userdao' 
//save the user instance using the dao class
            

//        HttpSession session = request.getSession();
//        Organizer organizersession = (Organizer) session.getAttribute("organizer");
//        event.setOrganizer(organizersession);
//
//        long venueidd = Long.parseLong(request.getParameter("venue"));
//        System.out.println("VENUE SELECTED: " + venueidd);
//        Venue venue = venuedao.getVenuebyId(venueidd);
//        event.setVenue(venue);
//        
//        eventdao.createEvent(event);
//
//        String view = null;
//        if (result.hasErrors()) {
//            System.out.println("I am here");//BindingResult
////            view = "event-form";}
//            view = "event-success";
//        } else {
//            status.setComplete();
//            view = "event-success";
//        }
//        return view;
//    }
    }


@RequestMapping(value = "/addeeventdetails", method = RequestMethod.POST)
	public ModelAndView addevent(Locale locale, Model model,HttpServletRequest request,  EventDAO eventdao) {
    
    
        System.out.println("IN THE EVENT CONTROLLER------------------------------------------");
        
                String eventname = request.getParameter("eventname");
		String details = request.getParameter("details");
                String venueidss = request.getParameter("venueid");
                String capacity_seat = request.getParameter("capacity");
                
                System.out.println("eventname : " + eventname);
                 System.out.println("details : " + details);
                  System.out.println("venueidss : " + venueidss);
                   System.out.println("capacity_seat : " + capacity_seat);
        
    
		HttpSession session = request.getSession();
		Organizer usersess = (Organizer)session.getAttribute("organizer");
	
		
		ModelAndView mv = null;
		Date eventdate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat tf = new SimpleDateFormat("yyyy-mm-dd");
		
		int capacity = Integer.parseInt(request.getParameter("capacity"));
                
		try {
			eventdate = sdf.parse(request.getParameter("eventdate"));
			System.out.println("Date from request"+eventdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        java.sql.Date sqlDate = new java.sql.Date(eventdate.getTime());
        System.out.println("Date after conversion"+sqlDate);
        
        
        // -------------------------------------------------------------------------------------
		String venueid = request.getParameter("venueid");
		int vid = Integer.parseInt(venueid);
		
		VenueDAO vd = new VenueDAO();
		Venue venue = vd.getVenuebyId(vid);
		
		  System.out.println("venue name: " + venue.getVenuename());
                  
		Set<Date> bookeddates = venue.getBookedDates();
		
                boolean flag = true;
                
                if(bookeddates != null){
                
		for(Date d:bookeddates) {
			
			String dt = tf.format(d);
			System.out.println("BookedDate "+d+" Event Date "+eventdate);
			if(dt.equals(tf.format(eventdate))) {
                            
                            System.out.println("DATES ARE ALREADYY BOOKEDD!!");
				flag = false;
				break;
			}
		}
		
                }
                else{
                    System.out.println("no booked dates for the venue!!!!");
                }
                
                
                
		if(flag) {
		EventDAO ed = new EventDAO();
		Event event = new Event();
		List<Event> events = new ArrayList<Event>();
		try {
			//event = ed.addEvent(eventname,details, eventdate, capacity, venue, usersess);
			//usersess.addCreatedEvent(event);
			  
                        event.setEventname(eventname);
                        event.setOrganizer(usersess);
                        event.setDetails(details);
                        event.setSeats_available(capacity);
                        event.setStatus("open");
                        event.setVenue(venue);
                        event.setEventdate(eventdate);
                        
                        
                        eventdao.createEvent(event);
                        
                          
			venue.addBookedDate(eventdate);
			vd.updateVenue(venue);
                        
                        
			events = ed.getEvents(usersess);
                        
			mv = new ModelAndView("usercreatedevents", "events",events);
			model.addAttribute("success", "Event Created Successfully");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv = new ModelAndView("usercreatedevents", "events",events);
			model.addAttribute("msg", "Event can not be added at this time");
		}
		}else {
		
		
			mv = new ModelAndView("event-form","booked", "Venue is not available at this date");
			//model.addAttribute("Message", "Event Created Successfully");
		}
		return mv;
	}

    @GetMapping("/event/search.htm")
    public String searchEventGet() {

        return "";
    }

    @PostMapping("/event/search.htm")
    public String searchEventPost() {

        return "";
    }

    @RequestMapping(value = "/viewallevents11.htm", method = RequestMethod.GET)
    public ModelAndView viewallevents(Locale locale, Model model, HttpServletRequest request) {

        ModelAndView mv = null;

        HttpSession session = request.getSession();
        User usersession = (User) session.getAttribute("user");

        EventDAO eventdao = new EventDAO();

        List<Event> events = new ArrayList<Event>();
        events = eventdao.getAllEvents();

        List<Event> sevents = new ArrayList<Event>();

        for (Event e : events) {
            System.out.println("status " + e.getStatus());
            if (e.getStatus().equalsIgnoreCase("open")) {
                sevents.add(e);
            }
        }
        mv = new ModelAndView("event-list", "events", sevents);

        return mv;
    }

        @RequestMapping(value = "/viewallevents.htm", method = RequestMethod.GET)
    public ModelAndView viewyetRegisterevents(Locale locale, Model model, HttpServletRequest request) {

        ModelAndView mv = null;

        HttpSession session = request.getSession();
        User usersession = (User) session.getAttribute("user");
        List<Event> events2 = new ArrayList<Event>();
        events2 = usersession.getEvents();
        
        
        EventDAO eventdao = new EventDAO();
        List<Event> events = new ArrayList<Event>();
        events = eventdao.getAllEvents();

        List<Event> sevents = new ArrayList<Event>();

        for (Event e : events) {
            System.out.println("status " + e.getStatus());
            if (e.getStatus().equalsIgnoreCase("open")) {
                sevents.add(e);
            }
        }
        
        for(Event e: sevents){
            for(Event f: events2){
                 if(e.getEventid() == f.getEventid()  ){
                    sevents.remove(e);
                 }
            } 
        }
        
        
        mv = new ModelAndView("event-list", "events", sevents);

        return mv;
    }
    
    
    
    
    
    
    
    
    @RequestMapping(value = "/registerevent.htm", method = RequestMethod.POST)
    public ModelAndView registerforevent(Locale locale, Model model, HttpServletRequest request) {

        
        System.out.println("register for event method---------------------");
        
       String eventidreg = request.getParameter("eventid");
        System.out.println("EVENT ID REGISTERED : " + eventidreg);
        
        ModelAndView mv = null;

        HttpSession session = request.getSession();
        User usersess = (User) session.getAttribute("user");

        System.out.println("User" + usersess.getEmailid());
        System.out.println("register for event method---------------------");

        System.out.println("Event id   " + request.getParameter("eventid"));
        int eventid = Integer.parseInt(request.getParameter("eventid"));

        UserDAO ud = new UserDAO();
        EventDAO ed = new EventDAO();

        Event event = ed.getEventbyid(eventid);
        System.out.println("Event details: " + event.getDetails());
        
        List<Event> events = new ArrayList<Event>();
        events = usersess.getEvents();
//                System.out.println("events" + events.get(0).getEventname());
        System.out.println("Hi");
//		System.out.println("Value of If statement ="+events.contains(event));
        boolean flag = false;
        if (events != null) {
            for (Event e : events) {
                if (e.getEventid() == eventid) { 
                    flag = true; // already registered
                }
            }
        }else{
            System.out.println("EVENTS-USERS NULL!!!!");
        }
        
        
        System.out.println("*****1");
        
        if (flag) {
            System.out.println("*****2");
            mv = new ModelAndView("registeredevents", "events", events);
            model.addAttribute("registered", "Event is already registered");
            System.out.println("*****3");
        } else {
            System.out.println("*****4");
            
            event.setSeats_available(event.getSeats_available() - 1);
            System.out.println("111");

         event.addUser(usersess);
            System.out.println("222");
           
             usersess.addEvent(event);
            System.out.println("*****5");

            try {
                System.out.println("****6");
                ud.updateUser(usersess);
                ed.updateEvent(event);
                System.out.println("*****7");
                //System.out.println("Size of registered set"+usersess.getEvents_registered().size());

                events = usersess.getEvents();
                mv = new ModelAndView("registeredevents", "events", events);
                model.addAttribute("registered", "Event registered successfully");
                System.out.println("*****8");

            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println("*****9");
                events = usersess.getEvents();
                e.printStackTrace();
                mv = new ModelAndView("registeredevents", "events", events);
                model.addAttribute("registered", "Event is already registered");
            }
        }
        return mv;
    }
    
    
    
    @RequestMapping(value = "/userregisteredevents", method = RequestMethod.GET)
	public ModelAndView userregisteredevents(Locale locale, Model model,HttpServletRequest request) {
		
		
		ModelAndView mv = null;
		
		HttpSession session = request.getSession();
		User usersess = (User)session.getAttribute("user");
		EventDAO ed = new EventDAO();
		
		Set<Event> events = new HashSet<Event>();
		events = (Set<Event>) usersess.getEvents(); // user registered events
		//List<Event> events = ed.getEvents(usersess);
		
		
		mv = new ModelAndView("registeredevents", "events",events);
		
		return mv;
	}
	
}
