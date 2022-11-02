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

public class StudentCourseDAOImpl implements IStudentCourseDAO 
{

	@Override
	public boolean insert(int studentId, int courseId) throws SQLException 
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();
		
		try
		{
			statement = connection.prepareStatement("INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (?, ?)");
			statement.setInt(1, studentId);
			statement.setInt(2, courseId);
			
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
	public boolean delete(int courseId) throws SQLException 
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();

		try
		{	
			statement = connection.prepareStatement("DELETE FROM STUDENT_COURSE WHERE COURSE_ID = ?");
			statement.setInt(1, courseId);
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
	
	public List<Course> getAll(int studentId) throws SQLException
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();
		ResultSet results = null;
		List<Course> courses = new ArrayList<>();
		
		try
		{	
			statement = connection.prepareStatement("SELECT COURSES.ID, COURSES.DESCRIPTION "
					+ "FROM COURSES, STUDENTS, STUDENT_COURSE "
					+ "WHERE STUDENTS.ID = ? AND COURSES.ID = STUDENT_COURSE.COURSE_ID AND STUDENTS.ID = STUDENT_COURSE.STUDENT_ID");
			statement.setInt(1, studentId);
			results = statement.executeQuery();
			
			while (results.next())
			{
				Course course = new Course();
				course.setId(results.getInt("ID"));
				course.setDescription(results.getString("DESCRIPTION"));
				
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
	
	public List<Course> getNotStarted(int studentId) throws SQLException
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();
		ResultSet results = null;
		List<Course> courses = new ArrayList<>();
		
		try
		{	
			statement = connection.prepareStatement("SELECT COURSES.ID, COURSES.DESCRIPTION FROM COURSES WHERE COURSES.ID NOT IN (SELECT COURSE_ID FROM STUDENT_COURSE WHERE STUDENT_ID = ?)");
			statement.setInt(1, studentId);
			results = statement.executeQuery();
			
			while (results.next())
			{
				Course course = new Course();
				course.setId(results.getInt("ID"));
				course.setDescription(results.getString("DESCRIPTION"));
				
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
