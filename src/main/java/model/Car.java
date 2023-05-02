package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Trevor Parrish - tparrish2
 * CIS175 - Spring 2023
 * Feb 7, 2023
 */

@Entity
@Table(name="cars")
public class Car {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="YEAR")
	private String year;
	@Column(name="MAKE")
	private String make;
	@Column(name="MODEL")
	private String model;
	
	public Car() {
		super();
	}
	
	public Car(String year, String make, String model) {
		super();
		this.year = year;
		this.make = make;
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String returnCarDetails() {
		return this.year + " " + this.make + " " + this.model;
	}
}
