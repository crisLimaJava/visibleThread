package ie.com.visibleThread.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class TextNotPresentException extends RuntimeException{

	private static final long serialVersionUID = -5020621846447476462L;
	
	private final HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

	public TextNotPresentException(String msg) {
		super(msg);
	}

	public HttpStatus getStatus() {
		return status;
	}

}
