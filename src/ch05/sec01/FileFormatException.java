package ch05.sec01;

import java.io.IOException;

public class FileFormatException extends IOException {
	private static final long serialVersionUID = 1L;

	public FileFormatException() {}
	
	public FileFormatException(String message) {
		super(message);
	}
	
	public FileFormatException(Throwable cause) {
		initCause(cause);
	}
	
	public FileFormatException(String message, Throwable cause) {
		super(message);
		initCause(cause);
	}
}
