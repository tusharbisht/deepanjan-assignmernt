package com.cab.taxi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cab.taxi.model.Driver;
import com.cab.taxi.model.Ride;
import com.cab.taxi.mybatis.ITaxiMapper;

public class DriverDAO implements IDriverDAO{
	
	@Autowired
	ITaxiMapper taxiMapper;

	@Override
	public void addNewDriver(Driver driver) {
		taxiMapper.addNewDriver(driver.getId(), driver.getName(), driver.getPhoneNumber());
	}

	@Override
	public List<Ride> getDriverHistory(String driverId) {
		return taxiMapper.getDriverHistory(driverId);
	}

	@Override
	public void acceptRide(String rideID, String driverID) {
		taxiMapper.acceptRide(rideID,driverID);
		
	}

	@Override
	public List<Ride> getRideDetails(String rideID) {
		return taxiMapper.getRideDetails(rideID);
	}

	@Override
	public void updateRideStatus(String rideID, String status) {
		taxiMapper.updateRideStatus(rideID,status);		
	}

}
