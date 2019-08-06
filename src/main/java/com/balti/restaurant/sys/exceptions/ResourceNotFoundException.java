package com.balti.restaurant.sys.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String string) {
		super(string);
	}
}
