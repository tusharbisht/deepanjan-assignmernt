package com.cab.taxi.model;

public class DriverResponse {
	private Boolean success;
	private String message;
	private Driver driver;
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public DriverResponse() {
		this.success = false;
		this.message = new String("Driver couldn't be added!!!");
		this.driver = null;
	}
}
