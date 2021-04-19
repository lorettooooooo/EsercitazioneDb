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
		String username = request.getParameter("usernameInput");
		HttpSession session = request.getSession();
		if (username == null || username.isBlank()) {
			request.setAttribute("errorMessage", "Nome utente non valido, inserire un nome utente valido");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			session.setAttribute("loggedUser", username);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			
		}
	}
}
