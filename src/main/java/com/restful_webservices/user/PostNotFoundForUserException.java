package com.restful_webservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PostNotFoundForUserException extends RuntimeException {
	
	public PostNotFoundForUserException(String message) {
		super(message);
	}

}
