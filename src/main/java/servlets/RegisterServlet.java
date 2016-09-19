package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.users.PasswordException;
import user.users.User;
import user.users.UserDAO;
import user.users.UserException;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 176634172L;
	/**
	 * 
	 */
	public static final String HTML_START = "<html><body>";
	public static final String HTML_END = "</body></html>";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name").toString();
		String password = req.getParameter("password").toString();
		String email = req.getParameter("email").toString();
		try {
			new UserDAO().registerUser(new User(name, password, email));
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath() + "/index.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("stana");
	}

}
