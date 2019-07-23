package com.rahil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rahil.dao.CheckoutDAO;

@Service
public class CheckoutService {

	@Autowired
	private CheckoutDAO checkoutdao;
	
	public int checkItemsinCartButNotinProducts(String username)
	{
		return checkoutdao.checkAnyItemInCartNotInStock(username);
	}
	
	public int checkout1(String username)
	{
		return checkoutdao.updateProducts(username);
	}
	
	public int checkout2(String username)
	{
		return checkoutdao.removeDetailsFromCart(username);
	}
	
}
