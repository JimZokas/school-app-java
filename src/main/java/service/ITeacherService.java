package service;

import java.sql.SQLException;
import java.util.List;

import dto.TeacherDTO;
import exceptions.EmptyFieldException;
import exceptions.FirstLastNameLengthException;
import model.Teacher;

public interface ITeacherService 
{
	/**
	 * Adds a teacher in the teacher list.
	 * @param teacherDTO Added teacher information.
	 * @throws SQLException
	 */
	boolean createTeacher(TeacherDTO dto) throws SQLException, EmptyFieldException, FirstLastNameLengthException;
	
	/**
	 * Deletes a teacher from the list.
	 * @param id Deleted teacher ID.
	 * @throws SQLException
	 */
	boolean deleteTeacher(int id) throws SQLException;
	
	/**
	 * Updates a teacher from the list.
	 * @param id Teacher to be updated ID.
	 * @param firstname Teacher to be updated first name.
	 * @param lastname Teacher to be updated last name.
	 * @throws SQLException
	 */
	boolean updateTeacher(int id, String firstname, String lastname) throws SQLException, EmptyFieldException, FirstLastNameLengthException;
	
	/**
	 * Searches a teacher from the list.
	 * @param id ID of teacher to search.
	 * @return Information of teacher found or null if not found.
	 * @throws SQLException
	 */
	Teacher searchTeacherById(int id) throws SQLException;
	
	/**
	 * Gets every teacher from the list.
	 * @return A List of every teacher on the list or a null list if list is empty.
	 * @throws SQLException
	 */
	List<Teacher> getAllTeachers() throws SQLException;
}
