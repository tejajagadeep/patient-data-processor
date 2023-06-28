package com.cts.patientdataprocessor.exception;

public class IdAlredyExistsException extends RuntimeException{
	
	/**
	 * IdAlredyExistsException Exception
	 */
	private static final long serialVersionUID = 1L;

	public IdAlredyExistsException(String msg) {

		super(msg);
	}
}
