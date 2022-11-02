package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ITeacherDAO;
import dao.TeacherDAOImpl;
import model.Teacher;
import service.ITeacherService;
import service.TeacherServiceImpl;

@WebServlet("/teachers")
public class TeachersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ITeacherDAO dao = new TeacherDAOImpl();
	ITeacherService service = new TeacherServiceImpl(dao);
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
				
		try
		{
			List<Teacher> teachers = service.getAllTeachers();
			if(teachers.size() == 0)
			{
				request.getRequestDispatcher("/jsps/teachers.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("teachers", teachers);
				request.getRequestDispatcher("/jsps/teachers.jsp").forward(request, response);
			}
		}
		catch(SQLException exception)
		{
			request.setAttribute("teacherSearchSqlError", true);
			request.getRequestDispatcher("/jsps/index.jsp").forward(request, response);
		}
	}
}
