package com.cab.taxi.service;

import com.cab.taxi.model.Driver;
import com.cab.taxi.model.DriverResponse;
import com.cab.taxi.model.RideResponse;

public interface IDriverService {

	DriverResponse addDriver(Driver driver);

	RideResponse getDriverHistory(String driverId);

	RideResponse acceptRide(String rideID, String driverID);

	RideResponse updateRideStatus(String rideID, String status);

}
