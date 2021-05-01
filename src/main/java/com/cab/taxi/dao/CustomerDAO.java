package com.cab.taxi.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.cab.taxi.model.Ride;
import com.cab.taxi.mybatis.ITaxiMapper;

public class CustomerDAO implements ICustomerDAO {
	
	private static Integer id;
	
	@PostConstruct
	public void setId()
	{
		id = 0;
	}

	@Autowired
	ITaxiMapper taxiMapper;
	
	@Override
	public String addNewRide(Ride ride, String userID) {
		++id;
		taxiMapper.addNewRide(id.toString(), ride.getAmount(), ride.getDistance(), ride.getDropLocation(), ride.getPickupLocation(), ride.getRating(), ride.getStatus(), "0", userID);
			return id.toString();
	}

	@Override
	public List<Ride> getUserHistory(String userID) {
		return taxiMapper.getUserHistory(userID);
	}

}
