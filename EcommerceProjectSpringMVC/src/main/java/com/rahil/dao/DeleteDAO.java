package com.rahil.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;
import com.rahil.entities.CartBean;
import com.rahil.entities.CartBeankPK;

@Repository
public class DeleteDAO {
	
	public void deleteItem(String username, int itemid)
	{
		EntityManager em = null;
		try
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateproject");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			CartBeankPK cpk = new CartBeankPK(username, itemid);
			
			CartBean c = em.find(CartBean.class, cpk);
			
			if(c!= null)
			{
				em.remove(c);
				em.getTransaction().commit();
				System.out.println("deleted");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally
		{
			em.close();
		}
	}
	
}
