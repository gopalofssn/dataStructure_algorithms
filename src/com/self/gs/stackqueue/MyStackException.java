package com.self.gs.stackqueue;

public class MyStackException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String msg;
    public MyStackException() {
    }
    
    public MyStackException(String exp) {
    	this.msg = exp;
    }
}
