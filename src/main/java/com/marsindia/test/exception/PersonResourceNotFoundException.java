/**
 * 
 */
package com.marsindia.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author tumbeswar
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonResourceNotFoundException(String message) {
		super(message);
	}

	public PersonResourceNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
