package it.objectmethod.dbexercise.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.dbexercise.dao.IContinentsDao;
import it.objectmethod.dbexercise.daoimpl.ContinentsDaoImpl;
import it.objectmethod.dbexercise.domain.Continent;

@WebServlet("/GetContinentsServlet")
public class GetContinentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IContinentsDao continentDao = new ContinentsDaoImpl();
		List<Continent> continentsList = new ArrayList<>();
		try {
			continentsList = continentDao.GetContinents();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("continentsList", continentsList);
		request.getRequestDispatcher("ClickableContinents.jsp").forward(request, response);
	}

}
