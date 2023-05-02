import java.util.List;

import controller.CarShopperHelper;
import model.CarShopper;

/**
 * @author Trevor Parrish - tparrish2
 * CIS175 - Spring 2023
 * May 1, 2023
 */

public class CarShopperTester {
	
	public static void main(String[] args) {
		
		CarShopper trevor = new CarShopper("Trevor");
		CarShopper katherine = new CarShopper("Katherine");
		CarShopperHelper sh = new CarShopperHelper();
		sh.insertCarShopper(trevor);
		sh.insertCarShopper(katherine);
		List<CarShopper> allCarShoppers = sh.showAllCarShoppers();
		for(CarShopper a: allCarShoppers) {
			System.out.println(a.toString());
		}
	}

}
