package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Teacher;
import static dao.DBUtil.*;

public class TeacherDAOImpl implements ITeacherDAO
{

	@Override
	public boolean insert(Teacher teacher) throws SQLException 
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();
		
		try
		{
			statement = connection.prepareStatement("INSERT INTO TEACHERS (FIRSTNAME, LASTNAME) VALUES (?, ?)");
			statement.setString(1, teacher.getFirstname());
			statement.setString(2, teacher.getLastname());
			
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
			statement = connection.prepareStatement("DELETE FROM TEACHERS WHERE ID = ?");
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
			statement = connection.prepareStatement("UPDATE TEACHERS SET FIRSTNAME = ?, LASTNAME = ? WHERE ID = ?");
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
	public Teacher getTeacherById(int id) throws SQLException 
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();
		ResultSet results = null;
		Teacher teacher = null;
		
		try
		{	
			statement = connection.prepareStatement("SELECT * FROM TEACHERS WHERE ID LIKE ?");
			statement.setInt(1, id);
			
			results = statement.executeQuery();
			
			if (results.next())
			{
				teacher = new Teacher();
				teacher.setId(results.getInt("ID"));
				teacher.setFirstname(results.getString("FIRSTNAME"));
				teacher.setLastname(results.getString("LASTNAME"));
			}
			
			return teacher;
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
	
	public List<Teacher> getAll() throws SQLException
	{
		PreparedStatement statement = null;
		Connection connection = getConnection();
		List<Teacher> teachers = new ArrayList<>();
		ResultSet results = null;
		
		try
		{	
			statement = connection.prepareStatement("SELECT * FROM TEACHERS");
			
			results = statement.executeQuery();
			
			while (results.next())
			{
				Teacher teacher = new Teacher();
				teacher.setId(results.getInt("ID"));
				teacher.setFirstname(results.getString("FIRSTNAME"));
				teacher.setLastname(results.getString("LASTNAME"));
				
				teachers.add(teacher);
			}
			
			return teachers;
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
