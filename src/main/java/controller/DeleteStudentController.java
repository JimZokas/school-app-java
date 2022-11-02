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
import service.IStudentService;
import service.StudentServiceImpl;

@WebServlet("/deletestudent")
public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IStudentDAO dao = new StudentDAOImpl();
    IStudentService service = new StudentServiceImpl(dao);
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	response.setContentType("text/html; charset=UTF-8");
    	
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	try
    	{
    		service.deleteStudent(id);
    		request.setAttribute("success", true);
			request.getRequestDispatcher("/jsps/studentdeleted.jsp").forward(request, response);
    	}
    	catch(SQLException exception)
    	{
    		request.setAttribute("SQLError", true);
			request.getRequestDispatcher("/jsps/studentdeleted.jsp").forward(request, response);
    	}
	}

}
