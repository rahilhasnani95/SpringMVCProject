package com.rahil.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.rahil.entities.CartBean;
import com.rahil.service.CartService;
import com.rahil.service.DeleteService;
import com.rahil.service.ViewCartService;

@Controller
public class CartController {
	
	@Autowired
	private ViewCartService viewcartservice;
	@Autowired
	private CartService cartservice;
	@Autowired
	private DeleteService deleteservice;
	
	@RequestMapping("ViewMyCart")
	public ModelAndView viewCart(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();

		String username = (String) request.getSession().getAttribute("username");
		
		List<CartBean> cartlist = viewcartservice.getCart(username);
		
		if(cartlist.isEmpty())
		{
			mv.addObject("emptycartmessage","Your cart is currenty empty! Please add items to cart");
			mv.setViewName("SeeProducts");
			return mv;
		}
		else
		{
			mv.addObject("cartlist", cartlist);
			mv.setViewName("mycart.jsp");
			return mv;			
		}
	}
	
	@RequestMapping("AddToCart")
	public ModelAndView addToCart(@RequestParam("qty") int qty, @RequestParam("itemid") int itemid, @RequestParam("itemname") String itemname, @RequestParam("itemprice") int itemprice, HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		
		String username = (String) request.getSession().getAttribute("username");
	
		cartservice.addCart(username, itemid, itemname, qty, itemprice);

		mv.addObject("addmessage","Added " + qty + " quantity of " + itemname);
		
		mv.setViewName("SeeProducts");
		return mv;
	}
	
	@RequestMapping("DeleteItem")
	public ModelAndView deleteFromCart(@RequestParam("itemid") int itemid, @RequestParam("itemname") String itemname, HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		
		String username = (String) request.getSession().getAttribute("username");
		
		deleteservice.deleteItem(username, itemid);

		mv.setViewName("ViewMyCart");
		
		return mv;
	}
	
}
