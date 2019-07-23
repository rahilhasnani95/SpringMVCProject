package com.rahil.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.rahil.entities.UserBean;

@Repository
public class UserDAO {
	
	public boolean registeringUser(String username, String password)
	{
		EntityManager em = null;
		  boolean rowinserted= false;	 
		try
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateproject");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			if((rowinserted == false))
			{
				em.persist(new UserBean(username, password));
				em.getTransaction().commit();
				
				rowinserted = true;
				return rowinserted;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return rowinserted;
	}

	public boolean checkUser(String username, String password)
	{
		EntityManager em = null;
		try
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateproject");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			Query q = em.createQuery("select u from UserBean u where u.username =?1 and u.password =?2");
			q.setParameter(1, username);
			q.setParameter(2, password);
			
			List list = q.getResultList();
			if(!list.isEmpty())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			em.close();
		}
		
	return false;
	}
	
}
