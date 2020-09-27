package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.beansList;

public class ListBeanHelper {
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("ConsoleCoffeeList");

	public void insertBean(beansList bl) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(bl);
		em.getTransaction().commit();
		em.close();
		
	}

	public void deleteBean(beansList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<beansList> typedQuery = em.createQuery("select li from beansList li where "
				+ "li.origin = :selectedOrigin and li.roast = :selectedRoast", beansList.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedOrigin", toDelete.getOrigin());
		typedQuery.setParameter("selectedRoast", toDelete.getRoast());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		beansList result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public List<beansList> searchForBeansByOrigin(String originName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<beansList> typedQuery = em.createQuery("select li from "
				+ "beansList li where li.origin = :selectedOrigin", beansList.class);
		typedQuery.setParameter("selectedOrigin", originName);
		List<beansList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<beansList> searchForBeansByRoast(String roastName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<beansList> typedQuery = em.createQuery("select li from "
				+ "beansList li where li.roast = :selectedRoast", beansList.class);
		typedQuery.setParameter("selectedRoast", roastName);
		List<beansList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public beansList searchForBeanById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		beansList found = em.find(beansList.class, idToEdit);
		em.close();
		return found;
	}

	public void updateBean(beansList toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}

	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();
		
	}

	public List<beansList> showAllBeans() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		List<beansList> allItems = em.createQuery("SELECT i FROM beansList i").getResultList();
		return allItems;
	}
}
