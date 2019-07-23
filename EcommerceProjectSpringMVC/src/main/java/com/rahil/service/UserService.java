package com.rahil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rahil.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userdao;
	
	public boolean getUser(String username, String password)
	{
		return userdao.checkUser(username, password);
	}
	
	public boolean registerUser(String username, String password)
	{
		return userdao.registeringUser(username, password);
	}
	
}
