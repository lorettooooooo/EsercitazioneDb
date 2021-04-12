package it.objectmethod.dbexercise.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.dbexercise.dao.ICitiesDao;
import it.objectmethod.dbexercise.daoimpl.CitiesDaoImpl;
import it.objectmethod.dbexercise.domain.City;

@WebServlet("/GetCitiesServlet")
public class GetCitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String readNationCode = request.getParameter("nationCode");
		String readNationName = request.getParameter("nationName");
		ICitiesDao citiesDao = new CitiesDaoImpl();
		List<City> citiesList = null;

		try {
			citiesList = citiesDao.GetCities(readNationCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("nationSelected", "Hai selezionato " + readNationName);
		request.setAttribute("citiesList", citiesList);
		request.getRequestDispatcher("ClickableContinents.jsp").forward(request, response);

	}

}
