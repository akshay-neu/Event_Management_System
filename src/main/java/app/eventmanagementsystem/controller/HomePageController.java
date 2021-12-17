/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.eventmanagementsystem.controller;

import app.eventmanagementsystem.pojo.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aksha
 */
@Controller
public class HomePageController {
    
    
    public HomePageController(){
        
    }
    
    @RequestMapping(value="user.htm", method= RequestMethod.POST)
    protected ModelAndView handleRequestPost(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        ModelAndView mv = new ModelAndView();
        // throw new UnsupportedOperationException("Not yet implemented");
        
        // controller always initiate and populate the model
//        User user = new User();
//        user.setName(request.getParameter("userName"));

        String name = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String value = request.getParameter("action");
        System.out.println("111111" + value);
        
        if(value.equals("signup")) {
            mv.setViewName("homepage");
        }
   
        
        // request scope
//        request.setAttribute("msg", "a message from request scope");
        
        
        // ModelaAndView(view name, string model name, object model object)
//        mv.setViewName("homepage");
        // This modelandview instance returned from the controller will place the model in request scope
    
        return mv;
    }
    
}
