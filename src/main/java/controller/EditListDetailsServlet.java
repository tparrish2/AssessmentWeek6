package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.ArrayList;

import model.CarListDetails;
import model.CarShopper;
import model.Car;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarListDetailsHelper dao = new CarListDetailsHelper();
		
		CarsHelper ch = new CarsHelper();
		CarShopperHelper csh = new CarShopperHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		CarListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("carListName");
		String carShopperName = request.getParameter("carShopperName");
		
		//find our add the new shopper
		CarShopper newCarShopper = csh.findCarShopper(carShopperName);
	
		try {
			//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allCarsToAdd");
			List<Car> selectedItemsInList = new ArrayList<Car>();
			
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Car c = ch.searchForCarById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		
		listToUpdate.setListOfCars(selectedItemsInList);
		
		} 
		catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Car> selectedItemsInList = new ArrayList<Car>();
			listToUpdate.setListOfCars(selectedItemsInList);
		}
		
		listToUpdate.setCarListName(newListName);
		listToUpdate.setCarShopper(newCarShopper);
		dao.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
