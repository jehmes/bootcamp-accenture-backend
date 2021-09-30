package com.br.customException;

public class customException extends Exception {

	private static final long serialVersionUID = 1L;
	
	
	public customException(String msg) {
		super(msg);
	}

	
	public customException(String msg, Throwable cause) {
		 super(msg, cause);
	}
}
