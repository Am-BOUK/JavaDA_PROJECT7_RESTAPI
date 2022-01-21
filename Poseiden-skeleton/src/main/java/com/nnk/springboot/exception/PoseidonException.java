package com.nnk.springboot.exception;

public class PoseidonException extends Exception{
	
	private String message;

	public PoseidonException(String message) {
		super();
		this.message = message;
	}
	
	
	
}
