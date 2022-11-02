package service;

import java.sql.SQLException;
import java.util.List;

import dao.IStudentDAO;
import dto.StudentDTO;
import exceptions.EmptyFieldException;
import exceptions.FirstLastNameLengthException;
import model.Student;

public class StudentServiceImpl implements IStudentService {

	private final IStudentDAO dao;
	
	public StudentServiceImpl(IStudentDAO dao)
	{
		this.dao = dao;
	}
	
	@Override
	public boolean createStudent(StudentDTO dto) throws SQLException, EmptyFieldException, FirstLastNameLengthException 
	{
		if(dto.getFirstname().equals("") || dto.getLastname().equals("")) throw new EmptyFieldException();
		
		if(dto.getFirstname().length() <= 2 || dto.getLastname().length() <= 2) throw new FirstLastNameLengthException();
		
		Student student = extract(dto);
		try
		{
			dao.insert(student);
			return true;
		}
		catch(SQLException exception)
		{
			throw exception;
		}
	}

	@Override
	public boolean deleteStudent(int id) throws SQLException 
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
	public boolean updateStudent(int id, String firstname, String lastname) throws SQLException, EmptyFieldException, FirstLastNameLengthException 
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
	public Student searchStudentById(int id) throws SQLException {
		try
		{
			return dao.getStudentById(id);
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			throw exception;
		}
	}
	
	public List<Student> getAllStudents() throws SQLException
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

	private Student extract(StudentDTO dto)
	{
		Student student = new Student();
		student.setId(dto.getId());
		student.setFirstname(dto.getFirstname());
		student.setLastname(dto.getLastname());
		
		return student;
	}
}
