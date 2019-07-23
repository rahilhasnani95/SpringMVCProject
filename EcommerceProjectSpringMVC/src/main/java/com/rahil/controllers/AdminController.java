package com.rahil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.rahil.service.ProductService;

@Controller
public class AdminController {

	@Autowired
	private ProductService productservice;
	
	@RequestMapping("updateProductAdmin")
	public ModelAndView updateQuantityOfProducts(@RequestParam("itemid") int itemid, @RequestParam("qty") int quantity)
	{	
		ModelAndView mv = new ModelAndView();		
		
		productservice.updateQuantityofProducts(itemid, quantity);
		
		mv.setViewName("SeeAllProductsAdmin");
		mv.addObject("adminupdatemsg","Updated quantity of itemid " + itemid + " to " + quantity +"!!");
		return mv;		
	}	
	
	@RequestMapping("addNewProduct")
	public ModelAndView addNewProduct(@RequestParam("itemname")String itemname,@RequestParam("itemprice")int itemprice,@RequestParam("itemquantity")int itemquantity)
	{	
		ModelAndView mv = new ModelAndView();		
				
		productservice.addNewProduct(itemname, itemprice, itemquantity);
		
		mv.setViewName("addproductadmin.jsp");
		mv.addObject("adminaddproductmsg","Added New Product " + itemname +"!!");
		return mv;
	}
	
	
}
