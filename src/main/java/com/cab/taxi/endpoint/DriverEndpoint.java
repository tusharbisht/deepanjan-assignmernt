package com.cab.taxi.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cab.taxi.model.Driver;
import com.cab.taxi.model.DriverResponse;
import com.cab.taxi.model.RideResponse;
import com.cab.taxi.service.IDriverService;

@RestController
@EnableAutoConfiguration
public class DriverEndpoint {
	
	@Autowired
	private IDriverService driverService;
	
	@RequestMapping(value = "/drivers/new", method = RequestMethod.POST)
	public DriverResponse addDriver(@RequestBody Driver driver)
	{
		DriverResponse response = driverService.addDriver(driver);
		return response;
	}
	
	@GetMapping("/driver/{driverId}/rides")
	public RideResponse getDriverHistory(@PathVariable("driverId") String driverId)
	{
		RideResponse response = driverService.getDriverHistory(driverId);
		return response;
	}
	
	@RequestMapping(value = "/ride/{rideID}/{driverID}/accept-ride", method = RequestMethod.POST)
	public RideResponse acceptRide(@PathVariable("rideID") String rideID, @PathVariable("driverID") String driverID)
	{
		RideResponse response = driverService.acceptRide(rideID, driverID);
		return response;
	}
	
	@RequestMapping(value = "/ride/{rideID}/update-status", method = RequestMethod.POST)
	public RideResponse updateRideStatus(@PathVariable("rideID") String rideID, @RequestBody String status)
	{
		RideResponse response = driverService.updateRideStatus(rideID, status);
		return response;
	}

}