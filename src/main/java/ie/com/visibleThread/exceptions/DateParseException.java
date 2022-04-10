package ie.com.visibleThread.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
public class DateParseException extends RuntimeException{

	private static final long serialVersionUID = -5020621846447476462L;
	
	private final HttpStatus status = HttpStatus.PRECONDITION_FAILED;

	public DateParseException(String msg) {
		super(msg);
	}

	public HttpStatus getStatus() {
		return status;
	}

}
