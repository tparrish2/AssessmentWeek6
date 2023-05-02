package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Car;

/**
 * @author Trevor Parrish - tparrish2
 * CIS175 - Spring 2023
 * Feb 7, 2023
 */

public class CarsHelper {
	
	static EntityManagerFactory	emfactory = Persistence.createEntityManagerFactory("FavoriteCarsList");
	
	public void addCar(Car c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Car> showAllCars() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Car> allCars = em.createQuery("select i from Car i").getResultList();
		return allCars;
	}
	
	public void deleteCar(Car toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select c from Car c where c.year = :selectedYear and c.make = :selectedMake and c.model = :selectedModel", Car.class);
		//Substitute parameter with	actual data	from the toDelete item
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setParameter("selectedMake",	toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a	new	list item
		Car result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public List<Car> searchForCarByYear(String carYear) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select c from Car c where c.year = :selectedYear", Car.class);
		typedQuery.setParameter("selectedYear", carYear);
		List<Car> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Car> searchForCarByMake(String carMake) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select c from Car c where c.make = :selectedMake", Car.class);
		typedQuery.setParameter("selectedMake", carMake);
		List<Car> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Car> searchForCarByModel(String carModel) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select c from Car c where c.model = :selectedModel", Car.class);
		typedQuery.setParameter("selectedModel", carModel);
		List<Car> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public Car searchForCarById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Car found = em.find(Car.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateCar(Car toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
