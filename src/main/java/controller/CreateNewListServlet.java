package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.ArrayList;

import model.Car;
import model.CarShopper;
import model.CarListDetails;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarsHelper ch = new CarsHelper();
		String carListName = request.getParameter("carListName");
		
		System.out.println("List Name: "+ carListName);
		
		String carShopperName = request.getParameter("carShopperName");
		String[] selectedCars = request.getParameterValues("allCarsToAdd");
		
		List<Car> selectedCarsInList = new ArrayList<Car>();
		
		//make sure something was selected – otherwise we get a null pointer exception 
		if (selectedCars != null && selectedCars.length > 0) {
			for(int i = 0; i<selectedCars.length; i++) {
				System.out.println(selectedCars[i]);
				Car c = ch.searchForCarById(Integer.parseInt(selectedCars[i]));
				selectedCarsInList.add(c);
			}
		}
		
		CarShopper carShopper = new CarShopper(carShopperName);
		CarListDetails sld = new CarListDetails(carListName, carShopper);
		
		sld.setListOfCars(selectedCarsInList);
		
		CarListDetailsHelper cslh = new CarListDetailsHelper();
		
		cslh.insertNewCarListDetails(sld);
		
		System.out.println("Success!");
		System.out.println(sld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
