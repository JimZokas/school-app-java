package dao;

import static dao.DBUtil.closeConnection;
import static dao.DBUtil.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentDAOImpl implements IStudentDAO 
{
	@Override
	public boolean insert(Student student) throws SQLException 
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();
		
		try
		{
			statement = connection.prepareStatement("INSERT INTO STUDENTS (FIRSTNAME, LASTNAME) VALUES (?, ?)");
			statement.setString(1, student.getFirstname());
			statement.setString(2, student.getLastname());
			
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
			statement = connection.prepareStatement("DELETE FROM STUDENTS WHERE ID = ?");
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
	public boolean update(int id, String firstname, String lastname) throws SQLException 
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();
		
		try
		{		
			statement = connection.prepareStatement("UPDATE STUDENTS SET FIRSTNAME = ?, LASTNAME = ? WHERE ID = ?");
			statement.setString(1, firstname);
			statement.setString(2, lastname);
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

	@Override
	public Student getStudentById(int id) throws SQLException 
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();
		ResultSet results = null;
		Student student = null;
		
		try
		{	
			statement = connection.prepareStatement("SELECT * FROM STUDENTS WHERE ID LIKE ?");
			statement.setInt(1, id);
			
			results = statement.executeQuery();
			
			if (results.next())
			{
				student = new Student();
				student.setId(results.getInt("ID"));
				student.setFirstname(results.getString("FIRSTNAME"));
				student.setLastname(results.getString("LASTNAME"));
			}
			
			return student;
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
	
	public List<Student> getAll() throws SQLException
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();
		List<Student> students = new ArrayList<>();
		ResultSet results = null;
		
		try
		{	
			statement = connection.prepareStatement("SELECT * FROM STUDENTS");
			
			results = statement.executeQuery();
			
			while (results.next())
			{
				Student student = new Student();
				student.setId(results.getInt("ID"));
				student.setFirstname(results.getString("FIRSTNAME"));
				student.setLastname(results.getString("LASTNAME"));
				
				students.add(student);
			}
			
			return students;
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
