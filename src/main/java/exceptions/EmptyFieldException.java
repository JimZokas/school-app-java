package exceptions;

public class EmptyFieldException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public EmptyFieldException()
	{
		super("Can't have empty fields");
	}
}
