package com.example.demo.exceptionhandler;

public class TheatreNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public TheatreNotFoundException(String msg) {
		
		super(msg);
	}

}
