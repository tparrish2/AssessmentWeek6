
import java.util.List;
import java.util.Scanner;

import controller.CarsHelper;
import model.Car;

/**
 * @author Trevor Parrish - tparrish2
 * CIS175 - Spring 2023
 * Feb 7, 2023
 */

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static CarsHelper lih = new CarsHelper();

		public static void runMenu() {
			boolean goAgain = true;
			// print intro and menu
			System.out.println("                ______");
			System.out.println("               /|_||_\\`.__");
			System.out.println("              (   _    _ _\\");
			System.out.println("              =`-(_)--(_)-'");
			System.out.println("--- Welcome to your favorite cars list! ---");
			while (goAgain) {
				System.out.println("\nSelect an item:");
				System.out.println("1 - Add a car");
				System.out.println("2 - Edit a car");
				System.out.println("3 - Delete a car");
				System.out.println("4 - View your list");
				System.out.println("5 - Exit program");
				// get user selection
				System.out.print("Your selection: ");
				int selection = in.nextInt();
				in.nextLine();
				
				// run method depending on user selection
				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editCar();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					// close connections
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}
			}
		}
		
		// method that adds an item to the list
		private static void addAnItem() {
			System.out.print("Enter the year: ");
			String year = in.nextLine();
			System.out.print("Enter the make: ");
			String make = in.nextLine();
			System.out.print("Enter the model: ");
			String model = in.nextLine();
			Car toAdd = new Car(year, make, model);
			lih.addCar(toAdd);
			System.out.println("Car added!");
		}
		
		// method that deletes an item from list
		private static void deleteAnItem() {
			System.out.print("Enter the car year: ");
			String year = in.nextLine();
			System.out.print("Enter the car make: ");
			String make = in.nextLine();
			System.out.print("Enter the car model: ");
			String model = in.nextLine();
			Car toDelete = new Car(year, make, model);
			lih.deleteCar(toDelete);
			System.out.println("Car deleted!");
		}
		
		// method that prints the list
		private static void viewTheList() {
			List<Car> allCars = lih.showAllCars();
			System.out.println("\nYour favorite cars list: ");
			for(Car singleItem : allCars){
				System.out.println(singleItem.returnCarDetails());
			}
		}
		
		// method that edits a specific car from the list
		private static void editCar() {
			System.out.println("\nHow would you like to search? ");
			System.out.println("1 - Search by Year");
			System.out.println("2 - Search by Make");
			System.out.println("3 - Search by Model");
			System.out.print("Your selection: ");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Car> foundCars;
			if (searchBy == 1) {
				System.out.print("Enter the year: ");
				String carYear = in.nextLine();
				foundCars = lih.searchForCarByYear(carYear);
			}
			else if (searchBy == 2) {
				System.out.print("Enter the make: ");
				String carMake = in.nextLine();
				foundCars = lih.searchForCarByMake(carMake);
			}
			else {
				System.out.print("Enter the model: ");
				String carModel = in.nextLine();
				foundCars = lih.searchForCarByModel(carModel);
			}

			if (!foundCars.isEmpty()) {
				System.out.println("\nCars Found:");
				for (Car l : foundCars) {
					System.out.println(l.getId() + " : " + l.returnCarDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Car toEdit = lih.searchForCarById(idToEdit);
				System.out.println("\nRetrieved " + toEdit.getYear() + " " + toEdit.getMake() + " " + toEdit.getModel());
				System.out.println("1 - Update Year");
				System.out.println("2 - Update Make");
				System.out.println("3 - Update Model");
				System.out.print("Your selection: ");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Year: ");
					String newYear = in.nextLine();
					toEdit.setYear(newYear);
				} 
				else if (update == 2) {
					System.out.print("New Make: ");
					String newMake = in.nextLine();
					toEdit.setMake(newMake);
				}
				else if (update == 3) {
					System.out.print("New Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
				}

				lih.updateCar(toEdit);
				System.out.println("Change made!");

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			runMenu();
		}
}

		
