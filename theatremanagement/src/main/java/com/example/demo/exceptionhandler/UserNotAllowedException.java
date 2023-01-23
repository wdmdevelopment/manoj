package com.example.demo.exceptionhandler;

public class UserNotAllowedException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public UserNotAllowedException(String msg) {
			
			super(msg);
		}
}
