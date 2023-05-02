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
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String year = request.getParameter("year");
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		
		Car li = new Car(year, make, model);
		CarsHelper dao = new CarsHelper();
		dao.addCar(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
