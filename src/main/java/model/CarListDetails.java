package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Trevor Parrish - tparrish2
 * CIS175 - Spring 2023
 * May 1, 2023
 */

@Entity
public class CarListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String carListName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private CarShopper carShopper;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Car> listOfCars;
	
	public CarListDetails() {
		super();
	}

	public CarListDetails(int id, String carListName, CarShopper carShopper, List<Car> listOfCars) {
		super();
		this.id = id;
		this.carListName = carListName;
		this.carShopper = carShopper;
		this.listOfCars = listOfCars;
	}

	public CarListDetails(String carListName, CarShopper carShopper, List<Car> listOfCars) {
		super();
		this.carListName = carListName;
		this.carShopper = carShopper;
		this.listOfCars = listOfCars;
	}

	public CarListDetails(String carListName, CarShopper carShopper) {
		super();
		this.carListName = carListName;
		this.carShopper = carShopper;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarListName() {
		return carListName;
	}

	public void setCarListName(String carListName) {
		this.carListName = carListName;
	}

	public CarShopper getCarShopper() {
		return carShopper;
	}

	public void setCarShopper(CarShopper carShopper) {
		this.carShopper = carShopper;
	}

	public List<Car> getListOfCars() {
		return listOfCars;
	}

	public void setListOfCars(List<Car> listOfCars) {
		this.listOfCars = listOfCars;
	}

	@Override
	public String toString() {
		return "CarListDetails [id=" + id + ", carListName=" + carListName + ", carShopper=" + carShopper
				+ ", listOfCars=" + listOfCars + "]";
	}
}
