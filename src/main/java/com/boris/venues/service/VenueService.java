package com.boris.venues.service;

import java.util.List;

import com.boris.venues.model.Table;
import com.boris.venues.model.Venue;

public interface VenueService {

	List<Venue> getAllVenues();

	Venue getVenueForId(String venueId);

	Venue addVenue(Venue venueToAdd);

	List<Table> getTablesForVenue(String dummyVenueId1);

	List<Venue> searchVenues(String searchStr);
}
