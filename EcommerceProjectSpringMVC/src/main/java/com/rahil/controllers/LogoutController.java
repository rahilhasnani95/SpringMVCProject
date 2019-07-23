package com.rahil.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping("Logout")
	public ModelAndView logout(HttpServletRequest request)
	{	
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		
		mv.setViewName("index.jsp");
		return mv;
	}
		
	
}
