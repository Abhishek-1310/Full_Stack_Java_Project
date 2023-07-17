package com.abhishek.asset.exception;

public class MaximumDeviceLimitReachedException extends RuntimeException{

	/**
	 * 
	 */
	public MaximumDeviceLimitReachedException() {
        super("Maximum device limit reached for this employee");
    }
	private static final long serialVersionUID = 1L;
	
	public MaximumDeviceLimitReachedException(String message) {
		super(message);
	}
	
}
