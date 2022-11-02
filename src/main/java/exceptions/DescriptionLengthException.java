package exceptions;


public class DescriptionLengthException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public DescriptionLengthException()
	{
		super("Description field must be at least 3 characters in length");
	}
}