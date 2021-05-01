package com.cab.taxi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cab.taxi.dao.ICustomerDAO;
import com.cab.taxi.dao.IDriverDAO;
import com.cab.taxi.model.Ride;
import com.cab.taxi.model.RideResponse;

public class CustomerService implements ICustomerService {
	
	@Autowired
	ICustomerDAO customerDAO;
	
	@Autowired
	IDriverDAO driverDAO;

	@Override
	public RideResponse addNewRide(String pickupLocation, String dropLocation, String userID) {
		RideResponse response = new RideResponse();
		Ride ride = createNewRide(pickupLocation, dropLocation);
		String rideID = customerDAO.addNewRide(ride,userID);
		List<Ride> rides = driverDAO.getRideDetails(rideID);
		response.setMessage("Ride Accepted Successfully");
		response.setRides(rides);
		response.setSuccess(true);
		return response;
	}

	private Ride createNewRide(String pickupLocation, String dropLocation) {
		Ride ride = new Ride();
		ride.setAmount(calculateAmount(pickupLocation, dropLocation));
		ride.setDistance(calculateDistance(pickupLocation, dropLocation));
		ride.setDropLocation(dropLocation);
		ride.setPickupLocation(pickupLocation);
		ride.setRating("N/A");
		ride.setStatus("NEW RIDE");
		return ride;
	}

	private String calculateAmount(String pickupLocation, String dropLocation) {
		// Setting a flat price of 100 per ride
		return new String("100");
	}
	
	private String calculateDistance(String pickupLocation, String dropLocation) {
		// Setting a flat distance of 10km
		return new String("10");
	}

	@Override
	public RideResponse getUserHistory(String userID) {
		RideResponse response = new RideResponse();
		List<Ride> rides = customerDAO.getUserHistory(userID);
		if(!rides.isEmpty()) {
			response.setMessage("Ride Data Found");
			response.setRides(rides);
			response.setSuccess(true);
		}
		return response;
	}

}
