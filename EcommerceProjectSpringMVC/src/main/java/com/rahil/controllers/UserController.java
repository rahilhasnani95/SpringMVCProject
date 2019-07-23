package com.rahil.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.rahil.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	
	@RequestMapping("checkUser")
	public ModelAndView checkUser(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request)
	{	
		ModelAndView mv = new ModelAndView();
		
		if(username.equals("admin") && password.equals("admin123"))
		{	
			request.getSession().setAttribute("username", username);
			mv.setViewName("welcomeAdmin.jsp");
			mv.addObject("username", username);
			return mv;
		}
		else
		{ 
			if(userservice.getUser(username, password))
			{
				request.getSession().setAttribute("username", username);
				mv.setViewName("welcomeUser.jsp");
				mv.addObject("username", username);
				return mv;
			}
			else
			{
				mv.setViewName("index.jsp");
				mv.addObject("invalidcredentialsmsg", "Invalid Credentials!!! ");
				return mv;	
			}
		}
		
	}
	
}
