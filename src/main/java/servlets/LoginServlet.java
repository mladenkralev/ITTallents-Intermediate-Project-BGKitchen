package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.users.PasswordException;
import user.users.User;
import user.users.UserDAO;
import user.users.UserException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Wzehte");
		
		User login = null;
		try {
			login = new User(name, password, name);
		} catch (PasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int id = 0;
		try {
			id = new UserDAO().loginUser(login);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(id);
		if (id != 0) {
			response.sendRedirect(request.getContextPath() + "/registeredUser.jsp");
			System.out.println("Redirect...");
		} else {
			System.err.println("Greshan parola ili username");
		}
	}

}
