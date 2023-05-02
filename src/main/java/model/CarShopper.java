package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Trevor Parrish - tparrish2
 * CIS175 - Spring 2023
 * May 1, 2023
 */

@Entity
@Table(name="car_shopper")
public class CarShopper {
	@Id
	@GeneratedValue
	private int id;
	private String carShopperName;
	
	public CarShopper() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	public CarShopper(String carShopperName) {
		super();
		this.carShopperName = carShopperName;
	}

	public CarShopper(int id, String carShopperName) {
		super();
		this.id = id;
		this.carShopperName = carShopperName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarShopperName() {
		return carShopperName;
	}

	public void setCarShopperName(String carShopperName) {
		this.carShopperName = carShopperName;
	}

	@Override
	public String toString() {
		return "CarShopper [id=" + id + ", carShopperName=" + carShopperName + "]";
	}
}
