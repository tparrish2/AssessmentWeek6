package controller;

/**
 * @author Trevor Parrish - tparrish2
 * CIS175 - Spring 2023
 * Feb 20, 2023
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;

/**
 * Servlet implementation class EditCarServlet
 */
@WebServlet("/editCarServlet")
public class EditCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCarServlet() {
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
		CarsHelper dao = new CarsHelper();
		
		String year = request.getParameter("year");
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Car carToUpdate = dao.searchForCarById(tempId);
		carToUpdate.setYear(year);
		carToUpdate.setMake(make);
		carToUpdate.setModel(model);
		
		dao.updateCar(carToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
	}

}
