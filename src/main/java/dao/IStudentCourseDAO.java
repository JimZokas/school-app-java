package dao;

import java.sql.SQLException;
import java.util.List;

import model.Course;

public interface IStudentCourseDAO 
{
	boolean insert(int studentId, int courseId) throws SQLException;
	boolean delete(int courseId) throws SQLException;
	List<Course> getAll(int studentId) throws SQLException;
	List<Course> getNotStarted(int studentId) throws SQLException;
}
