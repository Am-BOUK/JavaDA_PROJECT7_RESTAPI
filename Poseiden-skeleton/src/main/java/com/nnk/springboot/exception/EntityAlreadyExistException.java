package com.nnk.springboot.exception;

public class EntityAlreadyExistException extends PoseidonException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityAlreadyExistException(String message) {
		super(message);
	}

}
