// Julien Phan, ID:40133814
// COMP249
// Assignment 3
// March 30th, 2020

/**
 * 
 * @author julienphan
 *
 */
public class FileInvalidException extends Exception {

	/**
	 * 
	 */
	// Default Message
	public FileInvalidException() {
		super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)");

	}

	/**
	 * 
	 * @param message            A variable of type String
	 * @param enableSuppression  A variable of type boolean
	 * @param writableStackTrace A variable of type boolean
	 */
	// Mutable Message
	public FileInvalidException(String message, boolean enableSuppression, boolean writableStackTrace) {
		super(message, null, enableSuppression, writableStackTrace);
	}

	/**
	 * 
	 * @param message A variable of type String
	 * @param cause
	 */
	public FileInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * @param cause
	 */
	public FileInvalidException(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 * @param message
	 */
	public FileInvalidException(String message) {
		super(message);
	}

}