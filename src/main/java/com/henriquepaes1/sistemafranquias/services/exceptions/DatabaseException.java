package com.henriquepaes1.sistemafranquias.services.exceptions;

public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DatabaseException(String msg) {
		super("Não é possível deletar a entidade pois existem associações:" +System.lineSeparator()+ msg);
	}

}
