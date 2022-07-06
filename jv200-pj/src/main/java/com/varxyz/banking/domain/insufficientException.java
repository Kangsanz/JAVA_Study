package com.varxyz.banking.domain;

public class insufficientException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public insufficientException(String msg) {
		super(msg);
	}
}
