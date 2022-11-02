package dao;

import java.sql.SQLException;
import java.util.List;

import model.Course;

public interface ICourseDAO 
{
	boolean insert(String description, int teacherId) throws SQLException;
	boolean delete(int id) throws SQLException;
	boolean update(int id, String description, int teacherId) throws SQLException;
	List<Course> getAll() throws SQLException;
}
