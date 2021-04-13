package it.objectmethod.dbexercise.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = null;
		username = request.getParameter("sesso_anale_violentissimo_che_fa_uscire_sangue");
		HttpSession session = request.getSession();
		if (username == null || username.isBlank()) {
			request.setAttribute("errorMessage", "è un nome del cazzo, coglione, scegline uno migliore");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			session.setAttribute("loggedUser", username);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			
		}
	}
}
