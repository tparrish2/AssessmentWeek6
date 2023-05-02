import model.CarShopper;
import controller.CarShopperHelper;
import controller.CarListDetailsHelper;
import model.CarListDetails;
import model.Car;

import java.util.List;
import java.util.ArrayList;



/**
 * @author Trevor Parrish - tparrish2
 * CIS175 - Spring 2023
 * May 1, 2023
 */

public class CarListDetailsTester {
	
	public static void main(String[] args) {

		CarShopper trevor = new CarShopper("Trevor");
		
		CarListDetailsHelper cldh = new CarListDetailsHelper();	
		
		Car jeep = new Car("2020", "Jeep", "Renegade");
		Car ford = new Car("2015", "Ford", "Focus");
		
		List<Car> trevorsCars = new ArrayList<Car>();
		trevorsCars.add(jeep);
		trevorsCars.add(ford);
		CarListDetails trevorsList = new CarListDetails("Trevor's Car Shopping List", trevor);
		trevorsList.setListOfCars(trevorsCars);
		cldh.insertNewCarListDetails(trevorsList);
		
		List<CarListDetails> allLists = cldh.getCarLists();
		
		for(CarListDetails a: allLists) {
			System.out.println(a.toString());
		}
	}
}
