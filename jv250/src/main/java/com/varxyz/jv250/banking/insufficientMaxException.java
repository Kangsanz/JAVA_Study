package com.varxyz.jv250.banking;

public class insufficientMaxException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public insufficientMaxException(String msg) {
		super(msg);
	}
}
