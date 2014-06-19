package com.thesischecker.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 
 * @author Sadek
 * 
 */  
@Controller  
public class LoginController {  
   
	 @RequestMapping(value="/index", method = RequestMethod.GET)  
	 public String executeSecurity(ModelMap model, Principal principal ) {  
	   
		 String name = principal.getName();  
		 model.addAttribute("author", name);  
		 model.addAttribute("message", "Message");  
		 return "test/index";  
	 }  
	   
	 @RequestMapping(value="/login", method = RequestMethod.GET)  
	 public String login(ModelMap model) {  
		 return "login/login";  
	 }  
	   
	 @RequestMapping(value="/fail2login", method = RequestMethod.GET)  
	 public String loginerror(ModelMap model) {  
	   
		 model.addAttribute("error", "true");  
		 return "login/login";  
	 }  
	   
	 @RequestMapping(value="/logout", method = RequestMethod.GET)  
	 public String logout(ModelMap model) {  
	   
		return "login/login";  
	 }  
}  