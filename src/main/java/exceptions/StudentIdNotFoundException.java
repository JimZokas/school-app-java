package exceptions;

public class StudentIdNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public StudentIdNotFoundException(String lastname)
	{
		super("No students found with ID " + lastname);
	}
}
