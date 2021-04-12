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

@WebServlet("/GetNationServlet")
public class GetNationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String readNationName = request.getParameter("nationName");
		String readContinentName = request.getParameter("continentName");
		INationDao nationDao = new NationDaoImpl();
		List<Nation> nationList = null;

		try {
			nationList = nationDao.getNationListByName("%"+readNationName+"%", "%"+readContinentName+"%");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("nationList", nationList);
		request.getRequestDispatcher("nationInfo.jsp").forward(request, response);
	}
}
