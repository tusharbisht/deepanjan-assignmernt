package com.cab.taxi.service;

import com.cab.taxi.model.RideResponse;

public interface ICustomerService {

	RideResponse addNewRide(String pickupLocation, String dropLocation, String userID);

	RideResponse getUserHistory(String userID);

}
