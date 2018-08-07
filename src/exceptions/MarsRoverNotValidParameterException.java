package exceptions;

public class MarsRoverNotValidParameterException extends MarsRoverException {

	private static final long serialVersionUID = 1L;
	
	public MarsRoverNotValidParameterException(String string) {
		super(string);
	}
	
	public MarsRoverNotValidParameterException() {
	    super("");
	}

}
