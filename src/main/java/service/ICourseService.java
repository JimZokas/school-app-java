package service;

import java.sql.SQLException;
import java.util.List;

import exceptions.DescriptionLengthException;
import exceptions.EmptyFieldException;
import model.Course;

public interface ICourseService 
{
	
	/**
	 * Adds a course in the list.
	 * @param courseDTO Information of course to add.
	 * @throws SQLException
	 */
	boolean createCourse(String description, int teacherId) throws SQLException, EmptyFieldException, DescriptionLengthException;
	
	/**
	 * Deletes a course from the list.
	 * @param id ID of course to be deleted.
	 * @throws SQLException
	 */
	boolean deleteCourse(int id) throws SQLException;
	
	/**
	 * Updates a course from the list.
	 * @param id ID of course to be updated.
	 * @param description Description of course to be updated
	 * @throws SQLException
	 */
	boolean updateCourse(int id, String description, int teacherId) throws SQLException, EmptyFieldException, DescriptionLengthException;
	
	/**
	 * Gets a List of all courses or a null list if list is null.
	 * @return List of all courses.
	 * @throws SQLException
	 */
	List<Course> getCourses() throws SQLException;
}
