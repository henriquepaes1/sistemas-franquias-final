package com.henriquepaes1.sistemafranquias.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Long id) {
		super("Resource with id " + id + " not found");
	}

}
