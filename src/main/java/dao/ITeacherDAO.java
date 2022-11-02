package dao;

import java.sql.SQLException;
import java.util.List;

import model.Teacher;

public interface ITeacherDAO 
{
	boolean insert(Teacher teacher) throws SQLException;
	boolean delete(int id) throws SQLException;
	boolean update(int id, String firstname, String lastname) throws SQLException;
	Teacher getTeacherById(int id) throws SQLException;
	List<Teacher> getAll() throws SQLException;
}
