package com.cab.taxi.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cab.taxi.model.Ride;

public interface ITaxiMapper {
	public void addNewDriver(@Param(value = "driverID") String driverID, @Param(value = "name") String name, @Param(value = "phoneNumber") String phoneNumber);

	public List<Ride> getDriverHistory(@Param(value = "driverID") String driverID);

	public void acceptRide(@Param(value = "rideID") String rideID, @Param(value = "driverID") String driverID);

	public List<Ride> getRideDetails(@Param(value = "rideID") String rideID);

	public void updateRideStatus(@Param(value = "rideID") String rideID, @Param(value = "status") String status);

	public void addNewRide(String rideID, String amount, String distance, String dropLocation, String pickupLocation,
			String rating, String status, String driverID, String userID);

	public List<Ride> getUserHistory(String userID);
}
