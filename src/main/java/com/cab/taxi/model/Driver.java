package com.cab.taxi.model;

public class Driver {
	private String driverId;
	private String name;
	private String phoneNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getId() {
		return driverId;
	}
	public void setId(String id) {
		this.driverId = id;
	}
}