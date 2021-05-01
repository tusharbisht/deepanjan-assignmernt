package com.cab.taxi.dao;

import java.util.List;

import com.cab.taxi.model.Ride;

public interface ICustomerDAO {

	String addNewRide(Ride ride, String userID);

	List<Ride> getUserHistory(String userID);

}
