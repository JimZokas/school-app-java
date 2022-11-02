package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAOImpl;
import dao.ICourseDAO;
import model.Course;
import service.CourseServiceImpl;
import service.ICourseService;

@WebServlet("/courses")
public class CoursesController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	ICourseDAO dao = new CourseDAOImpl();
	ICourseService service = new CourseServiceImpl(dao);


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
				
		try
		{
			List<Course> courses = service.getCourses();
			if(courses.size() == 0)
			{
				request.getRequestDispatcher("/jsps/courses.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("courses", courses);
				request.getRequestDispatcher("/jsps/courses.jsp").forward(request, response);
			}
		}
		catch(SQLException exception)
		{
			request.setAttribute("SQLError", true);
			request.getRequestDispatcher("/jsps/index").forward(request, response);
		}
	}
}
