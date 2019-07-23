package com.rahil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rahil.dao.CartDAO;

@Service
public class CartService {

	@Autowired
	private CartDAO cartdao;
	
	public void addCart(String username, int itemid,String itemname, int qty, int itemprice)
	{	
		  cartdao.addToCart(username, itemid, itemname, qty, itemprice);
	}
	
}
