package com.rahil.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rahil.dao.ViewCartDAO;
import com.rahil.entities.CartBean;

@Service
public class ViewCartService {

	@Autowired
	private ViewCartDAO viewcartdao;
	
	public List<CartBean> getCart(String username)
	{
		return viewcartdao.getCart(username);
	}
	
}
