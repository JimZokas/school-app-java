package service;

import java.sql.SQLException;
import java.util.List;

import dto.StudentDTO;
import exceptions.EmptyFieldException;
import exceptions.FirstLastNameLengthException;
import model.Student;

public interface IStudentService 
{
	
	/**
	 * Adds a student in the teacher list.
	 * @param studentDTO Added student information. 
	 * @throws SQLException
	 */
	boolean createStudent(StudentDTO dto) throws SQLException, EmptyFieldException, FirstLastNameLengthException;
	
	/**
	 * Deletes a student from the list.
	 * @param id Deleted student ID.
	 * @throws SQLException
	 */
	boolean deleteStudent(int id) throws SQLException;
	
	/**
	 * Updates a student from the list.
	 * @param id Student to be updated ID.
	 * @param firstname Student to be updated first name.
	 * @param lastname Student to be updated last name.
	 * @throws SQLException
	 */
	boolean updateStudent(int id, String firstname, String lastname) throws SQLException, EmptyFieldException, FirstLastNameLengthException;
	
	/**
	 * Searches a student from the list.
	 * @param id ID of student to search.
	 * @return Information of student found or null if not found.
	 * @throws SQLException
	 */
	Student searchStudentById(int id) throws SQLException;
	
	/**
	 * Gets every student from the list.
	 * @return A List of every student on the list or a null list if list is empty.
	 * @throws SQLException
	 */
	List<Student> getAllStudents() throws SQLException;
}
