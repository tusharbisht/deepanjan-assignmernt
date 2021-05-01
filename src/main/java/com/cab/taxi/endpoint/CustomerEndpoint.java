package com.cab.taxi.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cab.taxi.model.RideResponse;
import com.cab.taxi.service.ICustomerService;

@RestController
@EnableAutoConfiguration
public class CustomerEndpoint {
	
	@Autowired
	ICustomerService customerService;
	
	@RequestMapping(value = "/ride/new", method = RequestMethod.POST)
	public RideResponse addNewRide(@RequestBody String pickupLocation, @RequestBody String dropLocation, @RequestBody String userID)
	{
		RideResponse response = customerService.addNewRide(pickupLocation,dropLocation, userID);
		return response;
	}
	
	@GetMapping("/rides")
	public RideResponse getUserHistory(@PathVariable("userID") String userID)
	{
		RideResponse response = customerService.getUserHistory(userID);
		return response;
	}

}
