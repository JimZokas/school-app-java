package exceptions;


public class TeacherIdNotFoundException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public TeacherIdNotFoundException(int id)
	{
		super("No teachers found with ID " + id);
	}
}
