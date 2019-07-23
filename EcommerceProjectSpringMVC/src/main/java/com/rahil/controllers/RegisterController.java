package com.rahil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.rahil.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping("registerUser")
	public ModelAndView checkUser(@RequestParam("username") String username, @RequestParam("password") String password)
	{	
		ModelAndView mv = new ModelAndView();

		boolean rowsreturned = userservice.registerUser(username, password);

		if(rowsreturned)
		{
			mv.setViewName("index.jsp");
			mv.addObject("regsuccessmsg", "Registration Successfull!! Please Login and Shop ");
			return mv;
		}
		else
		{
			mv.setViewName("register.jsp");
			mv.addObject("userexistsmessage", "Username " + username + " already exists! Please select a unique username");
			return mv;
		}
		
	}
}
