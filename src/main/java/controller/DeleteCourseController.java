package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAOImpl;
import dao.ICourseDAO;
import service.CourseServiceImpl;
import service.ICourseService;

@WebServlet("/deletecourse")
public class DeleteCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ICourseDAO dao = new CourseDAOImpl();
    ICourseService service  = new CourseServiceImpl(dao);
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	response.setContentType("text/html; charset=UTF-8");
    	
    	int courseId = Integer.parseInt(request.getParameter("id"));
    	
    	try
    	{
    		service.deleteCourse(courseId);
    		request.setAttribute("success", true);
			request.getRequestDispatcher("/jsps/coursedeleted.jsp").forward(request, response);
    	}
    	catch(SQLException exception)
    	{
    		request.setAttribute("SQLError", true);
			request.getRequestDispatcher("/jsps/coursedeleted.jsp").forward(request, response);
    	}
	}

}
