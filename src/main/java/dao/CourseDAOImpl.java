package dao;

import static dao.DBUtil.closeConnection;
import static dao.DBUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;

public class CourseDAOImpl implements ICourseDAO 
{
	public boolean insert(String description, int teacherId) throws SQLException 
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();
		
		try
		{
			statement = connection.prepareStatement("INSERT INTO COURSES (DESCRIPTION, TEACHER_ID) VALUES (?, ?)");
			statement.setString(1, description);
			statement.setInt(2, teacherId);
			
			statement.executeUpdate();
			
			return true;
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			throw exception;
		} 
		finally
		{
			if (statement != null) statement.close();
			if (connection != null) closeConnection();
		}
	}

	@Override
	public boolean delete(int id) throws SQLException 
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();

		try
		{	
			statement = connection.prepareStatement("DELETE FROM COURSES WHERE ID = ?");
			statement.setInt(1, id);
			statement.executeUpdate();
			
			return true;
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			throw exception;
		} 
		finally
		{
			if (statement != null) statement.close();
			if (connection != null) closeConnection();
		}
	}

	@Override
	public boolean update(int id, String description, int teacherId) throws SQLException 
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();
		
		try
		{		
			statement = connection.prepareStatement("UPDATE COURSES SET DESCRIPTION = ?, TEACHER_ID = ? WHERE ID = ?");
			statement.setString(1, description);
			statement.setInt(2, teacherId);
			statement.setInt(3, id);
			
			statement.executeUpdate();
			
			return true;
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			throw exception;
		} 
		finally
		{
			if (statement != null) statement.close();
			if (statement != null) closeConnection();
		}
	}
	
	public List<Course> getAll() throws SQLException
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();
		ResultSet results = null;
		List<Course> courses = new ArrayList<>();
		
		try
		{	
			statement = connection.prepareStatement("SELECT * FROM COURSES");
			
			results = statement.executeQuery();
			
			while (results.next())
			{
				Course course = new Course();
				course.setId(results.getInt("ID"));
				course.setDescription(results.getString("DESCRIPTION"));
				course.setTeacherId(results.getInt("TEACHER_ID"));
				
				courses.add(course);
			}
			
			return courses;
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			throw exception;
		} 
		finally
		{
			if (statement != null) statement.close();
			if (connection != null) closeConnection();
		}
	}
}
