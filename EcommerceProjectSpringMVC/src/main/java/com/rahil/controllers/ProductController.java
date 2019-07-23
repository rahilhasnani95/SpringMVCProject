package com.rahil.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.rahil.entities.ProductBean;
import com.rahil.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productservice;
	
	@RequestMapping("SeeProducts")
	public ModelAndView getProducts()
	{	
		ModelAndView mv = new ModelAndView();

		List<ProductBean> productlist = productservice.getprod();
		
		if(productlist.isEmpty())
		{
			mv.setViewName("Noproduct.jsp");
			return mv;
		}
		else
		{
			mv.addObject("productlist", productlist);
			mv.setViewName("product.jsp");
			return mv;
		}
	}
	
	@RequestMapping("SeeAllProductsAdmin")
	public ModelAndView getAllProductsForAdmin()
	{	
		ModelAndView mv = new ModelAndView();

		List<ProductBean> allprodlist = productservice.getAllprodforadmin();
		
		if(allprodlist.isEmpty())
		{
			mv.setViewName("Noproduct.jsp");
			return mv;
		}
		else
		{
			mv.addObject("allprodlist", allprodlist);
			mv.setViewName("Admin.jsp");
			return mv;
		}
	}
	
	
	
}
