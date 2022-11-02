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

@WebServlet("/studentcourses")
public class StudentCoursesController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    IStudentCourseDAO dao = new StudentCourseDAOImpl();
    IStudentCourseService service = new StudentCourseServiceImpl(dao);
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	response.setContentType("text/html; charset=UTF-8");
    	
    	int studentId = Integer.parseInt(request.getParameter("id"));
    	String firstname = request.getParameter("firstname").trim();
    	String lastname = request.getParameter("lastname").trim();
    	
    	StudentDTO studentDTO = new StudentDTO();
    	
    	studentDTO.setId(studentId);
    	studentDTO.setFirstname(firstname);
    	studentDTO.setLastname(lastname);
    	
    	try
    	{
    		List<Course> courses = service.getCourses(studentId);
    		
    		request.setAttribute("student", studentDTO);
    		request.setAttribute("courses", courses);
			request.getRequestDispatcher("/jsps/studentcourse.jsp").forward(request, response);
    	}
    	catch(SQLException exception)
		{
			request.setAttribute("SQLError", true);
			request.getRequestDispatcher("/jsps/studentcourse.jsp").forward(request, response);
		}
    	
	}
}
