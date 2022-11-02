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
import dao.ITeacherDAO;
import dao.TeacherDAOImpl;
import exceptions.DescriptionLengthException;
import exceptions.EmptyFieldException;
import model.Teacher;
import service.CourseServiceImpl;
import service.ICourseService;
import service.ITeacherService;
import service.TeacherServiceImpl;

@WebServlet("/createcourse")
public class CreateCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ICourseDAO courseDao = new CourseDAOImpl();
	ICourseService courseService = new CourseServiceImpl(courseDao);
	
	ITeacherDAO teacherDao = new TeacherDAOImpl();
	ITeacherService teacherService = new TeacherServiceImpl(teacherDao);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{				
		try
		{
			List<Teacher> teachers = teacherService.getAllTeachers();
			if(teachers.size() == 0)
			{
				request.setAttribute("EmptyList", true);
				request.getRequestDispatcher("/jsps/courses.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("teachers", teachers);
				request.getRequestDispatcher("/jsps/addcourse.jsp").forward(request, response);
			}
		}
		catch(SQLException exception)
		{
			request.setAttribute("SQLError", true);
			request.getRequestDispatcher("/jsps/courses.jsp").forward(request, response);
		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
		
		String description = request.getParameter("description");
		
					
		try
		{
			int teacherId = Integer.parseInt(request.getParameter("teacherid"));
			courseService.createCourse(description, teacherId);
			request.setAttribute("description", description);
			request.setAttribute("success", true);
			request.getRequestDispatcher("/jsps/coursecreated.jsp").forward(request, response);
		}
		catch(EmptyFieldException exception)
		{
			request.setAttribute("EmptyField", true);
			request.getRequestDispatcher("/jsps/coursecreated.jsp").forward(request, response);
		}
		catch(DescriptionLengthException exception)
		{
			request.setAttribute("FieldLength", true);
			request.getRequestDispatcher("/jsps/coursecreated.jsp").forward(request, response);
		}
		catch(NumberFormatException exception)
		{
			request.setAttribute("nullFormat", true);
			request.getRequestDispatcher("/jsps/coursecreated.jsp").forward(request, response);
		}
		catch(SQLException exception)
		{
			request.setAttribute("SQLError", true);
			request.getRequestDispatcher("/jsps/coursecreated.jsp").forward(request, response);
		}
	}
}
