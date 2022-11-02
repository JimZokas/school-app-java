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
import service.ITeacherService;
import service.TeacherServiceImpl;

@WebServlet("/deleteteacher")
public class DeleteTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ITeacherDAO dao = new TeacherDAOImpl();
    ITeacherService service = new TeacherServiceImpl(dao);
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	response.setContentType("text/html; charset=UTF-8");
    	
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	try
    	{
    		service.deleteTeacher(id);
    		request.setAttribute("success", true);
			request.getRequestDispatcher("/jsps/teacherdeleted.jsp").forward(request, response);
    	}
    	catch(SQLException exception)
    	{
    		request.setAttribute("SQLError", true);
			request.getRequestDispatcher("/jsps/teacherdeleted.jsp").forward(request, response);
    	}
	}
}
