package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
		
		String mail = request.getParameter("eMail");
		String password = request.getParameter("password");
		
		//Assume that we call a login service
		
		if (mail.equals("jimzokas@hotmail.com") && password.equals("1234"))
		{
			request.getRequestDispatcher("/jsps/index.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("error", true);
			request.getRequestDispatcher("/jsps/login.jsp").forward(request, response);
		}
	}

}
