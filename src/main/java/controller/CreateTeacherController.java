package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ITeacherDAO;
import dao.TeacherDAOImpl;
import dto.TeacherDTO;
import exceptions.EmptyFieldException;
import exceptions.FirstLastNameLengthException;
import service.ITeacherService;
import service.TeacherServiceImpl;


@WebServlet("/createteacher")
public class CreateTeacherController extends HttpServlet 
{
private static final long serialVersionUID = 1L;
	
	ITeacherDAO dao = new TeacherDAOImpl();
	ITeacherService service = new TeacherServiceImpl(dao);
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html, charset=UTF-8");
		
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		
		TeacherDTO dto = new TeacherDTO();
		dto.setFirstname(firstname);
		dto.setLastname(lastname);
		
		try
		{
			service.createTeacher(dto);
			request.setAttribute("success", true);
			request.getRequestDispatcher("/jsps/teachercreated.jsp").forward(request, response);
		}
		catch(EmptyFieldException exception)
		{
			request.setAttribute("FieldLength", true);
			request.getRequestDispatcher("/jsps/teachercreated.jsp").forward(request, response);
		}
		catch(FirstLastNameLengthException exception)
		{
			request.setAttribute("FieldLength", true);
			request.getRequestDispatcher("/jsps/teachercreated.jsp").forward(request, response);
		}
		catch(SQLException exception)
		{
			request.setAttribute("SQLError", true);
			request.getRequestDispatcher("/jsps/teachercreated.jsp").forward(request, response);
		}
	}

}
