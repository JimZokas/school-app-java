package exceptions;

public class FirstLastNameLengthException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public FirstLastNameLengthException()
	{
		super("First and last name must be at least 3 characters in length");
	}
}
