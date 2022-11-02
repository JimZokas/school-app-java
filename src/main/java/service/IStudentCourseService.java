package service;

import java.sql.SQLException;
import java.util.List;

import model.Course;

public interface IStudentCourseService 
{
	
	/**
	 * Adds a student to a course.
	 * @param studentId ID of student to be added.
	 * @param courseId ID of course to be added to.
	 * @throws SQLException
	 */
	boolean startCourse(int studentId, int courseId) throws SQLException;
	
	/**
	 * Deletes a student from a course.
	 * @param studentId ID of student to be deleted from course.
	 * @throws SQLException
	 */
	boolean stopCourse(int courseId) throws SQLException;
	
	/**
	 * Gets a List of courses that one student is enrolled to.
	 * @param studentId ID of student.
	 * @return List of enrolled courses.
	 * @throws SQLException
	 */
	List<Course> getCourses(int studentId) throws SQLException;
	
	/**
	 * Gets a list of courses that one student is not attending.
	 * @param studentId ID of student.
	 * @return List of courses that the student is not enrolled.
	 * @throws SQLException
	 */
	List<Course> getNotStartedCourses(int studentId) throws SQLException;
}
