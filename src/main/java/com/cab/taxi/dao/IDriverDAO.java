package com.cab.taxi.dao;

import java.util.List;

import com.cab.taxi.model.Driver;
import com.cab.taxi.model.Ride;

public interface IDriverDAO {

	void addNewDriver(Driver driver);

	List<Ride> getDriverHistory(String driverId);

	void acceptRide(String rideID, String driverID);

	List<Ride> getRideDetails(String rideID);

	void updateRideStatus(String rideID, String status);

}
