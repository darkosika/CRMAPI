package com.okaplan.demo.entity;


public class exception {
	
	private int status;
	
	private String message;
	
	private long time;

	public exception() {}
	

	public exception(int status, String message, long time) {
		super();
		this.status = status;
		this.message = message;
		this.time = time;
	}



	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	

}
