package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.IStudentDAO;
import dao.StudentDAOImpl;
import model.Student;
import service.IStudentService;
import service.StudentServiceImpl;

@WebServlet("/students")
public class StudentsController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	IStudentDAO dao = new StudentDAOImpl();
	IStudentService service = new StudentServiceImpl(dao);
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
				
		try
		{
			List<Student> students = service.getAllStudents();
			if(students.size() == 0)
			{
				request.getRequestDispatcher("/jsps/students.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("students", students);
				request.getRequestDispatcher("/jsps/students.jsp").forward(request, response);
			}
		}
		catch(SQLException exception)
		{
			request.setAttribute("SQLError", true);
			request.getRequestDispatcher("/jsps/index.jsp").forward(request, response);
		}
	}
}
