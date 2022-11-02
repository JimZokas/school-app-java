package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IStudentCourseDAO;
import dao.StudentCourseDAOImpl;
import dto.StudentDTO;
import service.IStudentCourseService;
import service.StudentCourseServiceImpl;

@WebServlet("/dropcourse")
public class DropCourseController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseService = new StudentCourseServiceImpl(studentCourseDAO);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
		
		int studentId = Integer.parseInt(request.getParameter("studentid").trim());
		int courseId = Integer.parseInt(request.getParameter("courseid").trim());
		String firstname = request.getParameter("firstname").trim();
    	String lastname = request.getParameter("lastname").trim();
		
    	StudentDTO studentDTO = new StudentDTO();
    	
    	studentDTO.setId(studentId);
    	studentDTO.setFirstname(firstname);
    	studentDTO.setLastname(lastname);
    	
		try
		{
			studentCourseService.stopCourse(courseId);
			request.setAttribute("student", studentDTO);
			request.setAttribute("success", true);
			request.getRequestDispatcher("/jsps/coursestopped.jsp").forward(request, response);
		}
		catch(SQLException exception)
		{
			request.setAttribute("SQLError", true);
			request.getRequestDispatcher("/jsps/coursestopped.jsp").forward(request, response);
		}
	}
}
