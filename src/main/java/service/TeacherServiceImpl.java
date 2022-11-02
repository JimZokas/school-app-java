package service;

import java.sql.SQLException;
import java.util.List;

import dao.ITeacherDAO;
import dto.TeacherDTO;
import exceptions.EmptyFieldException;
import exceptions.FirstLastNameLengthException;
import model.Teacher;

public class TeacherServiceImpl implements ITeacherService 
{
	private final ITeacherDAO dao;
	
	public TeacherServiceImpl(ITeacherDAO dao)
	{
		this.dao = dao;
	}
	
	
	@Override
	public boolean createTeacher(TeacherDTO dto) throws SQLException, EmptyFieldException, FirstLastNameLengthException 
	{
		if(dto.getFirstname().equals("") || dto.getLastname().equals("")) throw new EmptyFieldException();
		
		if(dto.getFirstname().length() <= 2 || dto.getLastname().length() <= 2) throw new FirstLastNameLengthException();

		Teacher teacher = extract(dto);
		try
		{
			dao.insert(teacher);
			return true;
		}
		catch(SQLException exception)
		{
			throw exception;
		}
	}

	@Override
	public boolean deleteTeacher(int id) throws SQLException 
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
	public boolean updateTeacher(int id, String firstname, String lastname) throws SQLException, EmptyFieldException, FirstLastNameLengthException 
	{	
		if(firstname.equals("") || lastname.equals("")) throw new EmptyFieldException();
		
		if(firstname.length() <= 2 || lastname.length() <= 2) throw new FirstLastNameLengthException();
		
		try
		{
			dao.update(id, firstname, lastname);
			return true;
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			throw exception;
		}
	}

	@Override
	public Teacher searchTeacherById(int id) throws SQLException 
	{
		try
		{
			return dao.getTeacherById(id);
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			throw exception;
		}
	}
	
	public List<Teacher> getAllTeachers() throws SQLException
	{
		try
		{
			return dao.getAll();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			throw exception;
		}
	}
	
	private Teacher extract(TeacherDTO dto)
	{
		Teacher teacher = new Teacher();
		teacher.setId(dto.getId());
		teacher.setFirstname(dto.getFirstname());
		teacher.setLastname(dto.getLastname());
		
		return teacher;
	}
}
