package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IStudentDAO;
import dao.StudentDAOImpl;
import dto.StudentDTO;
import exceptions.EmptyFieldException;
import exceptions.FirstLastNameLengthException;
import service.IStudentService;
import service.StudentServiceImpl;


@WebServlet("/createstudent")
public class CreateStudentController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	IStudentDAO dao = new StudentDAOImpl();
	IStudentService service = new StudentServiceImpl(dao);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html, charset=UTF-8");
		
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		
		StudentDTO dto = new StudentDTO();
		dto.setFirstname(firstname);
		dto.setLastname(lastname);
		
		try
		{
			service.createStudent(dto);
			request.setAttribute("student", dto);
			request.setAttribute("success", true);
			request.getRequestDispatcher("/jsps/studentcreated.jsp").forward(request, response);
		}
		catch(EmptyFieldException exception)
		{
			request.setAttribute("EmptyField", true);
			request.getRequestDispatcher("/jsps/studentcreated.jsp").forward(request, response);
		}
		catch(FirstLastNameLengthException exception)
		{
			request.setAttribute("FieldLength", true);
			request.getRequestDispatcher("/jsps/studentcreated.jsp").forward(request, response);
		}
		catch(SQLException exception)
		{
			request.setAttribute("SQLError", true);
			request.getRequestDispatcher("/jsps/studentcreated.jsp").forward(request, response);
			
		}
	}
}
