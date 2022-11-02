package service;

import java.sql.SQLException;
import java.util.List;

import dao.IStudentCourseDAO;
import model.Course;

public class StudentCourseServiceImpl implements IStudentCourseService
{

private final IStudentCourseDAO dao;
	
	public StudentCourseServiceImpl(IStudentCourseDAO dao)
	{
		this.dao = dao;
	}
	
	@Override
	public boolean startCourse(int studentId, int courseId) throws SQLException 
	{
		try
		{
			dao.insert(studentId, courseId);
			return true;
		}
		catch(SQLException exception)
		{
			throw exception;
		}
	}

	@Override
	public boolean stopCourse(int courseId) throws SQLException 
	{
		try
		{
			dao.delete(courseId);
			return true;
		}
		catch(SQLException exception)
		{
			throw exception;
		}
	}
	
	@Override
	public List<Course> getCourses(int studentId) throws SQLException
	{
		try
		{
			return dao.getAll(studentId);
		}
		catch(SQLException exception)
		{
			throw exception;
		}
	}
	
	@Override
	public List<Course> getNotStartedCourses(int studentId) throws SQLException
	{
		try
		{
			return dao.getNotStarted(studentId);
		}
		catch(SQLException exception)
		{
			throw exception;
		}
	}
}
