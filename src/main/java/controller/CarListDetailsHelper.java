package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarListDetails;

/**
 * @author Trevor Parrish - tparrish2
 * CIS175 - Spring 2023
 * May 1, 2023
 */

public class CarListDetailsHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FavoriteCarsList");
	
	public void insertNewCarListDetails(CarListDetails c) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CarListDetails> getCarLists() {
		
		EntityManager em = emfactory.createEntityManager();
		List<CarListDetails> allDetails = em.createQuery("SELECT d FROM CarListDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteList(CarListDetails toDelete) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<CarListDetails> typedQuery = em.createQuery("select detail from CarListDetails detail where detail.id = :selectedId", CarListDetails.class);
		
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		// we only want one result
		typedQuery.setMaxResults(1);
		
		// get the result and save it into a new list item
		CarListDetails result = typedQuery.getSingleResult();
		
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public CarListDetails searchForListDetailsById(Integer tempId) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CarListDetails found = em.find(CarListDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void updateList(CarListDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
}
	
