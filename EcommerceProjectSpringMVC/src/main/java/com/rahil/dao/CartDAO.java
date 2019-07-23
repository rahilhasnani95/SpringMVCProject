package com.rahil.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;
import com.rahil.entities.CartBean;
import com.rahil.entities.CartBeankPK;

@Repository
public class CartDAO {

	public void addToCart(String username, int itemid, String itemname, int qty, int itemprice)
	{	
		int totalprice = itemprice*qty;
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
				//update
				c.setItemquantity(qty);
				c.setTotalprice(totalprice);
				em.getTransaction().commit();
				System.out.println("updated my cart");
			}
			else
			{
				CartBean c1 = new CartBean();
				c1.setItemid(itemid);
				c1.setItemname(itemname);
				c1.setItemquantity(qty);
				c1.setTotalprice(totalprice);
				c1.setUsername(username);
				
				em.persist(c1);
				em.getTransaction().commit();
				System.out.println("inserted in mycart");
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

