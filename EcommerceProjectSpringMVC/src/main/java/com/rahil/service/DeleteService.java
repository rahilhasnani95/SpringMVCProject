package com.rahil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rahil.dao.DeleteDAO;

@Service
public class DeleteService {

	@Autowired
	private DeleteDAO deletedao;
	
	public void deleteItem(String username, int itemid)
	{
		deletedao.deleteItem(username, itemid);
	}
	
	
}
