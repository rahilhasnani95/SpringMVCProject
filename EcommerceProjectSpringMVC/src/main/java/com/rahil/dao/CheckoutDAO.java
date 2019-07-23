package com.rahil.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CheckoutDAO {

	public int checkAnyItemInCartNotInStock(String username)
	{
		EntityManager em = null;
		int newqty =0; 
		int noofrowsincheckitemexist = 0;
		try
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateproject");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			int qntincart = 0;int qntinitems = 0;

			Query q = em.createQuery("select c.itemid, c.itemquantity from CartBean c where c.username =?1");
			q.setParameter(1, username);

			List list = q.getResultList();

			for(int i = 0; i< list.size(); i++)
			{
				Object[] obj = (Object[]) list.get(i);

				int id = (Integer) obj[0];
				qntincart = (Integer) obj[1];

				Query q2 = em.createQuery("select p.itemquantity from ProductBean p where p.itemid =?1");
				q2.setParameter(1, id);

				qntinitems = (Integer) q2.getSingleResult();
				newqty = qntinitems - qntincart;
				if(newqty < 0)
				{
					++noofrowsincheckitemexist;
					return noofrowsincheckitemexist;
				}		
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally
		{
			em.close();
		}
		return noofrowsincheckitemexist;

	}	

	public int updateProducts(String username)
	{
		EntityManager em = null;
		int newqty =0; 	int noofrowsupdated = 0;
		int qntincart = 0;int qntinitems = 0;
		try
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateproject");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			Query q = em.createQuery("select c.itemid, c.itemquantity from CartBean c where c.username =?1");
			q.setParameter(1, username);

			List list = q.getResultList();

			for(int i = 0; i< list.size(); i++)
			{
				Object[] obj = (Object[]) list.get(i);

				int id = (Integer) obj[0];
				qntincart = (Integer) obj[1];

				Query q2 = em.createQuery("select p.itemquantity from ProductBean p where p.itemid =?1");
				q2.setParameter(1, id);

				qntinitems = (Integer) q2.getSingleResult();
				newqty = qntinitems - qntincart;


				Query q3 = em.createQuery("update ProductBean p set p.itemquantity =?1 where p.itemid =?2");
				q3.setParameter(1, newqty);
				q3.setParameter(2, id);

				noofrowsupdated = q3.executeUpdate();
				System.out.println("updated rows" +noofrowsupdated);	
			}
			em.getTransaction().commit();

		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally
		{
			em.close();
		}
		return noofrowsupdated;
	}

	public int removeDetailsFromCart(String username)
	{
		EntityManager em = null;
		int rowsdeleted = 0;
		try
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateproject");
			em = emf.createEntityManager();
			em.getTransaction().begin();

			Query q = em.createQuery("delete from CartBean c where c.username =?1");
			q.setParameter(1, username);

			rowsdeleted = q.executeUpdate();
			em.getTransaction().commit();
			System.out.println("deleted rows " + rowsdeleted);
			
			return rowsdeleted;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally
		{
			em.close();
		}
		return rowsdeleted;

	}

}
