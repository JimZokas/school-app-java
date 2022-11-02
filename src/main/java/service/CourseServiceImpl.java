package service;

import java.sql.SQLException;
import java.util.List;

import dao.ICourseDAO;
import exceptions.DescriptionLengthException;
import exceptions.EmptyFieldException;
import model.Course;

public class CourseServiceImpl implements ICourseService
{

	private final ICourseDAO dao;
	
	public CourseServiceImpl(ICourseDAO dao)
	{
		this.dao = dao;
	}
	
	@Override
	public boolean createCourse(String description, int teacherId) throws SQLException, EmptyFieldException, DescriptionLengthException 
	{
		if(description.equals("")) throw new EmptyFieldException();
		
		if(description.length() <= 2) throw new DescriptionLengthException();
		
		try
		{
			dao.insert(description, teacherId);
			return true;
		}
		catch(SQLException exception)
		{
			throw exception;
		}
	}

	@Override
	public boolean deleteCourse(int id) throws SQLException 
	{
		try
		{
			dao.delete(id);
			return true;
		}
		catch(SQLException exception)
		{
			throw exception;
		}
	}

	@Override
	public boolean updateCourse(int id, String description, int teacherId) throws SQLException, EmptyFieldException, DescriptionLengthException 
	{
		if(description.equals("")) throw new EmptyFieldException();
		
		if(description.length() <= 2) throw new DescriptionLengthException();
		
		try
		{
			dao.update(id, description, teacherId);
			return true;
		}
		catch(SQLException exception)
		{
			throw exception;
		}
	}

	@Override
	public List<Course> getCourses() throws SQLException 
	{
		try
		{
			return dao.getAll();
		}
		catch(SQLException exception)
		{
			throw exception;
		}
	}
	
}
