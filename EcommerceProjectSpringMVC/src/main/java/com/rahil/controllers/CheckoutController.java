package com.rahil.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.rahil.entities.CartBean;
import com.rahil.service.CheckoutService;
import com.rahil.service.ViewCartService;

@Controller
public class CheckoutController {

	@Autowired
	private CheckoutService checkoutservice;
	@Autowired
	private ViewCartService viewcartservice;
	
	@RequestMapping("Checkout")
	public ModelAndView checkOut(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView();
		
		String username = (String) request.getSession().getAttribute("username");

		int noofrowsreturnedfromcheckitem =	checkoutservice.checkItemsinCartButNotinProducts(username);
			
		if(noofrowsreturnedfromcheckitem > 0)
		{
			mv.setViewName("ViewMyCart");
			mv.addObject("itemsoldoutmessage","One of the items in your cart is sold out! Please update your cart for checkout");
			return mv;	
		}
		else
		{
			List<CartBean> cartlist = viewcartservice.getCart(username);
			int rowsreturnedfromupdateproducts = checkoutservice.checkout1(username);
			int rowsreturnedfromdeletefromcart = checkoutservice.checkout2(username);
			
			if(rowsreturnedfromdeletefromcart  >=1 && rowsreturnedfromupdateproducts >=1)
			{
				int finalbill = Integer.parseInt(request.getParameter("finaltotalbill"));
	
				mv.addObject("finalbillmessage","Your Bill Amount is : $" + finalbill + " ! Thank you for Shopping with us!");
				mv.addObject("purchasemsg","You Purchased the following items");
				mv.addObject("cartlist", cartlist);
				mv.setViewName("mypurchases.jsp");
				return mv;
	
			}
			else 
			{ 
				mv.addObject("cantcheckoutmessage","You can not checkout with empty cart! Please add items to cart");
				mv.setViewName("ViewMyCart");
				return mv;
			}
		}
	}
	
}
