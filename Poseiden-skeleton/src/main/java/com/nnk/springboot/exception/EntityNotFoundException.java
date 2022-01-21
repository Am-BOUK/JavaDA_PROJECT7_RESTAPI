package com.nnk.springboot.exception;

public class EntityNotFoundException extends PoseidonException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String message) {
		super(message);
	}

}
