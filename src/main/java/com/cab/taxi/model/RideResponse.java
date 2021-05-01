package com.cab.taxi.model;

import java.util.List;

public class RideResponse {
	private Boolean success;
	private String message;
	private List<Ride> rides;
	private int nextPage;
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
	public List<Ride> getRides() {
		return rides;
	}
	public void setRides(List<Ride> rides) {
		this.rides = rides;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public RideResponse() {
		this.success = false;
		this.message = "No Rides Taken";
		this.rides = null;
		this.nextPage = 0;
	}
	
}
