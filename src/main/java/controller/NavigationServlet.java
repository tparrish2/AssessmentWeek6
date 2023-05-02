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
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String act = request.getParameter("doThisToCar");
		
		String path = "/viewAllCarsServlet";
		
		if (act.equals("Delete")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Car itemToDelete = dao.searchForCarById(tempId);
				dao.deleteCar(itemToDelete);
			} 
			catch (NumberFormatException e) {
				System.out.println("Forgot to select a car");
			}
		}
		else if (act.equals("Edit")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Car carToEdit = dao.searchForCarById(tempId);
				request.setAttribute("carToEdit", carToEdit);
				path = "/edit-car.jsp";
			}
			catch (NumberFormatException e){
				System.out.println("Forgot to select an item");
			}
		}
		else if (act.equals("Add")) {
			
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
