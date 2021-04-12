package it.objectmethod.dbexercise.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.dbexercise.dao.INationDao;
import it.objectmethod.dbexercise.daoimpl.NationDaoImpl;
import it.objectmethod.dbexercise.domain.Nation;

@WebServlet("/GetNationsServlet")
public class GetNationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String readContinentName = request.getParameter("continentName");
		INationDao nationDao = new NationDaoImpl();
		List<Nation> nationList = null;

		try {
			nationList = nationDao.getNationListByName("", readContinentName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("continentSelected", "Hai selezionato " + readContinentName);
		request.setAttribute("nationList", nationList);
		request.getRequestDispatcher("ClickableContinents.jsp").forward(request, response);
	}


}
