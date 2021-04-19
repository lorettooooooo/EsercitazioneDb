package it.objectmethod.dbexercise.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.dbexercise.dao.ICityDao;
import it.objectmethod.dbexercise.daoimpl.CityDaoImpl;
import it.objectmethod.dbexercise.domain.City;

@WebServlet("/GetCityServlet")
public class GetCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String input = request.getParameter("cityName");
		ICityDao cityDao = new CityDaoImpl();
		City city = null;

		try {
			city = cityDao.getCityByName(input);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("city", city);
		request.getRequestDispatcher("cityInfo.jsp").forward(request, response);
	}

}
