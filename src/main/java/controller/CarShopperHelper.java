package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarListDetails;
import model.CarShopper;

/**
 * @author Trevor Parrish - tparrish2
 * CIS175 - Spring 2023
 * May 1, 2023
 */
public class CarShopperHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FavoriteCarsList");
			
	public void insertCarShopper(CarShopper c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CarShopper> showAllCarShoppers() {
		EntityManager em = emfactory.createEntityManager();
		List<CarShopper> allCarShoppers = em.createQuery("SELECT s FROM CarShopper s").getResultList();
		return allCarShoppers;
	}
	
	public CarShopper findCarShopper(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<CarShopper> typedQuery = em.createQuery("select sh from CarShopper sh where sh.carShopperName = :selectedName", CarShopper.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		CarShopper foundShopper;
		
		try {
			foundShopper = typedQuery.getSingleResult();
		} 
		catch (NoResultException ex) {
			foundShopper = new CarShopper(nameToLookUp);
		}
		
		em.close();
		
		return foundShopper;
	}
}
