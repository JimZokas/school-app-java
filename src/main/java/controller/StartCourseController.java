package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.IStudentCourseDAO;
import dao.StudentCourseDAOImpl;
import dto.StudentDTO;
import model.Course;
import service.IStudentCourseService;
import service.StudentCourseServiceImpl;

@WebServlet("/startcourse")
public class StartCourseController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseService = new StudentCourseServiceImpl(studentCourseDAO);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id").trim());
    	String firstname = request.getParameter("firstname").trim();
    	String lastname = request.getParameter("lastname").trim();
		
    	StudentDTO studentDTO = new StudentDTO();
    	
    	studentDTO.setId(id);
    	studentDTO.setFirstname(firstname);
    	studentDTO.setLastname(lastname);
		
    	try
		{
			List<Course> courses = studentCourseService.getNotStartedCourses(id);
			if(courses.size() == 0)
			{
				request.setAttribute("noOption", true);
				request.setAttribute("student", studentDTO);
				request.getRequestDispatcher("/jsps/coursestarted.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("student", studentDTO);
				request.setAttribute("courses", courses);
				request.getRequestDispatcher("/jsps/startcourse.jsp").forward(request, response);
			}
		}
		catch(SQLException exception)
		{
			request.setAttribute("SQLError", true);
			request.getRequestDispatcher("/jsps/studentcourse.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
		
		int studentId = Integer.parseInt(request.getParameter("studentid").trim());
		
		String firstname = request.getParameter("firstname").trim();
    	String lastname = request.getParameter("lastname").trim();
		
    	StudentDTO studentDTO = new StudentDTO();
    	
    	studentDTO.setId(studentId);
    	studentDTO.setFirstname(firstname);
    	studentDTO.setLastname(lastname);
		
		try
		{
			int courseId = Integer.parseInt(request.getParameter("courseid").trim());
			studentCourseService.startCourse(studentId, courseId);
			request.setAttribute("student", studentDTO);
			request.setAttribute("success", true);
			request.getRequestDispatcher("/jsps/coursestarted.jsp").forward(request, response);
		}
		catch(NullPointerException exception)
		{
			request.setAttribute("student", studentDTO);
			request.setAttribute("nullPointer", true);
			request.getRequestDispatcher("/jsps/coursestarted.jsp").forward(request, response);
		}
		catch(SQLException exception)
		{
			request.setAttribute("SQLError", true);
			request.getRequestDispatcher("/jsps/coursestarted.jsp").forward(request, response);
		}
	}
}
