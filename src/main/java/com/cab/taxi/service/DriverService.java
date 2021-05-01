package com.cab.taxi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cab.taxi.dao.IDriverDAO;
import com.cab.taxi.model.Driver;
import com.cab.taxi.model.DriverResponse;
import com.cab.taxi.model.Ride;
import com.cab.taxi.model.RideResponse;

public class DriverService implements IDriverService {
	
	@Autowired
	IDriverDAO driverDAO;

	@Override
	public DriverResponse addDriver(Driver driver) {
		DriverResponse response = new DriverResponse();
		if(isValidDriver(driver)) {
			driverDAO.addNewDriver(driver);
			response.setDriver(driver);
			response.setMessage("Driver Addedd Successfully");
			response.setSuccess(true);
		}
		return response;
	}

	private boolean isValidDriver(Driver driver) {
		if(driver.getName() != null && driver.getPhoneNumber() != null) {
			return true;
		}
		return false;
	}

	@Override
	public RideResponse getDriverHistory(String driverId) {
		RideResponse response = new RideResponse();
		List<Ride> rides = driverDAO.getDriverHistory(driverId);
		if(!rides.isEmpty()) {
			response.setMessage("Ride Data Found");
			response.setRides(rides);
			response.setSuccess(true);
		}
		return response;
	}

	@Override
	public RideResponse acceptRide(String rideID, String driverID) {
		RideResponse response = new RideResponse();
		driverDAO.acceptRide(rideID, driverID);
		List<Ride> ride = driverDAO.getRideDetails(rideID);
		response.setMessage("Ride Accepted Successfully");
		response.setRides(ride);
		response.setSuccess(true);
		return response;
	}

	@Override
	public RideResponse updateRideStatus(String rideID, String status) {
		RideResponse response = new RideResponse();
		driverDAO.updateRideStatus(rideID, status);
		List<Ride> ride = driverDAO.getRideDetails(rideID);
		response.setMessage("Ride Updated Successfully");
		response.setRides(ride);
		response.setSuccess(true);
		return response;
	}

}
