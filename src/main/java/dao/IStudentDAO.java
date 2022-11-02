package dao;

import java.sql.SQLException;
import java.util.List;

import model.Student;

public interface IStudentDAO 
{
	boolean insert(Student student) throws SQLException;
	boolean delete(int id) throws SQLException;
	boolean update(int id, String firstname, String lastname) throws SQLException;
	Student getStudentById(int id) throws SQLException;
	List<Student> getAll() throws SQLException;
}
