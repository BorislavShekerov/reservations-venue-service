package com.boris.venues.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boris.venues.model.Table;
import com.boris.venues.model.Venue;
import com.boris.venues.service.VenueService;

@RestController
@EnableEurekaClient
@EnableDiscoveryClient
public class VenueController {
	
	@Autowired
	VenueService venueService;
	
	@GetMapping("/venues/")
	public List<Venue> getAllVenues() {
		return venueService.getAllVenues();
	}
	
	@GetMapping("/venues/{venueId}")
	public Venue getVenue(@PathVariable String venueId) {
		return venueService.getVenueForId(venueId);
	}
	
	@PostMapping("/venues/")
	public Venue addVenue(@RequestBody Venue venueToAdd) {
		return venueService.addVenue(venueToAdd);
	}
	
	@GetMapping("/venues/{venueId}/tables")
	public List<Table> getTablesForVenue(@PathVariable String venueId) {
		return venueService.getTablesForVenue(venueId);
	}
	
}
